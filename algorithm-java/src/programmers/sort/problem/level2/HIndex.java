package programmers.sort.problem.level2;

import programmers.sort.problem.level2.solution.HIndex.DeveloperDK;
import programmers.sort.problem.level2.solution.HIndex.Jar100;

// https://programmers.co.kr/learn/courses/30/lessons/42747

/**
* 
* @author shkim
* 
* ##### H-Index #####
* 
* # ���� ����
* 
* H-Index�� �������� ���꼺�� ������� ��Ÿ���� ��ǥ�Դϴ�. 
* ��� �������� H-Index�� ��Ÿ���� ���� h�� ���Ϸ��� �մϴ�. 
* ��Ű���1�� ������, H-Index�� ������ ���� ���մϴ�.
* 
* � �����ڰ� ��ǥ�� �� n�� ��, 
* h�� �̻� �ο�� ���� h�� �̻��̰� ������ ���� h�� ���� �ο�Ǿ��ٸ� 
* h�� �� �������� H-Index�Դϴ�.
* 
* � �����ڰ� ��ǥ�� ���� �ο� Ƚ���� ���� �迭 citations�� �Ű������� �־��� ��, 
* �� �������� H-Index�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
* 
* 
* # ���� ����
* 
* - �����ڰ� ��ǥ�� ���� ���� 1�� �̻� 1,000�� �����Դϴ�.
* - ���� �ο� Ƚ���� 0ȸ �̻� 10,000ȸ �����Դϴ�.
* 
* 
* # ����� ��
* 
* (����1)
* 
*   - citations : [3, 0, 6, 1, 5]
*   
*   - return : 3
*   
*   
* # ����� �� ����
* 
* �� �����ڰ� ��ǥ�� ���� ���� 5���̰�, ���� 3���� ���� 3ȸ �̻� �ο�Ǿ����ϴ�. 
* �׸��� ������ 2���� ���� 3ȸ ���� �ο�Ǿ��� ������ �� �������� H-Index�� 3�Դϴ�.
*   
*/

public class HIndex {

	public int solution(int[] citations) {
        int answer = 0;
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int[] citations = {3, 0, 6, 1, 5};
		
		int answer = 0;
		
		String show = "dk2"; // default, jar, dk1, dk2
		
		if (show.equals("default")) {
			
			HIndex hidx = new HIndex();
			
			answer = hidx.solution(citations);
			
		} else if (show.equals("jar")) {
			
			Jar100 jar = new Jar100();
			
			answer = jar.solution(citations);
			
		} else if (show.equals("dk1")) {
			
			DeveloperDK dk = new DeveloperDK();
			
			answer = dk.solution1(citations);
			
		} else if (show.equals("dk2")) {
			
			DeveloperDK dk = new DeveloperDK();
			
			answer = dk.solution2(citations);
			
		}
		
		System.out.println("answer : " + answer);
		
	}
	
}
