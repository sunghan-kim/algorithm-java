package programmers.sort.usage.numberOfCases.permutation;

import java.util.Arrays;

//https://redscreen.tistory.com/168

/**
 * 
 * @author shkim
 * 
 * # 순열
 * 
 * 2. 재귀함수 + 위치변경(swap)을 이용한 순열
 * 
 *   - 요소와 요소를 자리 바꿈
 *   - depth 변수를 이용하여 선택할 수 있는 요소의 범위 조절
 *   
 *   
 *   - P(4, 2)
 *   
 *   = (첫째[depth] <-> 첫째(i) swap) [1,2,3,4] 중에서 '1' 선택 x (둘째[depth]↔둘째(i) swap) [1,2,3,4] 중에서 '2' 선택 => 12
 *     (첫째[depth] <-> 첫째(i) swap) [1,2,3,4] 중에서 '1' 선택 x (둘째[depth]↔셋째(i) swap) [1,3,2,4] 중에서 '3' 선택 => 13
 *     (첫째[depth] <-> 첫째(i) swap) [1,2,3,4] 중에서 '1' 선택 x (둘째[depth]↔넷째(i) swap) [1,4,3,2] 중에서 '4' 선택 => 14
 *     
 *     (첫째[depth] <-> 둘째(i) swap) [2,1,3,4] 중에서 '2' 선택 x (둘째[depth]↔둘째(i) swap) [2,1,3,4] 중에서 '1' 선택 => 21
 *     (첫째[depth] <-> 둘째(i) swap) [2,1,3,4] 중에서 '2' 선택 x (둘째[depth]↔셋째(i) swap) [2,3,1,4] 중에서 '3' 선택 => 23
 *     (첫째[depth] <-> 둘째(i) swap) [2,1,3,4] 중에서 '2' 선택 x (둘째[depth]↔넷째(i) swap) [2,4,3,1] 중에서 '4' 선택 => 24
 *     
 *     (첫째[depth] <-> 셋째(i) swap) [3,2,1,4] 중에서 '3' 선택 x (둘째[depth]↔둘째(i) swap) [3,2,1,4] 중에서 '2' 선택 => 32
 *     (첫째[depth] <-> 셋째(i) swap) [3,2,1,4] 중에서 '3' 선택 x (둘째[depth]↔셋째(i) swap) [3,1,2,4] 중에서 '1' 선택 => 31
 *     (첫째[depth] <-> 셋째(i) swap) [3,2,1,4] 중에서 '3' 선택 x (둘째[depth]↔넷째(i) swap) [3,4,1,2] 중에서 '4' 선택 => 34
 *     
 *     (첫째[depth] <-> 넷째(i) swap) [4,2,3,1] 중에서 '4' 선택 x (둘째[depth]↔둘째(i) swap) [4,2,3,1] 중에서 '2' 선택 => 42
 *     (첫째[depth] <-> 넷째(i) swap) [4,2,3,1] 중에서 '4' 선택 x (둘째[depth]↔셋째(i) swap) [4,3,2,1] 중에서 '3' 선택 => 43
 *     (첫째[depth] <-> 넷째(i) swap) [4,2,3,1] 중에서 '4' 선택 x (둘째[depth]↔넷째(i) swap) [4,1,3,2] 중에서 '1' 선택 => 41
 *     
 *   - 본인과 본인이 swap하는 부분이 없으면, 최초 케이스가 누락됨
 *     (ex. [1,2,3,4]에서 swap되어 [2,1,3,4] 부터 계산 시작)
 *     
 *   - depth가 0부터 시작했을 때, depth == r이 되면 r개 만큼 출력함
 *   - 위에서는 r이 2이므로, index가 0~1까지인 원소 2개만 출력
 *   
 *   
 *   - 위 내용을 구현하는 방법
 *   
 *     - for문을 이용하여 순차적으로 현재 depth 원소와 i번째 원소를 swap
 *       (자연스럽게 swap되어 첫 번째로 옮겨진 원소가 선택됨)
 *       
 *     - 다음으로 호출되는 재귀 함수에는 증가된 인덱스(depth+1)를 넘겨주면 범위가 좁혀지면서 문제 해결
 *     
 *     - 주의할 점
 *       : swap 메소드 때문에 원소들의 순서가 변경되기 때문에 이를 다시 되돌려 주어야 한다.
 *
 */

public class PermutationUsage3 {

	private int n;		// nPr의 n
	private int r;		// nPr의 r
	private int[] res;	// 결과값
	
	// 초기화
	public PermutationUsage3(int n, int r) {
		
		this.n = n;
		this.r = r;
		res = new int[r];
		
	}
	
	public void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	public void perm(int[] arr, int depth) {
		
		// depth가 0부터 시작했을 경우, depth == r에서 리턴
		if (depth == r) {
			
			System.out.println(Arrays.toString(res));
			return;
			
		}
		
		for (int i=depth; i < n; i++) {
			
			swap(arr, depth, i);		// 스왑
			res[depth] = arr[depth];	// 선택된 원소 저장
			perm(arr, depth+1);			// 재귀호출
			swap(arr, depth, i);		// 복원
			
		}
		
	}
	
	public void multPerm(int[] arr, int depth) {
		
		// depth가 0부터 시작했을 경우, depth == r에서 리턴
		if (depth == r) {
			
			System.out.println(Arrays.toString(res));
			return;
			
		}
		
		// 중복순열
		for (int i=0; i < n; i++) { // i가 depth가 아닌 0부터 시작하는 것이 순열과 차이
			
			swap(arr, depth, i);		// 스왑
			res[depth] = arr[depth];	// 선택된 원소 저장
			multPerm(arr, depth+1);			// 재귀호출
			swap(arr, depth, i);		// 복원
			
		}
		
	}
	
	public static void main(String[] args) {
		
		int r = 2;
		int[] arr = {1,2,3,4};
		
		PermutationUsage3 main = new PermutationUsage3(arr.length, r);
		
		// 순열 (permutation)
		System.out.println("##### permutation #####");
		main.perm(arr, 0);
		
		System.out.println("----------------------------");
		
		// 중복순열 (multiset permutation)
		System.out.println("##### multiset permutation #####");
		main.multPerm(arr, 0);
		
		
		
	}
	
}
