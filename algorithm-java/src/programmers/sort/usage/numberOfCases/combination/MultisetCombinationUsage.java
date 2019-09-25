package programmers.sort.usage.numberOfCases.combination;

import java.util.Arrays;

//https://limkydev.tistory.com/178

/**
* 
* @author shkim
* 
* # 중복조합 (multiset combination)
* 
*   - 순서상관없이 뽑음 + 자기 자신 포함
*   - 순서 상관 없음
*
*/

public class MultisetCombinationUsage {

	public static void multCombination(int[] multComArr, int n, int r, int index, int target) {
		
		if (r == 0) {
			
			for (int i : multComArr) {
				
				System.out.print(i + " ");
				
			}
			System.out.println();
			return;
			
		}
		
		if (target == n) return;
		
		multComArr[index] = target;
		multCombination(multComArr, n, r-1, index+1, target); 	// 뽑는 경우
		multCombination(multComArr, n, r, index, target+1);		// 안뽑는 경우
	
	}
	
	public static void main(String[] args) {
		
		int n = 3;
		int r = 2;
		
		int[] multComArr = new int[r];
		
		multCombination(multComArr, n, r, 0, 0);
		
		System.out.println(Arrays.toString(multComArr));
		
	}
	
}
