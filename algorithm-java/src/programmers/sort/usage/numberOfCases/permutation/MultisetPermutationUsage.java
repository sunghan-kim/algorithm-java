package programmers.sort.usage.numberOfCases.permutation;

import java.util.LinkedList;

//https://limkydev.tistory.com/178

/**
 * 
 * @author shkim
 * 
 * # 중복순열 (multiset permutation)
 * 
 *   - 순서있게 배열 + 자기 자신 포함
 *   - 순서 상관 있음
 *
 */

public class MultisetPermutationUsage {

	public static void multPermutation(int n, int r, LinkedList<Integer> multPerArr) {
		
		if (multPerArr.size() == r) {
			
			for (int i : multPerArr) {
				
				System.out.print(i + " ");
				
			}
			
			System.out.println();
			return;
			
		}
		
		for (int i=0; i < n; i++) {
			
			multPerArr.add(i);
			multPermutation(n, r, multPerArr);
			multPerArr.removeLast();
			
		}
		
	}
	
	public static void main(String[] args) {
		
		int n = 3;
		int r = 2;
		
		LinkedList<Integer> multPerArr = new LinkedList<Integer>();
		multPermutation(n, r, multPerArr);
		
	}
	
}
