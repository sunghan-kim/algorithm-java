package programmers.sort.problem.level2;

import programmers.sort.problem.level1.Kth;

// https://programmers.co.kr/learn/courses/30/lessons/42746

/**
* 
* @author shkim
* 
* ##### ���� ū �� #####
* 
* # ���� ����
* 
* 0 �Ǵ� ���� ������ �־����� ��, 
* ������ �̾� �ٿ� ���� �� �ִ� ���� ū ���� �˾Ƴ� �ּ���.
* 
* ���� ���, �־��� ������ [6, 10, 2]��� [6102, 6210, 1062, 1026, 2610, 2106]�� ���� �� �ְ�, 
* ���� ���� ū ���� 6210�Դϴ�.
* 
* 0 �Ǵ� ���� ������ ��� �迭 numbers�� �Ű������� �־��� ��, 
* ������ ���ġ�Ͽ� ���� �� �ִ� ���� ū ���� ���ڿ��� �ٲپ� return �ϵ��� solution �Լ��� �ۼ����ּ���.
* 
* 
* # ���� ����
* 
* - numbers�� ���̴� 1 �̻� 100,000 �����Դϴ�.
* - numbers�� ���Ҵ� 0 �̻� 1,000 �����Դϴ�.
* - ������ �ʹ� Ŭ �� ������ ���ڿ��� �ٲپ� return �մϴ�.
* 
* 
* # ����� ��
* 
* (����1)
* 
*   - numbers : [6, 10, 2]
*   
*   - return : "6210"
*   
*   
* (����2)
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
	 * - ���� �ۼ�
	 * - LinkedList�� �̿��� �ߺ����� ����
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
