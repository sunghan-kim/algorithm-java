package programmers.hash.problem.level2.solution.spy;

import java.util.HashMap;

// https://2ssue.github.io/algorithm/programmers_42578/#

/**
 * 
 * @author 2ssue
 * 
 * # 위장 문제 풀이
 * 
 * - 이 문제에서 필요한 것 -> 옷 종류의 개수가 몇 가지 있는가?
 * - 따라서 옷 종류의 이름은 쓸모없는 값이 된다.
 * 
 * - '{옷 종류}: {총 갯수}' 와 같은 형태로 매칭되어야 하므로,
 *   'key: value' 형태와 비슷하다고 생각해 HashMap을 사용했다.
 *   
 * - 경우의 수를 구하는 공식
 * 
 *   - 4종류의 옷과 그 옷이 {n, m, o, p}의 개수로 있을 때 아래와 같음
 *   
 *    : (n+1) * (m+1) * (o+1) * (p+1) - 1
 *   
 *   - 각 종류들은 하나를 입거나, 안입거나의 선택지가 있기 떄문에
 *     옷의 개수에 안입는 선택지를 하나 추가한다.
 *   - 그리고 옷을 고르는 선택은 동시에 일어나므로 각 옷들을 곱해 경우의 수를 계산한다.
 *   - 이 때, 하나도 안입는 선택지는 없으므로 그 경우의 수 하나를 뺀다.   
 *  
 *
 */

public class Twossue {

	/**
	 * # solution1
	 * 
	 * @param clothes
	 * @return answer
	 * 
	 */
	public int solution1(String[][] clothes) {
		
		int answer = 1;
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i=0; i < clothes.length; i++) {
			
			if (map.get(clothes[i][1]) == null) {
				
				map.put(clothes[i][1], 1);
				
			} else {
				
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
				
			}
			
		}
		
		// HashMap의 keySet() 메서드와 get() 메서드 이용
		for (String keys : map.keySet()) {
			
			answer *= (map.get(keys) + 1);
			
		}
		
		answer -= 1;
		
		return answer;
		
	}
	
}
