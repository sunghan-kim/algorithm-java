package programmers.sort.problem.level2.solution.HIndex;

import java.util.Arrays;

// https://jar100.tistory.com/22

public class Jar100 {

	/**
	 * 
	 * @param citations
	 * @return
	 * 
	 * - 제출결과 : 성공
	 */
	public int solution(int[] citations) {
		
		int answer = 0;
		int length = citations.length;
		int h = 0;
		int k = 0;
		Arrays.sort(citations);
		
		for (int i=0; i < citations.length; i++) {
			
			h = citations[i];
			k = citations.length - i;
			
			if (k <= h) {
				
				answer = k;
				break;
				
			}
			
		}
		
		return answer;
		
	}
	
	public static void main(String[] args) {
		
		int[] citations = {3, 0, 6, 1, 5};
		
		Jar100 jar = new Jar100();
		
		int answer = jar.solution(citations);
		
	}
	
}
