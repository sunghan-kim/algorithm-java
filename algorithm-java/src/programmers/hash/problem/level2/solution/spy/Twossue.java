package programmers.hash.problem.level2.solution.spy;

import java.util.HashMap;

// https://2ssue.github.io/algorithm/programmers_42578/#

/**
 * 
 * @author 2ssue
 * 
 * # ���� ���� Ǯ��
 * 
 * - �� �������� �ʿ��� �� -> �� ������ ������ �� ���� �ִ°�?
 * - ���� �� ������ �̸��� ������� ���� �ȴ�.
 * 
 * - '{�� ����}: {�� ����}' �� ���� ���·� ��Ī�Ǿ�� �ϹǷ�,
 *   'key: value' ���¿� ����ϴٰ� ������ HashMap�� ����ߴ�.
 *   
 * - ����� ���� ���ϴ� ����
 * 
 *   - 4������ �ʰ� �� ���� {n, m, o, p}�� ������ ���� �� �Ʒ��� ����
 *   
 *    : (n+1) * (m+1) * (o+1) * (p+1) - 1
 *   
 *   - �� �������� �ϳ��� �԰ų�, ���԰ų��� �������� �ֱ� ������
 *     ���� ������ ���Դ� �������� �ϳ� �߰��Ѵ�.
 *   - �׸��� ���� ���� ������ ���ÿ� �Ͼ�Ƿ� �� �ʵ��� ���� ����� ���� ����Ѵ�.
 *   - �� ��, �ϳ��� ���Դ� �������� �����Ƿ� �� ����� �� �ϳ��� ����.   
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
		
		// HashMap�� keySet() �޼���� get() �޼��� �̿�
		for (String keys : map.keySet()) {
			
			answer *= (map.get(keys) + 1);
			
		}
		
		answer -= 1;
		
		return answer;
		
	}
	
}
