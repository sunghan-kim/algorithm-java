package programmers.sort.usage.numberOfCases.combination;

// https://seungbong8-8.tistory.com/15

/**
 * 
 * @author shkim
 * 
 * # 조합 (combination)
 * 
 *   - 조합 계산 함수 
 *   : void combination(int arr[], int index, int n, int c, int target);
 *   
 *   - 위 함수는 아래의 조합 기본 공식을 이용한다.
 *   
 *     nCr = n-1Cr-1 + n-1Cr
 *     
 *   - ex) 4C2
 *   
 *     - (1,2) (1,3) (1,4) / (2,3) (2,4) (3,4)
 *     - 위와같이 6가지 경우가 존재하는 데, 
 *       이는 1을 선택하는 경우와 1을 선택하지 않는 경우로 구분된다.
 *       
 *     - 1을 선택한 경우 : (1,2) (1,3) (1,4)
 *     
 *       - 2번째 값 선택 시 1을 제외한 나머지 3개 중 하나를 고른다.
 *       
 *         (3C1 == n-1Cr-1)
 *         
 *     - 1을 선택하지 않은 경우 : (2,3) (2,4) (3,4)
 *     
 *       - 1, 2번째 값 선택 시 1을 제외한 나머지 3개 중 2개를 고른다.
 *       
 *         (3C2 == n-1Cr)
 *         
 *     - 즉, 4C2 = 3C1 + 3C2 가 된다.
 *
 */

public class CombinationUsage2 {

	
	/**
	 * 
	 * combiCnt
	 * 
	 *  - 조합의 개수를 구하는 함수
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
	 *  - 조합의 각각의 경우를 구하는 함수
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
