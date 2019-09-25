package programmers.sort.usage.numberOfCases.permutation;

import java.util.ArrayList;
import java.util.Arrays;

// https://redscreen.tistory.com/168

/**
 * 
 * @author shkim
 * 
 * # 순열 (Permutation)
 * 
 * 1. n개 중에서 r개를 선택한다.
 * 
 *   - 순열은 n개에서 r개를 선택하는 알고리즘
 *   
 *   - 순열의 분류 (2가지)
 *   
 *     - 중복을 허용하지 않고 n개 중에 r개 뽑기 (순열)
 *     - 중복을 허용하고 n개 중에 r개 뽑기 (중복순열) 
 *     
 *     
 * 2. 재귀함수 + ArrayList를 이용한 순열
 * 
 *   - 순열의 점화식
 *   
 *     : 0 <= r >= n을 만족하는 정수 n, r이 있을 때, 순서를 고려하여 r개의 원소를 뽑음
 *     
 *     P(n, r) = n(n-1)(n-2)...(n-r+1)
 *             = n! / (n-r)!
 *             
 *             
 *   - 확장
 *   
 *     - P(5, 3) = 5 x 4 x 3
 *     
 *     - P(5, 3) = 5개의 아이템 중 1개 선택 x 4개의 아이템 중 1개 선택 x 3개의 아이템 중 1개 선택
 *     
 *     - P(5, 3) = [1,2,3,4,5] 중에서 '1' 선택 x [2,3,4,5] 중에서 '2' 선택 x [3,4,5] 중에서 '3' 선택 => 123
 *     			   [1,2,3,4,5] 중에서 '1' 선택 x [2,3,4,5] 중에서 '2' 선택 x [3,4,5] 중에서 '4' 선택 => 124
 *     			   [1,2,3,4,5] 중에서 '1' 선택 x [2,3,4,5] 중에서 '2' 선택 x [3,4,5] 중에서 '5' 선택 => 125
 *     
 *     			   [1,2,3,4,5] 중에서 '1' 선택 x [2,3,4,5] 중에서 '3' 선택 x [2,4,5] 중에서 '2' 선택 => 132
 *     			   [1,2,3,4,5] 중에서 '1' 선택 x [2,3,4,5] 중에서 '3' 선택 x [2,4,5] 중에서 '4' 선택 => 134
 *     			   [1,2,3,4,5] 중에서 '1' 선택 x [2,3,4,5] 중에서 '3' 선택 x [2,4,5] 중에서 '5' 선택 => 135
 *          
 *     			   [1,2,3,4,5] 중에서 '1' 선택 x [2,3,4,5] 중에서 '4' 선택 x [2,3,5] 중에서 '2' 선택 => 142
 *     			   [1,2,3,4,5] 중에서 '1' 선택 x [2,3,4,5] 중에서 '4' 선택 x [2,3,5] 중에서 '3' 선택 => 143
 *     			   [1,2,3,4,5] 중에서 '1' 선택 x [2,3,4,5] 중에서 '4' 선택 x [2,3,5] 중에서 '5' 선택 => 145
 *     
 *     			   [1,2,3,4,5] 중에서 '1' 선택 x [2,3,4,5] 중에서 '5' 선택 x [2,3,4] 중에서 '2' 선택 => 152
 *     			   [1,2,3,4,5] 중에서 '1' 선택 x [2,3,4,5] 중에서 '5' 선택 x [2,3,4] 중에서 '3' 선택 => 153
 *     			   [1,2,3,4,5] 중에서 '1' 선택 x [2,3,4,5] 중에서 '5' 선택 x [2,3,4] 중에서 '4' 선택 => 154
 *     
 *                 [1,2,3,4,5] 중에서 '2' 선택 x [1,3,4,5] 중에서 '1' 선택 x [3,4,5] 중에서 '3' 선택 => 213
 *                 
 *                 ...                         x ...                       x ...
 *                 
 *                 (모든 경우의 수를 구할 때까지 반복)
 *               
 *     - 선택된 아이템은 바로 출력하거나, 모든 아이템이 fix된 이후에 출력해도 됨
 *       (확정이라 생각해도 무방)
 *       
 *     - 무언가 반복적인 패턴이 보인다면, 이를 재귀적으로 구현할 수 있음
 *     
 *     - '주어진 자료구조에서 원소를 선택'하는 기능을 구현하고,
 *       다음 호출되는 재귀함수에 선택한 아이템을 뺀 나머지 집합을 넘겨주면 된다.
 *       
 *     - 주의할 점
 *       : 재귀함수가 끝난 이후에는 그 다음 계산을 위하여 remove한 원소를 다시 원래 index에 넣어줘야 한다.
 *     
 *     
 *     
 */

public class PermutationUsage2 {

	private int n;	// nPr의 n
	private int r;	// nPr의 r
	private ArrayList<Integer> itemList;
	private int[] res;
	
	// 초기화
	public PermutationUsage2(int[] intArr, int r) {
		
		this.r = r;					// nPr의 r
		this.n = intArr.length;		// nPr의 n
		this.res = new int[r];		// 결괏값 배열
		
		// 아이템이 들어갈 리스트
		itemList = new ArrayList<Integer>();
		
		for (int item : intArr) {
			
			itemList.add(item);
			
		}
		
	}
	
	public void perm(int depth) {
		
		perm(itemList, 0);
		
	}
	
	public void perm(ArrayList<Integer> itemList, int depth) {
		
		// depth가 0부터 시작했을 경우, depth == r에서 리턴
		if (depth == r) {
			
			System.out.println(Arrays.toString(res));
			return;
			
		}
		
		for (int i=0; i < n-depth; i++) {
			
			res[depth] = itemList.remove(i);	// 아이템 선택 + 리스트에서 제거
			perm(itemList, depth+1);			// 재귀호출
			itemList.add(i, res[depth]);		// 제거된 아이템 복원
			
		}
		
	}
	
	
	public void multPerm(int depth) {
		
		multPerm(itemList, 0);
		
	}
	
	public void multPerm(ArrayList<Integer> itemList, int depth) {
		
		if (depth == r) {
			
			System.out.println(Arrays.toString(res));
			return;
			
		}
		
		for (int i=0; i < n-depth; i++) {
			
			res[depth] = itemList.get(i);		// 아이템 선택 + 리스트에서 제거
			multPerm(itemList, depth+1);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		int r = 3;
		int[] arr = {1,2,3,4,5};
		
		PermutationUsage2 main = new PermutationUsage2(arr, r);
		
		// 순열 (permutation)
		System.out.println("##### permutation #####");
		main.perm(0);
		
		System.out.println("----------------------------");
		
		// 중복순열 (multiset permutation)
		System.out.println("##### multiset permutation #####");
		main.multPerm(0);
		
	}
	
	
	
	
	
}
