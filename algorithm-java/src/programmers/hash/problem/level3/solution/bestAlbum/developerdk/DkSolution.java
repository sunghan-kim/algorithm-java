package programmers.hash.problem.level3.solution.bestAlbum.developerdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

// https://developerdk.tistory.com/13

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
		
		// System.out.println(rankHash.values());
		
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
		
		// �帣�� ��� Ƚ���� �̿��Ͽ� ���� ���� �帣���� rankArr�� ������� ���� (�帣�� ���� ���� �Ϸ�)
		int uniqueGenreLength = pq.size();
		String[] rankArr = new String[uniqueGenreLength];
		
		for (int i=0; i < uniqueGenreLength; i++) {
			
			rankArr[i] = rankHashReverse.get(pq.poll());
			
		}
		
		// �帣�� ������ ���������� �� �뷡�� 1, 2���� �̱� ���� HashMap ����
		HashMap<String, PriorityQueue<Song>> songsRank = new HashMap<String, PriorityQueue<Song>>();
		
		for (int i=0; i < plays.length; i++) {
			
			if (songsRank.containsKey(genres[i])) {
				
				songsRank.get(genres[i]).add(new Song(i, plays[i]));
				
			} else {
				
				songsRank.put(genres[i], new PriorityQueue<Song>());
				songsRank.get(genres[i]).add(new Song(i, plays[i]));
				
			}
			
		}
		
		// ���� ����Ʈ�� ����� rankArr�� ������ �帣 ������� �켱���� ť���� �켱 ������ ���� Song �ϳ��� �̾Ƽ� idx ����
		ArrayList<Integer> answerArrList = new ArrayList<Integer>();
		
		for (int i=0; i < rankArr.length; i++) {
			
			answerArrList.add(songsRank.get(rankArr[i]).poll().idx);
			
			// �ش� �帣�� �� ���� ���ζ�� if �� ���
			if (songsRank.get(rankArr[i]).peek() != null) {
				
				answerArrList.add(songsRank.get(rankArr[i]).poll().idx);
				
			}
			
		}
		
		// ���� ����Ʈ�� Array ���·� ��ȯ
		// .toArray()�� Object[] ���·� �����Ƿ� int[] ���·� �ٲ���
		int[] answerArr = new int[answerArrList.size()];
		Object[] answerArrObj = answerArrList.toArray();
		
		for (int i=0; i < answerArrObj.length; i++) {
			
			answerArr[i] = (int) answerArrObj[i];
			
		}
		
		return answerArr;
		
	}
	
}
