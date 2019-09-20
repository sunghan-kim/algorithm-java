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
 * ##### ���� #####
 * 
 * # ���� ����
 * 
 * �����̵��� ���� �ٸ� ���� �����Ͽ� �Ծ� �ڽ��� �����մϴ�.
 * ���� ��� 
 *   - �����̰� ���� ���� �Ʒ��� ����
 *     - �� : ���׶� �Ȱ�, ���� ���۶�
 *     - ���� : �Ķ��� Ƽ����
 *     - ���� : û����
 *     - �ѿ� : �� ��Ʈ
 *     
 *   - ���� �����̰� ���׶� �Ȱ�, �� ��Ʈ, �Ķ��� Ƽ������ �Ծ��ٸ� 
 *     �������� û������ �߰��� �԰ų� 
 *     ���׶� �Ȱ� ��� ���� ���۶󽺸� �����ϰų� �ؾ� �մϴ�.
 *     
 * �����̰� ���� �ǻ���� ��� 2���� �迭 clothes�� �־��� �� 
 * ���� �ٸ� ���� ������ ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 
 * # ���� ����
 * 
 * - clothes�� �� ���� [�ǻ��� �̸�, �ǻ��� ����]�� �̷���� �ֽ��ϴ�.
 * - �����̰� ���� �ǻ��� ���� 1�� �̻� 30�� �����Դϴ�.
 * - ���� �̸��� ���� �ǻ��� �������� �ʽ��ϴ�.
 * - clothes�� ��� ���Ҵ� ���ڿ��� �̷���� �ֽ��ϴ�.
 * - ��� ���ڿ��� ���̴� 1 �̻� 20 ������ �ڿ����̰� 
 *   ���ĺ� �ҹ��� �Ǵ� '_' �θ� �̷���� �ֽ��ϴ�.
 * - �����̴� �Ϸ翡 �ּ� �� ���� �ǻ��� �Խ��ϴ�.
 * 
 * # ����� ��
 * 
 * (����1)
 * 
 *   - clothes
 *     : [[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]
 *   - return
 *     : 5
 *     
 *   - headgear�� �ش��ϴ� �ǻ��� yellow_hat, greenturban �̰�
 *     eyewear�� �ش��ϴ� �ǻ��� blue_sunglasses�̹Ƿ�
 *     �Ʒ��� ���� 5���� ������ �����ϴ�.
 *     
 *     1. yellow_hat
 *     2. blue_sunglasses
 *     3. green_turban
 *     4. yeloow_hat + blue_sunglass
 *     5. green_turban + blue_sunglass
 *     
 * (����2)
 * 
 *   - clothes
 *     : [[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]
 *   - return
 *     : 3
 *     
 *   - face�� �ش��ϴ� �ǻ��� crow_mask, blue_sunglasses, smoky_makeup�̹Ƿ�
 *     �Ʒ��� ���� 3���� ������ �����ϴ�.
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
	 * ����� �� ��� ��� (https://tallman.tistory.com/7 ����)
	 * 
	 * ex) �谡 a,b,c ��� �̸����� 3���� �ְ�, ���� e,f�� 2��, ����� g,h,i�� 3���� �ִٰ� ����.
	 * 
	 *   - �� (4���� ��� ����)
	 *     - a�� ����� ���
	 *     - b�� ����� �ܿ�
	 *     - c�� ����� ���
	 *     - �� ���� ���� ���
	 *     
	 *   - �� (3���� ��� ����)
	 *     - e�� ����� ���
	 *     - f�� ����� ���
	 *     - ���� ���� ���� ���
	 *     
	 *   - ��� (4���� ��� ����)
	 *     - g�� ����� ���
	 *     - h�� ����� ���
	 *     - i�� ����� ���
	 *     - ����� ���� ���� ���
	 *     
	 *   - ���� ��, ��, ����� ���� ����� ���� ���ϸ� ��ü ����� ���� �ȴ�.
	 *   - ������, ���� ���׿� ���� �ּ� �ϳ��� ������ ���� �ϹǷ�, ��, ��, ����� ��� ���� �ʴ� ��� �ϳ��� ����� �Ѵ�.
	 *   - ��,
	 *     (3 + 1) * (2 + 1) * (3 + 1) -1
	 *     �� �ȴ�.
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
        
        // Iterator Ŭ������ �̿�
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
