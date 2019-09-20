package programmers.hash.problem.level2.solution.spy;

import java.util.HashMap;

// https://developerdk.tistory.com/12

/**
 * 
 * @author developerdk
 * 
 * # ���� ���� Ǯ��
 *
 */

public class Developerdk {

	/**
	 * 
	 * # solution1
	 * 
	 *   - �������� ���� �̸��� ���� �����Ƿ� HashMap<����, ����Ƚ��>�� �̿���
	 *   
	 *   1. ó�� �����ϴ� Key�� ����Ƚ���� 1�� ����
	 *   2. �� ���� ������ʹ� ���� ���� 1�� ����
	 *   3. ���� �� �ִ� �� ������ �� : �� �������� �������� ������ ����(+1)�� �����Ͽ� ����
	 *     3.1 (A ���� �� ������ + 1) * (B ���� �� ���� �� + 1) * (C ���� �� ���� �� + 1) -1
	 *     3.2 �������� -1 �� �ƹ��͵� �������� ���� ��츦 ���־��ϹǷ� ����
	 *   
	 * 
	 * @param clothes
	 * @return answer
	 * 
	 * ���� ��� : ����
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
        
        // HashMap�� values() �޼��带 ��
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
