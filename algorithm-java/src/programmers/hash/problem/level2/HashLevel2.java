package programmers.hash.problem.level2;

import programmers.hash.problem.level2.solution.Jhnyang;

// https://programmers.co.kr/learn/courses/30/lessons/42577

/**
 * 
 * @author shkim
 * 
 * ##### 전화번호 목록 #####
 * 
 * 
 * # 문제 설명
 * 
 * 전화번호부에 적힌 전화번호 중, 
 * 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 * 
 *   - 구조대 : 119
 *   - 박준영 : 97 674 223
 *   - 지영석 : 11 9552 4421
 *   
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 
 * solution 함수의 매개변수로 주어질 때, 
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 
 * 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 *
 * # 제한사항
 * 
 * - phone_book의 길이는 1 이상 1,000,000 이하입니다.
 * - 각 전화번호의 길이는 1 이상 20 이하입니다.
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
