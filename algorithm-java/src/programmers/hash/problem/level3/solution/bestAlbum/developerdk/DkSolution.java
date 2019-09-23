package programmers.hash.problem.level3.solution.bestAlbum.developerdk;

import java.util.HashMap;
import java.util.PriorityQueue;

//https://developerdk.tistory.com/13

/**
* 
* @author developerdk
* 
* # ����Ʈ�ٹ� ���� Ǯ��
* 
* - ���� ��ȣ(idx)�� ��� Ƚ��(plays)�� ���� Song Ŭ���� ����
*
*/

public class DkSolution {

	public int[] solution(String[] genres, int[] plays) {
		
		// �帣�� ���� ������ ���� Hash ����
		HashMap<String, Integer> rankHash = new HashMap<String, Integer>();
		
		for (int i=0; i < plays.length; i++) {
			
			rankHash.put(genres[i], rankHash.getOrDefault(genres[i], 0) + plays[i]);
			
		}
		
		// �帣 ���� �Ǻ��� ���� �켱���� ť ����
		// (java���� int�� �켱���� ť�� ���� �ͺ��� �����Ƿ� lambda���� �̿��� �������� ��ȯ)
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x, y) -> y - x);
		
		for (Integer value : rankHash.values()) {
			
			pq.add(value);
			
		}
		
		// ��� �帣�� ����� Ƚ���� �ٸ��Ƿ� rankHash�� Key, Value�� �ٲ� HashMap ����
		HashMap<Integer, String> rankHashReverse = new HashMap<Integer, String>();
		
		for (String key : rankHash.keySet()) {
			
			rankHashReverse.put(rankHash.get(key), key);
			
		}
		
		// �帣�� ��� Ƚ���� �̿��Ͽ� 
		
		return null;
		
	}
	
}
