package programmers.sort.usage.numberOfCases.combination;

// https://seungbong8-8.tistory.com/15

/**
 * 
 * @author shkim
 * 
 * # ���� (combination)
 * 
 *   - ���� ��� �Լ� 
 *   : void combination(int arr[], int index, int n, int c, int target);
 *   
 *   - �� �Լ��� �Ʒ��� ���� �⺻ ������ �̿��Ѵ�.
 *   
 *     nCr = n-1Cr-1 + n-1Cr
 *     
 *   - ex) 4C2
 *   
 *     - (1,2) (1,3) (1,4) / (2,3) (2,4) (3,4)
 *     - ���Ͱ��� 6���� ��찡 �����ϴ� ��, 
 *       �̴� 1�� �����ϴ� ���� 1�� �������� �ʴ� ���� ���еȴ�.
 *       
 *     - 1�� ������ ��� : (1,2) (1,3) (1,4)
 *     
 *       - 2��° �� ���� �� 1�� ������ ������ 3�� �� �ϳ��� ����.
 *       
 *         (3C1 == n-1Cr-1)
 *         
 *     - 1�� �������� ���� ��� : (2,3) (2,4) (3,4)
 *     
 *       - 1, 2��° �� ���� �� 1�� ������ ������ 3�� �� 2���� ����.
 *       
 *         (3C2 == n-1Cr)
 *         
 *     - ��, 4C2 = 3C1 + 3C2 �� �ȴ�.
 *
 */

public class CombinationUsage2 {

	
	/**
	 * 
	 * combiCnt
	 * 
	 *  - ������ ������ ���ϴ� �Լ�
	 * 
	 * @param n
	 * @param r
	 * @return cnt
	 * 
	 */
	public static int combiCnt(int n, int r) {
		
		if (r == 0 || r == n) {
			
			return 1;
			
		} else {
			
			return combiCnt(n-1, r-1) + combiCnt(n-1, r);
			
		}
		
	}
	
	/**
	 * 
	 * combi
	 * 
	 *  - ������ ������ ��츦 ���ϴ� �Լ�
	 * 
	 * @param arr
	 * @param index
	 * @param n
	 * @param r
	 * @param target
	 * 
	 */
	public static void combi(int[] arr, int index, int n, int r, int target) {
		
		
		
	}
	
	public static void main(String[] args) {
		
		int n = 4;
		int r = 2;
		
		int cnt = combiCnt(n, r);
		
		System.out.println("cnt : " + cnt);
		
	}
	
}
