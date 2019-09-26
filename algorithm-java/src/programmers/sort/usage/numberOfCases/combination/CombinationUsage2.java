package programmers.sort.usage.numberOfCases.combination;

import java.util.Arrays;

// https://limkydev.tistory.com/156

/**
 * 
 * @author shkim
 * 
 * # ���� (combination)
 * 
 *   - ���� : n���� ���� �߿��� r���� ���� ���� ���� �̴� ���
 *   
 *   - ex) [1,2,3] ���� �迭���� 2���� ���� �������� �̴� ���
 *   
 *     - [1,2]
 *     - [1,3]
 *     - [2,3]
 *     
 *   - ������ �̾��� ����� [2,1],[3,1],[3,2]�� �ߺ��̹Ƿ� ���ŵ�
 *   
 *   - ������ �κ� ����ó�� �����ϸ� ����.
 *   
 *   - ������ �ٽ�
 *   
 *     - �迭�� ó������ ���������� ���鼭
 *     
 *       1) ���� �ε����� �����ϴ� ���
 *       2) ���� �ε����� �������� �ʴ� ���
 *       
 *     - �� �� ������ ��� ��츦 ���� Ž���ϸ� �ȴ�.
 *     
 *   - ex) 3C2
 *   
 *     - 1,2,3 -> 1�� ���� ���   -> 2,3   -> 2�� ���� ��� -> (1,2) (�Ϸ�)
 *     								       -> 3�� ���� ��� -> (1,3) (�Ϸ�)
 *             -> 1�� �Ȼ̴� ��� -> 1,2,3 -> 2�� �̴� ��� -> 1,3 -> 3�� �̴� ��� -> (2,3) (�Ϸ�)
 *                                         -> 3�� �̴� ��� -> 1,2 -> 2�� �̴� ��� -> (3,2) (�ߺ�)
 *     
 *       
 *
 */

public class CombinationUsage2 {
	
	public void combination(int[] combArr, int n, int r, int index, int target, int[] arr) {
		
		System.out.println("=> " + n + " " + r + " " + index + " " + target);
	
		if (r == 0) { // r==0 : ���� ���Ҹ� �� �̾Ҵ�.
			
			System.out.println(Arrays.toString(combArr));
			
			for (int i=0; i < index; i++) {
				
				System.out.print(arr[combArr[i]] + " ");
				
			}
			
			System.out.println();
			
		} else if (target == n) { // ������ �� �˻��� ���
			
			// 1���� ���� ���¿���, ������ �����
			// ������ return���� ����
			return;
			
		} else {
			
			combArr[index] = target;
			
			// 1. �̴� ���
			//  - �̾����ϱ� r-1
			//  - �̾����� ���� index+1 ����� ��
			combination(combArr, n, r-1, index+1, target+1, arr);
			
			// 2. �� ���� ���
			//  - �Ȼ̾����Ƿ� r �״��
			//  - �Ȼ̾�����, index�� �״��!
			//  - index�� �״�� �ϸ�,
			//    ���� ��� ���� 1�� ������ combArr�� �־��,
			//    ���� ��Ϳ� �ٽ� �����ļ� �ᱹ 1������ ���� �ʰ� �ȴ�.
			combination(combArr, n, r, index, target+1, arr);
			
		}
		
		
	}
	
	public static void main(String[] args) {
		
		CombinationUsage2 ex = new CombinationUsage2();
		
		int[] arr = {1,2,3};
		int n = arr.length;
		int r = 2;
		int[] combArr = new int[n];
		
		ex.combination(combArr, n, r, 0, 0, arr);
		
	}
	
}
