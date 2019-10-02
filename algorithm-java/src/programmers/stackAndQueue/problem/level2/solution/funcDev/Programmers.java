package programmers.stackAndQueue.problem.level2.solution.funcDev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/42586/solution_groups?language=java

/**
 * 
 * @author shkim
 * 
 * # ���α׷��ӽ� - ��ɰ��� - �ٸ� ����� Ǯ��
 *
 */

public class Programmers {

	/**
	 * 
	 * solution1
	 * 
	 *  - ����� , �輼�� , ���缺 , Leenamgyo , ������ �� 6 ��
	 *  - ���ٽ� ���
	 *  
	 *  - ������ : ����
	 * 
	 * @param progresses
	 * @param speeds
	 * @return
	 * 
	 * 
	 */
	public int[] solution1(int[] progresses, int[] speeds) {
		
		int [] dayOfend = new int [100];
		
		int day = -1;
		
		for (int i=0; i < progresses.length; i++) {
			
			while (progresses[i] + (day*speeds[i]) < 100) {
				
				day++;
				
			}
			
			dayOfend[day]++;
			
		}
		
		return Arrays.stream(dayOfend).filter(i -> i != 0).toArray();
		
	}
	
	/**
	 * 
	 * solution2
	 * 
	 *  - HamYoungChan , �̽¹� , KimMinHyuk8375
	 * 
	 *  - ������ : ����
	 * 
	 * @param progresses
	 * @param speeds
	 * @return
	 * 
	 */
	public int[] solution2(int[] progresses, int[] speeds) {
		
		Queue<Integer> q = new LinkedList<>();
		List<Integer> answerList = new ArrayList<>();
		
		for (int i=0; i < speeds.length; i++) {
			
			double remain = (100 - progresses[i]) / (double) speeds[i];
			
			int date = (int) Math.ceil(remain);
			
			
			if (!q.isEmpty() && q.peek() < date) {
				
				answerList.add(q.size());
				q.clear();
				
			}
			
			q.offer(date);
		}
		
		answerList.add(q.size());
		
		int[] answer = new int[answerList.size()];
		
		for (int i=0; i < answer.length; i++) {
			
			answer[i] = answerList.get(i);
			
		}
		
		return answer;
		
	}
	
	/**
	 * 
	 * solution3
	 * 
	 * @param progresses
	 * @param speeds
	 * @return
	 * 
	 */
	public int[] solution3(int[] progresses, int[] speeds) {
		
		Solution3 s3 = new Solution3();
		
		return s3.solution3(progresses, speeds);
		
	}
	
	
	
	
}
