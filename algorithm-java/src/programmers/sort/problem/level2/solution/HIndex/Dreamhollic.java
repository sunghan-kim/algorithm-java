package programmers.sort.problem.level2.solution.HIndex;

import java.util.ArrayList;
import java.util.Collections;

// https://dreamhollic.tistory.com/entry/Programmers-21-HIndex-JAVA

public class Dreamhollic {

	public int solution1(int[] citations) {
		
		int answer = 0;
		
		// Array Descending Sort
		ArrayList<Integer> arr = new ArrayList<>();
		
		for (int k=0; k < citations.length; k++) {
			
			arr.add(citations[k]);
			
		}
		
		Collections.sort(arr);
		Collections.reverse(arr);
		
		System.out.println(arr);
		
		for (int i=0; i < arr.size()+1; i++) {
			
			if (i == arr.size()) {
				
				answer = i;
				
			} else if (arr.get(i) <= i) {
				
				answer = i;
				break;
				
			}
			
		}
		
		
		return answer;
		
	}
	
	public static void main(String[] args) {
		
		int[] citations = {3, 0, 6, 1, 5};
		
		Dreamhollic dh = new Dreamhollic();
		
		int answer1 = dh.solution1(citations);
		
		System.out.println("answer1 : " + answer1);
		
	}
	
}
