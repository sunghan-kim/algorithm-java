package programmers.stackAndQueue.problem.level2;

import java.util.Arrays;
import java.util.HashMap;

import programmers.stackAndQueue.problem.level2.solution.printer.DeveloperDK;
import programmers.stackAndQueue.problem.level2.solution.printer.HMYK;
import programmers.stackAndQueue.problem.level2.solution.printer.Junam;
import programmers.stackAndQueue.problem.level2.solution.printer.Programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42587

/**
* 
* @author shkim
* 
* ##### ������ #####
* 
* # ���� ����
* 
* �Ϲ����� �����ʹ� �μ� ��û�� ���� ������� �μ��մϴ�. 
* �׷��� ������ �߿��� ������ ���߿� �μ�� �� �ֽ��ϴ�. 
* �̷� ������ �����ϱ� ���� �߿䵵�� ���� ������ ���� �μ��ϴ� �����͸� �����߽��ϴ�. 
* �� ���Ӱ� ������ �����ʹ� �Ʒ��� ���� ������� �μ� �۾��� �����մϴ�.
* 
*   1. �μ� ������� ���� �տ� �ִ� ����(J)�� ����Ͽ��� �����ϴ�.
*   2. ������ �μ� ����Ͽ��� J���� �߿䵵�� ���� ������ �� ���� �����ϸ� J�� ������� ���� �������� �ֽ��ϴ�.
*   3. �׷��� ������ J�� �μ��մϴ�.
*   
* ���� ���, 4���� ����(A, B, C, D)�� ������� �μ� ����Ͽ� �ְ� 
* �߿䵵�� 2 1 3 2 ��� C D A B ������ �μ��ϰ� �˴ϴ�.
* 
* ���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� �˰� �ͽ��ϴ�. 
* ���� ������ C�� 1��°��, A�� 3��°�� �μ�˴ϴ�.
* 
* ���� ����Ͽ� �ִ� ������ �߿䵵�� ������� ��� �迭 priorities�� 
* ���� �μ⸦ ��û�� ������ ���� ������� � ��ġ�� �ִ����� �˷��ִ� location�� �Ű������� �־��� ��, 
* ���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
* 
* 
* # ���� ����
* 
*  - ���� ����Ͽ��� 1�� �̻� 100�� ������ ������ �ֽ��ϴ�.
*  - �μ� �۾��� �߿䵵�� 1~9�� ǥ���ϸ� ���ڰ� Ŭ���� �߿��ϴٴ� ���Դϴ�.
*  - location�� 0 �̻� (���� ����Ͽ� �ִ� �۾� �� - 1) ������ ���� ������ ������� ���� �տ� ������ 0, �� ��°�� ������ 1�� ǥ���մϴ�.
* 
* 
* # ����� ��
* 
* (����1)
* 
*   - priorities : [2, 1, 3, 2]
*   - location : 2
*   
*   - return : 1
*   
*   - ������ ���� ���� ����.
*   
* (����2)
*   
*   - priorities : [1, 1, 9, 1, 1, 1]
*   - location : 0
*   
*   - return : 5
*   
*   - 6���� ����(A,B,C,D,E,F)�� �μ� ����Ͽ� �ְ�
*     �߿䵵�� 119111 �̹Ƿ� C D E F A B������ �μ��Ѵ�.
*   
*/

public class Printer {

	
	/**
	 * 
	 * My Solution
	 * 
	 *  - ���� ��� : ����...
	 * 
	 * @param priorities
	 * @param location
	 * @return
	 */
	public int solution(int[] priorities, int location) {
        int answer = 0;
        
        int[] order = new int[priorities.length];
        
        for (int i=0; i < priorities.length; i++) {
        	
        	order[i] = i+1;
        	
        }
        
        resetOrder(priorities, order, 0);
        
        answer = order[location];
        
        return answer;
    }
	
	public void resetOrder(int[] priorities, int[] order, int sIndex) {
		
		boolean check = false;
		
		for (int i=sIndex+1; i < priorities.length; i++) {
			
			if (priorities[sIndex] < priorities[i]) {
				
				check = true;
				
			}
		
		}
		
		if (check) {
			
			int temp1 = priorities[sIndex];
			
			
			for (int i=sIndex; i < priorities.length-1; i++) {
				
				priorities[i] = priorities[i+1];
				
			}
			
			priorities[priorities.length-1] = temp1;
			
			
			int temp2 = order[order.length-1];
			
			for (int j=order.length-1; j > sIndex; j--) {
				
				order[j] = order[j-1];
				
			}
			
			order[sIndex] = temp2;
			
			resetOrder(priorities, order, sIndex);
			
		} else {
			
			if (sIndex+1 < priorities.length) {
				resetOrder(priorities, order, sIndex+1);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] priorities1 = {2, 1, 3, 2};
		int location1 = 2;
		
		int[] priorities2 = {1, 1, 9, 1, 1, 1};
		int location2 = 0;
		
		int answer1 = 0; // 1
		int answer2 = 0; // 5
		
		String show = "dk"; // default, junam, pg01, hmyk, dk
		
		if (show.equals("default")) {
			
			Printer p = new Printer();
			
			answer1 = p.solution(priorities1, location1);
			answer2 = p.solution(priorities2, location2);
			
		} else if (show.equals("junam")) {
			
			Junam jn = new Junam();
			
			answer1 = jn.solution(priorities1, location1);
			answer2 = jn.solution(priorities2, location2);
			
		} else if (show.equals("pg01")) {
			
			Programmers pg = new Programmers();
			
			answer1 = pg.solution1(priorities1, location1);
			answer2 = pg.solution1(priorities2, location2);
			
		} else if (show.equals("hmyk")) {
			
			HMYK hmyk = new HMYK();
			
			answer1 = hmyk.solution(priorities1, location1);
			answer2 = hmyk.solution(priorities2, location2);
			
		} else if (show.equals("dk")) {
			
			DeveloperDK dk = new DeveloperDK();
			
			answer1 = dk.solution(priorities1, location1);
			answer2 = dk.solution(priorities2, location2);
			
		}
		
		System.out.println("answer1 : " + answer1); // 1
		System.out.println("answer2 : " + answer2); // 5
		
		
	}
	
}
