package programmers.hash.problem.level2;

import programmers.hash.problem.level2.solution.Jhnyang;

// https://programmers.co.kr/learn/courses/30/lessons/42577

/**
 * 
 * @author shkim
 * 
 * ##### ��ȭ��ȣ ��� #####
 * 
 * 
 * # ���� ����
 * 
 * ��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��, 
 * �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 �ִ��� Ȯ���Ϸ� �մϴ�.
 * ��ȭ��ȣ�� ������ ���� ���, ������ ��ȭ��ȣ�� �������� ��ȭ��ȣ�� ���λ��Դϴ�.
 * 
 *   - ������ : 119
 *   - ���ؿ� : 97 674 223
 *   - ������ : 11 9552 4421
 *   
 * ��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book �� 
 * solution �Լ��� �Ű������� �־��� ��, 
 * � ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� 
 * �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 *
 * # ���ѻ���
 * 
 * - phone_book�� ���̴� 1 �̻� 1,000,000 �����Դϴ�.
 * - �� ��ȭ��ȣ�� ���̴� 1 �̻� 20 �����Դϴ�.
 *
 */

public class HashLevel2 {
	
	public boolean solution(String[] phone_book) {
     
		boolean answer = true;
		
		for (int i=0; i < phone_book.length - 1; i++) {
			
			for (int j=i+1; j < phone_book.length; j++) {
				
				if (phone_book[j].startsWith(phone_book[i])) answer = false;
				if (phone_book[i].startsWith(phone_book[j])) answer = false;
				
				
			}
			
		}
		
        return answer;
        
    }
	
	public static void main(String[] args) {
		
		String[] phone_book1 = {"119", "97674223", "1195524421"}; 
		String[] phone_book2 = {"123", "456", "789"};
		String[] phone_book3 = {"12", "123", "1235", "567", "88"};
		
		boolean return1 = true;
		boolean return2 = true;
		boolean return3 = true;
		
		String show = "default"; // default, jhnyang_01, jhnyang_02
		
		if (show.equals("default")) {
			
			HashLevel2 hashlvl2 = new HashLevel2();
			
			return1 = hashlvl2.solution(phone_book1);
			return2 = hashlvl2.solution(phone_book2);
			return3 = hashlvl2.solution(phone_book3);
			
		} else if (show.equals("jhnyang_01")) {
			
			Jhnyang j = new Jhnyang();
			
			return1 = j.solution1(phone_book1);
			return2 = j.solution1(phone_book2);
			return3 = j.solution1(phone_book3);
			
		} else if (show.equals("jhnyang_02")) {
			
			Jhnyang j = new Jhnyang();
			
			return1 = j.solution2(phone_book1);
			return2 = j.solution2(phone_book2);
			return3 = j.solution2(phone_book3);
			
		} else {
			System.out.println("select again");
		}
		
		System.out.println(return1); // false
		System.out.println(return2); // true
		System.out.println(return3); // false
		
		
		
		
	}
	
}
