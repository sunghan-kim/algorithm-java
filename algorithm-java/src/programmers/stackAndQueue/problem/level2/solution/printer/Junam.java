package programmers.stackAndQueue.problem.level2.solution.printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// https://ju-nam2.tistory.com/38

public class Junam {

	public int solution(int[] priorities, int location) {
		
		// answer는 내가 원하는 프린트의 출력 순서
		// index는 우선순위에 맞춰 변하는 배열의 index를 표시하기 위한 변수
		// max_change
		//  - max_change = 0 : 우선순위 최대값이 변하지 않음
		//  - max_change = 1 : 우선순위를 변경시켜야 한다는 것을 표시하는 변수
		int answer = 0;
		int index = 0;
		int max_change = 0;
		
		ArrayList<Integer> prior = new ArrayList<Integer>();
		
		for (int i=0; i < priorities.length; i++) {
			
			prior.add(priorities[i]);
			
		}
		
		System.out.println(prior);
		
		// Collections.max()를 사용하면 변하는 최댓값을 찾기 힘듬
		// 그래서 내림차순으로 만들어 사용
		Collections.reverse(prior);
		
		int max = prior.get(0);
		
		while(true) {
			
			// index를 돌면서 max값과 같아지면 프린트하고 그 수를 -1로 만듬
			// 하나를 출력하였으므로 answer에 추가하고 최대 우선순위를 가진 프린트가 출력되었으므로,
			// max_change 스위치를 1로 변경
			if (priorities[index] == max) {
				
				priorities[index] = -1;
				answer++;
				max_change = 1;
				
			} else {
				
				// index를 돌게하기 위해서 최대값이 아니라면 1씩 증가시켜주고
				// 끝까지 간다면 0으로 만들어줌
				if (index == priorities.length-1) {
					
					index = 0;
					
				} else {
					
					index++;
					
				}
				
			}
			
			// 원하는 location의 프린트가 출력되어서 -1이 되면 break
			if (priorities[location] == -1) {
				break;
			}
			
			// max_change가 1이 되면 현재의 최대 
			
		}
		
		
		return answer;
		
	}
	
}
