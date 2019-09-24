package programmers.sort.problem.level1.solution.kth;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42748/solution_groups?language=java

/**
 * 
 * @author shkim
 * 
 * 프로그래머스 다른 사람의 풀이 목록
 *
 */

public class Programmers {

	/**
	 * 
	 * solution1
	 * 
	 * - 작성자 : 기웅 , 김기준 , - , 김윤희 , - 외 6 명
	 * 
	 * - 팁
	 *   - Arrays의 "copyOfRange" 메서드를 활용하여 특정 인덱스 안의 배열 추출
	 *   - 이중배열 인덱싱 팁 확인
	 * 
	 * 
	 * @param array
	 * @param commands
	 * @return answer
	 * 
	 */
	public int[] solution1(int[] array, int[][] commands) {
		
		int [] answer = new int[commands.length];
		
		for (int i=0; i < commands.length; i++) {
			
			int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(temp);
			answer[i] = temp[commands[i][2]-1];
			
		}
		
		return answer;
		
	}
	
	/**
	 * 
	 * solution2
	 * 
	 * - 작성자 : Heera Kim , 김세영
	 * 
	 * - 팁
	 *   -  
	 * 
	 * @param array
	 * @param commands
	 * @return answer
	 */
	public int[] solution2(int[] array, int[][] commands) {
		
		int[] answer = new int[commands.length];
				
		for (int i=0; i < commands.length; i++) {
			
			int start = commands[i][0] == 0 ? 0 : commands[i][0]-1;
			int finish = commands[i][1] == commands[i][0] ? start+1 : commands[i][1];
			int pos = commands[i][2]-1;
			
			int[] tmp = Arrays.copyOfRange(array, start, finish);
			
			Arrays.sort(tmp);
			
			answer[i] = tmp[pos];
			
		}
		
		return answer;
		
	}
	
	
	
}
