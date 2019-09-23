package programmers.hash.problem.level3.solution.bestAlbum.developerdk;

import java.util.HashMap;
import java.util.PriorityQueue;

//https://developerdk.tistory.com/13

/**
* 
* @author developerdk
* 
* # 베스트앨범 문제 풀이
* 
* - 고유 번호(idx)와 재생 횟수(plays)를 가진 Song 클래스 생성
*
*/

public class DkSolution {

	public int[] solution(String[] genres, int[] plays) {
		
		// 장르의 순위 결정을 위한 Hash 생성
		HashMap<String, Integer> rankHash = new HashMap<String, Integer>();
		
		for (int i=0; i < plays.length; i++) {
			
			rankHash.put(genres[i], rankHash.getOrDefault(genres[i], 0) + plays[i]);
			
		}
		
		// 장르 순위 판별을 위한 우선순위 큐 생성
		// (java에서 int형 우선순위 큐는 작은 것부터 나오므로 lambda식을 이용해 역순으로 변환)
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x, y) -> y - x);
		
		for (Integer value : rankHash.values()) {
			
			pq.add(value);
			
		}
		
		// 모든 장르는 재생된 횟수가 다르므로 rankHash의 Key, Value를 바꾼 HashMap 생성
		HashMap<Integer, String> rankHashReverse = new HashMap<Integer, String>();
		
		for (String key : rankHash.keySet()) {
			
			rankHashReverse.put(rankHash.get(key), key);
			
		}
		
		// 장르의 재생 횟수를 이용하여 
		
		return null;
		
	}
	
}
