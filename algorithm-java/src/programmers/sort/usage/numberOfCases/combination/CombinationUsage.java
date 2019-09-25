package programmers.sort.usage.numberOfCases.combination;

import java.util.Arrays;

// https://limkydev.tistory.com/178

/**
 * 
 * @author shkim
 * 
 * # 조합 (combination)
 * 
 *   - 순서 상관없이 뽑음.
 *   - 순서 상관 없음
 *
 */

public class CombinationUsage {

	public static void combination(int[] comArr, int n, int r, int index, int target) {
		
		if (r == 0) {
			
			for (int i : comArr) {
				
				System.out.print(i+" ");
				
			}
			
			System.out.println();
			return;
			
		}
		
		if (target == n) return;
		
		comArr[index] = target;
		combination(comArr, n, r-1, index+1, target+1); // 뽑는 경우
		combination(comArr, n, r, index, target+1);		// 안뽑는 경우	
		
	}
	
	public static void main(String[] args) {
		
		int n = 3;
		int r = 2;
		
		int[] comArr = new int[r];
		combination(comArr, n, r, 0, 0);
		
	}
	
}
