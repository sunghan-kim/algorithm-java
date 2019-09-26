package programmers.sort.problem.level2;

import java.util.Arrays;

import programmers.sort.problem.level2.solution.biggest.DeveloperDK;
import programmers.sort.problem.level2.solution.biggest.Dreamholic;
import programmers.sort.problem.level2.solution.biggest.Programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42746

/**
* 
* @author shkim
* 
* ##### 가장 큰 수 #####
* 
* # 문제 설명
* 
* 0 또는 양의 정수가 주어졌을 때, 
* 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
* 
* 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 
* 이중 가장 큰 수는 6210입니다.
* 
* 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 
* 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
* 
* 
* # 제한 사항
* 
* - numbers의 길이는 1 이상 100,000 이하입니다.
* - numbers의 원소는 0 이상 1,000 이하입니다.
* - 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
* 
* 
* # 입출력 예
* 
* (예시1)
* 
*   - numbers : [6, 10, 2]
*   
*   - return : "6210"
*   
*   
* (예시2)
* 
*   - numbers : [3, 30, 34, 5, 9]
*   
*   - return : "9534330"
*   
*/

public class Biggest {

	private int n;
	private int r;
	private int[] res;
	private String str;
	private int permCnt;
	private String[] answers;
	private int ansIdx;
	
	/**
	 * 
	 * solution
	 * 
	 * - 직접 작성
	 * - LinkedList를 이용한 중복순열 구현
	 * 
	 * @param numbers
	 * @return answer
	 * 
	 * - 제출결과 : 실패, 속도 오래 걸림
	 * 
	 */
	public String solution(int[] numbers) {
        
		String answer = "";
		
		n = numbers.length;
		r = numbers.length;
		res = new int[r];
		
		permCnt = calcPerm(n, r);
		
		answers = new String[permCnt];
		
		ansIdx = 0;
		
		perm(numbers, 0);
		
		Arrays.sort(answers);
		
		answer = answers[answers.length-1];
		
		return answer;
        
    }
	
	// 순열 경우의 수 계산 메소드
	public static int calcPerm(int n, int r) {
		
		int val = n;
		int result = 1;
		
		for (int i=0; i < r; i++) {
			
			result *= val;
			val--;
			
		}
		
		return result;
		
	}
	
	// 순열 메소드
	public void perm(int[] arr, int depth) {
		
		if (depth == r) {
			
			str = "";
			
			//System.out.println(Arrays.toString(res));
			
			for (int i=0; i < res.length; i++) {
				
				str += Integer.toString(res[i]);
				
			}
			
			answers[ansIdx] = str;
			ansIdx++;
						
			return;
			
		}
		
		for (int i=depth; i < n; i++) {
			
			swap(arr, depth, i);		// 스왑
			res[depth] = arr[depth];	// 선택된 원소 저장
			perm(arr, depth+1);
			swap(arr, depth, i);		// 복원
			
		}
		
	}
	
	// swap 메소드
	public void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	public static void main(String[] args) {
		
		int[] numbers1 = {6, 10, 2};
		int[] numbers2 = {3, 30, 34, 5, 9};
		
		String answer1 = "";
		String answer2 = "";
		
		String show = "dh"; // default, pgrs_01, pgrs_02, dk, dh
		
		if (show.equals("default")) {
			
			Biggest big = new Biggest();
			
			answer1 = big.solution(numbers1);
			answer2 = big.solution(numbers2);
			
		} else if (show.equals("pgrs_01")) {
			
			Programmers pgrs = new Programmers();
			
			answer1 = pgrs.solution1(numbers1);
			answer2 = pgrs.solution1(numbers2);
			
		} else if (show.equals("pgrs_02")) {
			
			Programmers pgrs = new Programmers();
			
			answer1 = pgrs.solution2(numbers1);
			answer2 = pgrs.solution2(numbers2);
			
		} else if (show.equals("dk")) {
			
			DeveloperDK dk = new DeveloperDK();
			
			answer1 = dk.solution(numbers1);
			answer2 = dk.solution(numbers2);
			
			
		} else if (show.equals("dh")) {
			
			Dreamholic dh = new Dreamholic();
			
			answer1 = dh.solution(numbers1);
			answer2 = dh.solution(numbers2);
			
			
		}
		
		System.out.println("answer1 : " + answer1); // "6210"
		System.out.println("answer2 : " + answer2); // "9534330"
		
	}
	
}
