package programmers.sort.usage.numberOfCases.permutation;

import java.util.LinkedList;

// https://limkydev.tistory.com/178

/**
 * 
 * @author shkim
 * 
 * # 순열 (permutation)
 * 
 *   - 순서있게 배열한다.
 *   - 순서 상관 있음
 *
 */

public class PermutationUsage {

	public static void permutation(int n, int r, LinkedList<Integer> perArr, int[] perCheck) {
		
		if (perArr.size() == r) {
			
			for (int i : perArr) {
				
				System.out.print(i + " ");
				
			}
			
			System.out.println();
			return;
			
		}
		
		for (int i=0; i < n; i++) {
			
			if (perCheck[i] == 0) {
				
				perArr.add(i);
				perCheck[i] = 1;
				permutation(n, r, perArr, perCheck);
				perCheck[i] = 0;
				perArr.removeLast();
				
			}
			
		}
	
	}
	
	public static void main(String[] args) {
		
		int n = 3;
		int r = 2;
		
		// 순열 : 순서있게 배열
		LinkedList<Integer> perArr = new LinkedList<Integer>();
		
		int[] perCheck = new int[n];
		
		permutation(n, r, perArr, perCheck);
		
	}
	
}
