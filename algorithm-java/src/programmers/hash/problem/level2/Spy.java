package programmers.hash.problem.level2;

import java.util.HashMap;
import java.util.Iterator;

import programmers.hash.problem.level2.solution.spy.Developerdk;
import programmers.hash.problem.level2.solution.spy.Twossue;

// https://programmers.co.kr/learn/courses/30/lessons/42578


/**
 * 
 * @author shkim
 * 
 * ##### 위장 #####
 * 
 * # 문제 설명
 * 
 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
 * 예를 들어 
 *   - 스파이가 가진 옷이 아래와 같음
 *     - 얼굴 : 동그란 안경, 검정 선글라스
 *     - 상의 : 파란색 티셔츠
 *     - 하위 : 청바지
 *     - 겉옷 : 긴 코트
 *     
 *   - 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 
 *     다음날은 청바지를 추가로 입거나 
 *     동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 *     
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 
 * 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 * 
 * 
 * # 제한 사항
 * 
 * - clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 * - 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
 * - 같은 이름을 가진 의상은 존재하지 않습니다.
 * - clothes의 모든 원소는 문자열로 이루어져 있습니다.
 * - 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 
 *   알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
 * - 스파이는 하루에 최소 한 개의 의상은 입습니다.
 * 
 * # 입출력 예
 * 
 * (예시1)
 * 
 *   - clothes
 *     : [[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]
 *   - return
 *     : 5
 *     
 *   - headgear에 해당하는 의상이 yellow_hat, greenturban 이고
 *     eyewear에 해당하는 의상이 blue_sunglasses이므로
 *     아래와 같이 5개의 조합이 가능하다.
 *     
 *     1. yellow_hat
 *     2. blue_sunglasses
 *     3. green_turban
 *     4. yeloow_hat + blue_sunglass
 *     5. green_turban + blue_sunglass
 *     
 * (예시2)
 * 
 *   - clothes
 *     : [[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]
 *   - return
 *     : 3
 *     
 *   - face에 해당하는 의상이 crow_mask, blue_sunglasses, smoky_makeup이므로
 *     아래와 같이 3개의 조합이 가능하다.
 *     
 *     1. crow_mask
 *     2. blue_sunglasses
 *     3. smoky_makeup
 *
 */

public class Spy {

	
	/**
	 * 
	 * @param clothes
	 * @return answer
	 * 
	 * 경우의 수 계산 방법 (https://tallman.tistory.com/7 참고)
	 * 
	 * ex) 배가 a,b,c 라는 이름으로 3개가 있고, 귤은 e,f로 2개, 사과가 g,h,i로 3개가 있다고 하자.
	 * 
	 *   - 배 (4가지 경우 존재)
	 *     - a를 골랐을 경우
	 *     - b를 골랐을 겨우
	 *     - c를 골랐을 경우
	 *     - 배 고르지 않을 경우
	 *     
	 *   - 귤 (3가지 경우 존재)
	 *     - e를 골랐을 경우
	 *     - f를 골랐을 경우
	 *     - 귤을 고르지 않을 경우
	 *     
	 *   - 사과 (4가지 경우 존재)
	 *     - g를 골랐을 경우
	 *     - h를 골랐을 경우
	 *     - i를 골랐을 경우
	 *     - 사과를 고르지 않을 경우
	 *     
	 *   - 위의 배, 귤, 사과를 고르는 경우의 수를 곱하면 전체 경우의 수가 된다.
	 *   - 하지만, 제한 사항에 의해 최소 하나의 과일을 골라야 하므로, 배, 귤, 사과를 모두 고르지 않는 경우 하나를 빼줘야 한다.
	 *   - 즉,
	 *     (3 + 1) * (2 + 1) * (3 + 1) -1
	 *     이 된다.
	 */
	public int solution(String[][] clothes) {
		
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i=0; i < clothes.length; i++) {
        	
        	String key = clothes[i][1];
        	
        	if (!map.containsKey(key)) {
        		map.put(key, 1);
        	} else {
        		map.replace(key, map.get(key)+1);
        	}
        	
        }
        
        // Iterator 클래스를 이용
        Iterator<Integer> it = map.values().iterator();
        
        while(it.hasNext()) {
        	
        	answer *= it.next().intValue()+1;
        	
        }
        
        answer -= 1;
        
        return answer;
        
    }
	
	public static void main(String[] args) {
		
		String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		
		int answer1 = 0;
		int answer2 = 0;
		
		String show = "2ssue"; // default, dk_01, 2ssue
		
		if (show.equals("default")) {
			
			Spy spy = new Spy();
			
			answer1 = spy.solution(clothes1);
			answer2 = spy.solution(clothes2);
			
		} else if (show.equals("dk_01")) {
			
			Developerdk dk = new Developerdk();
			
			answer1 = dk.solution1(clothes1);
			answer2 = dk.solution1(clothes2);
			
			
		} else if (show.equals("2ssue")) {
			
			Twossue twossue = new Twossue();
			
			answer1 = twossue.solution1(clothes1);
			answer2 = twossue.solution1(clothes2);
			
		}
		
		System.out.println(answer1); // 5
		System.out.println(answer2); // 3
		
		
		
		
	}
	
}
