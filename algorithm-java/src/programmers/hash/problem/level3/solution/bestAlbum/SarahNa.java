package programmers.hash.problem.level3.solution.bestAlbum;

import java.util.HashMap;
import java.util.HashSet;

// https://medium.com/@nsh235482/java-coding-programmers-hash-lv3-베스트-앨범-278fa3ad4d9c

/**
 * 
 * @author Sarah Na
 * 
 * # 베스트 앨범 문제 풀이
 * 
 */

public class SarahNa {
	
	
	/**
	 * 
	 * solution
	 * 
	 * - HashSet 클래스를 이용해 장르의 고유값을 뽑아낸다.
	 * 
	 * @param genres
	 * @param plays
	 * @return answer 
	 * 
	 */
	public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        // 고유번호를 key값으로, 장르와 플레이 횟수를 value값으로 각각 HashMap을 만든다.
        // HashSet으로 장르의 종류만 뽑아낸다.
        // 그 후, 각 장르별 총 플레이 횟수가 얼마나 되는 지 계산한다.
        // 총 플레이 횟수를 key값으로 장르를 value값으로 하는 HashMap을 생성한다.
        
        // 고유번호 = key값
        // 장르, 플레이 횟수 = value값
        
        HashMap<Integer, Integer> pMap = new HashMap<Integer, Integer>();
        HashMap<Integer, String> gMap = new HashMap<Integer, String>();
        
        for (int i=0; i < genres.length; i++) {
        	
        	pMap.put(i, plays[i]);
        	gMap.put(i, genres[i]);
        	
        }
        
        // HashSet으로 장르 분류
        HashSet<String> gSet = new HashSet<String>();
        
        for (int i=0; i < genres.length; i++) {
        	
        	gSet.add(genres[i]);
        	
        }
        
        // 장르별 총 플레이 횟수
        
        
        return answer;
    }
	
}
