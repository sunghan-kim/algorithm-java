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
	 * - ���� �ۼ�
	 * - LinkedList�� �̿��� �ߺ����� ����
	 * 
	 * @param numbers
	 * @return answer
	 * 
	 * - ������ : ����, �ӵ� ���� �ɸ�
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
	
	// ���� ����� �� ��� �޼ҵ�
	public static int calcPerm(int n, int r) {
		
		int val = n;
		int result = 1;
		
		for (int i=0; i < r; i++) {
			
			result *= val;
			val--;
			
		}
		
		return result;
		
	}
	
	// ���� �޼ҵ�
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
			
			swap(arr, depth, i);		// ����
			res[depth] = arr[depth];	// ���õ� ���� ����
			perm(arr, depth+1);
			swap(arr, depth, i);		// ����
			
		}
		
	}
	
	// swap �޼ҵ�
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
