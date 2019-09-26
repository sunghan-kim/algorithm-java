package programmers.sort.problem.level2.solution.biggest;

import java.util.Arrays;
import java.util.Comparator;

// https://dreamhollic.tistory.com/entry/programmers-16-%EA%B0%80%EC%9E%A5-%ED%81%B0-%EC%88%98-JAVA

public class Dreamholic {

	
	/**
	 * 
	 * @param numbers
	 * @return
	 * 
	 * - 제출 결과 : 성공
	 */
	public String solution(int[] numbers) {
		
		String answer = "";
		
		String[] num = new String[numbers.length];
		
		for (int i=0; i < num.length; i++) {
			
			num[i] = String.valueOf(numbers[i]);
			
		}
		
		Arrays.sort(num, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2+o1).compareTo(o1+o2);
			}
			
		});
		
		if (num[0].equals("0")) {
			answer += "0";
		} else {
			
			for (int j=0; j < num.length; j++) {
				
				answer += num[j];
				
			}
			
		}
		
		return answer;
		
	}
	
}
