package programmers.hash.problem.level3.solution.bestAlbum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
// import java.util.*;

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
	 * - HashSet 클래스를 이용해 장르의 고유값을 뽑아낸다. (중복 제거)
	 * - TreeMap 클래스를 이용해 오름차순 정렬
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
        HashMap<Integer, String> coPlay = new HashMap<Integer, String>();
        
        for (String x : gSet) {
        	
        	int count = 0;
        	
        	for (int i=0; i < gMap.size(); i++) {
        		
        		if (gMap.get(i).equals(x)) {
        			
        			count += pMap.get(i);
        			
        		}
        		
        	}
        	
        	coPlay.put(count, x);
        	
        }
        
        // 플레이 횟수별 정렬(키 값을 기준으로 정렬, TreeMap)
        TreeMap sort = new TreeMap(coPlay);
        
        String[] sortGenre = new String[gSet.size()];
        int index = 0;
        
        for (Object o : sort.keySet()) {
        	
        	sortGenre[index] = sort.get(o).toString();
        	index++;
        	
        }
        
        // 장르별 많이 플레이 된 노래의 고유번호 찾기
        ArrayList<Integer> fIndex = new ArrayList<Integer>();
        
        for (int i=sortGenre.length-1; i >= 0; i--) {
        	
        	int count = 0;
        	
        	for (int p1 : gMap.keySet()) {
        		
        		if (sortGenre[i].equals(gMap.get(p1))) {
        			count++;
        		}
        		
        	}
        	
        	int [] temp = new int[count];
        	
        	int k = 0;
        	
        	for (int p2 : gMap.keySet()) {
        		
        		if (sortGenre[i].equals(gMap.get(p2))) {
        			temp[k] = pMap.get(p2);
        			k++;
        		}
        		
        	}
        	
        	if (temp.length != 1) {
        		
        		Arrays.sort(temp);
        		
        		for (int j=temp.length-1; j >= temp.length-2; j--) {
        			
        			for (int p : pMap.keySet()) {
        				
        				if (temp[j] == pMap.get(p)) {
        					
        					fIndex.add(p);
        					pMap.put(p, 0);
        					break;
        					
        				}
        				
        			}
        			
        		}
        		
        	} else {
        		
        		for (int p : pMap.keySet()) {
        			
        			if (temp[0] == pMap.get(p)) {
        				
        				fIndex.add(p);
        				pMap.put(p, 0);
        				break;
        				
        			}
        			
        		}
        		
        	}
        	
        }
        
        // ArrayList를 일반 배열로 복사하여 리턴
        answer = new int[fIndex.size()];
        
        for (int i=0; i < fIndex.size(); i++) {
        	
        	answer[i] = fIndex.get(i);
        	
        }
        
        return answer;
    }
	
}
