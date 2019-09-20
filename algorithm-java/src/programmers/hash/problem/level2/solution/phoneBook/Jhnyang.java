package programmers.hash.problem.level2.solution.phoneBook;

import java.util.Arrays;

// https://jhnyang.tistory.com/124

/**
 * 
 * @author shkim
 * 
 * # 전화번호 목록 문제 풀이
 *
 */

public class Jhnyang {
	
	/**
	 * 
	 * # solution1
	 * 
	 *   - String의 startWith() 메서드 이용
	 * 
	 * @param phone_book
	 * @return answer
	 * 
	 * 
	 * 제출결과 : 실패
	 * 
	 *   - 효율성 테스트 시간 초과로 인한 실패
	 * 
	 */
	public boolean solution1(String[] phone_book) {
	     
		boolean answer = true;
		
		for (int i=0; i < phone_book.length-1; i++) {
			
			for (int j=i+1; j < phone_book.length; j++) {
				
				if (phone_book[i].startsWith(phone_book[j])) answer = false;
				if (phone_book[j].startsWith(phone_book[i])) answer = false;
				
			}
			
		}
		
        return answer;
        
    }
	
	
	/**
	 * 
	 * # solution2
	 * 
	 *   - Arrays.sort() 메서드 이용 정렬 후 비교
	 * 
	 * @param phone_book
	 * @return answer
	 * 
	 * 제출결과  : 성공
	 * 
	 */
	public boolean solution2(String[] phone_book) {
		
		boolean answer = true;
		
		Arrays.sort(phone_book);

		for (int i=0; i < phone_book.length - 1; i++) {
			
			if (phone_book[i+1].startsWith(phone_book[i])) {
				
				answer = false;
				break;
				
			}
			
		}
		
		return answer;
		
	}
	
	
	public static void main(String[] args) {
		
		
		Jhnyang j = new Jhnyang();
		
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		//boolean result = j.solution1(phone_book);
		boolean result = j.solution2(phone_book);
		
		System.out.println(result);
		
		
	}
	
}
