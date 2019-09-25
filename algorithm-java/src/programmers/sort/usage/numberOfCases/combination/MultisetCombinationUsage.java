package programmers.sort.usage.numberOfCases.combination;

import java.util.Arrays;

//https://limkydev.tistory.com/178

/**
* 
* @author shkim
* 
* # �ߺ����� (multiset combination)
* 
*   - ����������� ���� + �ڱ� �ڽ� ����
*   - ���� ��� ����
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
		multCombination(multComArr, n, r-1, index+1, target); 	// �̴� ���
		multCombination(multComArr, n, r, index, target+1);		// �Ȼ̴� ���
	
	}
	
	public static void main(String[] args) {
		
		int n = 3;
		int r = 2;
		
		int[] multComArr = new int[r];
		
		multCombination(multComArr, n, r, 0, 0);
		
		System.out.println(Arrays.toString(multComArr));
		
	}
	
}
