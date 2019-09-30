package programmers.stackAndQueue.problem.level2.solution.printer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/42587/solution_groups?language=java

public class Programmers {

	/**
	 * 
	 * solution1
	 * 
	 * - 작성자 : 최원준 , 송영제 , 이민아 , 최경식 , Chiseunglee
	 * 
	 * @param priorities
	 * @param location
	 * @return
	 * 
	 */
	public int solution1(int[] priorities, int location) {
		
		int answer = 0;
		int l = location;
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		for (int i : priorities) {
			
			que.add(i);
			
		}
		
		Arrays.sort(priorities);
		int size = priorities.length-1;
		
		while(!que.isEmpty()) {
			
			Integer i = que.poll();
			
			if (i == priorities[size - answer]) {
				
				answer++;
				l--;
				
				if (l < 0) {
					
					break;
					
				}
				
			} else {
				
				que.add(i);
				l--;
				
				if (l < 0) {
					
					l = que.size()-1;
					
				}
				
			}
			
		}
		
		return answer;
		
	}
	
}
