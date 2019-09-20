package programmers.hash.problem.level2.solution.spy;

import java.util.HashMap;

// https://developerdk.tistory.com/12

/**
 * 
 * @author developerdk
 * 
 * # 위장 문제 풀이
 *
 */

public class Developerdk {

	/**
	 * 
	 * # solution1
	 * 
	 *   - 종류별로 같은 이름의 옷은 없으므로 HashMap<종류, 등장횟수>를 이용함
	 *   
	 *   1. 처음 등장하는 Key는 등장횟수를 1로 설정
	 *   2. 그 이후 등장부터는 기존 값에 1을 더함
	 *   3. 입을 수 있는 옷 종류의 수 : 각 종류별로 선택할지 안할지 여부(+1)를 포함하여 구현
	 *     3.1 (A 종류 옷 가지수 + 1) * (B 종류 옷 가지 수 + 1) * (C 종류 옷 가지 수 + 1) -1
	 *     3.2 마지막의 -1 은 아무것도 선택하지 않은 경우를 없애야하므로 제외
	 *   
	 * 
	 * @param clothes
	 * @return answer
	 * 
	 * 제출 결과 : 성공
	 * 
	 */
	public int solution1(String[][] clothes) {
		
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        for (int i=0; i < clothes.length; i++) {
        	
        	if (hm.containsKey(clothes[i][1])) {
        		
        		hm.replace(clothes[i][1], hm.get(clothes[i][1]) + 1); // 2
        		
        	} else {
        		
        		hm.put(clothes[i][1], 1); // 1
        		
        	}
        	
        }
        
        int answer = 1;
        
        // HashMap의 values() 메서드를 이
        for (int value : hm.values()) {
        	
        	answer *= (value + 1); // 3.1, 3.2
        	
        }
        
        answer -= 1; // 3.2
        
        return answer;
        
    }	
	
	
	public static void main(String[] args) {
		
		String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		
		int answer1 = 0;
		int answer2 = 0;
		
		for (int i=0; i < clothes1.length; i++) {
			
			for (int j=0; j < clothes1[i].length; j++) {
				
				System.out.println(clothes1[i][j]);
				
			}
			
		}
		
	}
	
}
