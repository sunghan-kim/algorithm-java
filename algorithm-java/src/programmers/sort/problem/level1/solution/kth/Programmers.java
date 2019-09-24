package programmers.sort.problem.level1.solution.kth;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42748/solution_groups?language=java

/**
 * 
 * @author shkim
 * 
 * ���α׷��ӽ� �ٸ� ����� Ǯ�� ���
 *
 */

public class Programmers {

	/**
	 * 
	 * solution1
	 * 
	 * - �ۼ��� : ��� , ����� , - , ������ , - �� 6 ��
	 * 
	 * - ��
	 *   - Arrays�� "copyOfRange" �޼��带 Ȱ���Ͽ� Ư�� �ε��� ���� �迭 ����
	 *   - ���߹迭 �ε��� �� Ȯ��
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
	 * - �ۼ��� : Heera Kim , �輼��
	 * 
	 * - ��
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
