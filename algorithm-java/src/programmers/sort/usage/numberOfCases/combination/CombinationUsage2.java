package programmers.sort.usage.numberOfCases.combination;

import java.util.Arrays;

// https://limkydev.tistory.com/156

/**
 * 
 * @author shkim
 * 
 * # 조합 (combination)
 * 
 *   - 조합 : n개의 숫자 중에서 r개의 수를 순서 없이 뽑는 경우
 *   
 *   - ex) [1,2,3] 숫자 배열에서 2개의 수를 순서없이 뽑는 경우
 *   
 *     - [1,2]
 *     - [1,3]
 *     - [2,3]
 *     
 *   - 순열로 뽑았을 경우의 [2,1],[3,1],[3,2]는 중복이므로 제거됨
 *   
 *   - 조합은 부분 집합처럼 이해하면 좋다.
 *   
 *   - 조합의 핵심
 *   
 *     - 배열을 처음부터 마지막까지 돌면서
 *     
 *       1) 현재 인덱스를 선택하는 경우
 *       2) 현재 인덱스를 선택하지 않는 경우
 *       
 *     - 위 두 가지로 모든 경우를 완전 탐색하면 된다.
 *     
 *   - ex) 3C2
 *   
 *     - 1,2,3 -> 1을 뽑은 경우   -> 2,3   -> 2를 뽑은 경우 -> (1,2) (완료)
 *     								       -> 3을 뽑은 경우 -> (1,3) (완료)
 *             -> 1을 안뽑는 경우 -> 1,2,3 -> 2를 뽑는 경우 -> 1,3 -> 3을 뽑는 경우 -> (2,3) (완료)
 *                                         -> 3을 뽑는 경우 -> 1,2 -> 2를 뽑는 경우 -> (3,2) (중복)
 *     
 *       
 *
 */

public class CombinationUsage2 {
	
	public void combination(int[] combArr, int n, int r, int index, int target, int[] arr) {
		
		System.out.println("=> " + n + " " + r + " " + index + " " + target);
	
		if (r == 0) { // r==0 : 뽑을 원소를 다 뽑았다.
			
			System.out.println(Arrays.toString(combArr));
			
			for (int i=0; i < index; i++) {
				
				System.out.print(arr[combArr[i]] + " ");
				
			}
			
			System.out.println();
			
		} else if (target == n) { // 끝까지 다 검사한 경우
			
			// 1개를 뽑은 상태여도, 실패한 경우임
			// 무조건 return으로 종료
			return;
			
		} else {
			
			combArr[index] = target;
			
			// 1. 뽑는 경우
			//  - 뽑았으니까 r-1
			//  - 뽑았으니 다음 index+1 해줘야 함
			combination(combArr, n, r-1, index+1, target+1, arr);
			
			// 2. 안 뽑은 경우
			//  - 안뽑았으므로 r 그대로
			//  - 안뽑았으니, index도 그대로!
			//  - index를 그대로 하면,
			//    예를 들어 현재 1번 구슬을 combArr에 넣었어도,
			//    다음 재귀에 다시 엎어쳐서 결국 1구슬을 뽑지 않게 된다.
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
