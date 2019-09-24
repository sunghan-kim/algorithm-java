package programmers.sort.problem.level2;

import programmers.sort.problem.level1.Kth;

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
	 */
	public String solution(int[] numbers) {
        
		String answer = "";
        
		// 6102, 6210, 1062, 1026, 
        
        return answer;
        
    }
	
	public static void main(String[] args) {
		
		int[] numbers1 = {6, 10, 2};
		int[] numbers2 = {3, 30, 34, 5, 9};
		
		String answer1 = "";
		String answer2 = "";
		
		String show = "default"; // default
		
		if (show.equals("default")) {
			
			Biggest big = new Biggest();
			
			answer1 = big.solution(numbers1);
			answer2 = big.solution(numbers2);
			
		}
		
		System.out.println("answer1 : " + answer1); // "6210"
		System.out.println("answer2 : " + answer2); // "9534330"
		
	}
	
}
