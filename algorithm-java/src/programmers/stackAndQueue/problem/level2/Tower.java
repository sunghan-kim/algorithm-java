package programmers.stackAndQueue.problem.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/42588

/**
* 
* @author shkim
* 
* ##### ž #####
* 
* 
* # ���� ����
* 
* ���� ������ ž N�븦 �������ϴ�. 
* ��� ž�� ����⿡�� ��ȣ�� ��/�����ϴ� ��ġ�� ��ġ�߽��ϴ�. 
* �߻��� ��ȣ�� ��ȣ�� ���� ž���� ���� ž������ �����մϴ�. 
* ����, �� �� ���ŵ� ��ȣ�� �ٸ� ž���� �۽ŵ��� �ʽ��ϴ�.
* 
* ���� ��� ���̰� 6, 9, 5, 7, 4�� �ټ� ž�� �������� ���ÿ� ������ ��ȣ�� �߻��մϴ�. 
* �׷���, ž�� ������ ���� ��ȣ�� �ְ�޽��ϴ�.
*  
*   ���̰� 4�� �ټ� ��° ž���� �߻��� ��ȣ�� ���̰� 7�� �� ��° ž�� �����ϰ�, 
*   ���̰� 7�� �� ��° ž�� ��ȣ�� ���̰� 9�� �� ��° ž��, 
*   ���̰� 5�� �� ��° ž�� ��ȣ�� ���̰� 9�� �� ��° ž�� �����մϴ�. 
*   ���̰� 9�� �� ��° ž�� ���̰� 6�� ù ��° ž�� ���� ������ ��ȣ�� � ž������ ������ �� �����ϴ�.
* 
*   �۽� ž(����)	���� ž(����)
*   	5(4)			4(7)
*   	4(7)			2(9)
*   	3(5)			2(9)
*   	2(9)			-
*   	1(6)			-
*   
* �� ���ʺ��� ������� ž�� ���̸� ���� �迭 heights�� �Ű������� �־��� �� 
* �� ž�� �� ��ȣ�� ��� ž���� �޾Ҵ��� ����� �迭�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
* 
* 
* # ���� ����
* 
*  - heights�� ���� 2 �̻� 100 ������ ���� �迭�Դϴ�.
*  - ��� ž�� ���̴� 1 �̻� 100 �����Դϴ�.
*  - ��ȣ�� �����ϴ� ž�� ������ 0���� ǥ���մϴ�.
*  
* 
* # ����� ��
* 
* (����1)
* 
*   - heights : [6,9,5,7,4]
*   
*   - return : [0,0,2,2,4]
*   
*   - ������ ���� ���� ����.
*   
*
* (����2)
* 
*   - heights : [3,9,9,3,5,7,2]
*   
*   - return : [0,0,0,3,3,3,6]
*   
*   - [1,2,3] ��° ž�� �� ��ȣ�� �ƹ��� �������� �ʽ��ϴ�.
*   - [4,5,6] ��° ž�� �� ��ȣ�� 3��° ž�� �����մϴ�.
*   - [7] ��° ž�� �� ��ȣ�� 6��° ž�� �����մϴ�.
*   
*   
* (����3)
* 
*   - heights : [1,5,3,6,7,6,5]
*   
*   - return : [0,0,2,0,0,5,6]
*   
*   - [1,2,4,5] ��° ž�� �� ��ȣ�� �ƹ��� �������� �ʽ��ϴ�.
*   - [3] ��° ž�� �� ��ȣ�� 2��° ž�� �����մϴ�.
*   - [6] ��° ž�� �� ��ȣ�� 5��° ž�� �����մϴ�.
*   - [7] ��° ž�� �� ��ȣ�� 6��° ž�� �����մϴ�.  
*   
*/

public class Tower {

	/**
	 * 
	 * My Solution
	 * 
	 *  - ������ : ����
	 * 
	 * @param heights
	 * @return
	 */
	public int[] solution(int[] heights) {
        int[] answer = {};
        
        answer = new int[heights.length];
        
        for (int i=heights.length-1; i >= 0; i--) {
        	
        	int target = heights[i];
        	
        	for (int j=i-1; j >= 0; j--) {
        		
        		if (target < heights[j]) {
        			answer[i] = j+1;
        			break;
        		}
        		
        	}
        	
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int[] heights1 = {6,9,5,7,4};
		int[] heights2 = {3,9,9,3,5,7,2};
		int[] heights3 = {1,5,3,6,7,6,5};
		
		int[] answer1 = {}; // {0,0,2,2,4}
		int[] answer2 = {}; // {0,0,0,3,3,3,6}
		int[] answer3 = {}; // {0,0,2,0,0,5,6}
		
		String show = "default"; // default
		
		if (show.equals("default")) {
			
			Tower tw = new Tower();
			
			answer1 = tw.solution(heights1);
			answer2 = tw.solution(heights2);
			answer3 = tw.solution(heights3);
			
		}
		
		System.out.println("answer1 : " + Arrays.toString(answer1)); // {0,0,2,2,4}
		System.out.println("answer2 : " + Arrays.toString(answer2)); // {0,0,0,3,3,3,6}
		System.out.println("answer3 : " + Arrays.toString(answer3)); // {0,0,2,0,0,5,6}
		
		
	}
	
}
