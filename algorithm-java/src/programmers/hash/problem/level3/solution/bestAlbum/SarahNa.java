package programmers.hash.problem.level3.solution.bestAlbum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
// import java.util.*;

// https://medium.com/@nsh235482/java-coding-programmers-hash-lv3-����Ʈ-�ٹ�-278fa3ad4d9c

/**
 * 
 * @author Sarah Na
 * 
 * # ����Ʈ �ٹ� ���� Ǯ��
 * 
 */

public class SarahNa {
	
	
	/**
	 * 
	 * solution
	 * 
	 * - HashSet Ŭ������ �̿��� �帣�� �������� �̾Ƴ���. (�ߺ� ����)
	 * - TreeMap Ŭ������ �̿��� �������� ����
	 * 
	 * @param genres
	 * @param plays
	 * @return answer 
	 * 
	 */
	public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        // ������ȣ�� key������, �帣�� �÷��� Ƚ���� value������ ���� HashMap�� �����.
        // HashSet���� �帣�� ������ �̾Ƴ���.
        // �� ��, �� �帣�� �� �÷��� Ƚ���� �󸶳� �Ǵ� �� ����Ѵ�.
        // �� �÷��� Ƚ���� key������ �帣�� value������ �ϴ� HashMap�� �����Ѵ�.
        
        // ������ȣ = key��
        // �帣, �÷��� Ƚ�� = value��
        
        HashMap<Integer, Integer> pMap = new HashMap<Integer, Integer>();
        HashMap<Integer, String> gMap = new HashMap<Integer, String>();
        
        for (int i=0; i < genres.length; i++) {
        	
        	pMap.put(i, plays[i]);
        	gMap.put(i, genres[i]);
        	
        }
        
        // HashSet���� �帣 �з�
        HashSet<String> gSet = new HashSet<String>();
        
        for (int i=0; i < genres.length; i++) {
        	
        	gSet.add(genres[i]);
        	
        }
        
        // �帣�� �� �÷��� Ƚ��
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
        
        // �÷��� Ƚ���� ����(Ű ���� �������� ����, TreeMap)
        TreeMap sort = new TreeMap(coPlay);
        
        String[] sortGenre = new String[gSet.size()];
        int index = 0;
        
        for (Object o : sort.keySet()) {
        	
        	sortGenre[index] = sort.get(o).toString();
        	index++;
        	
        }
        
        // �帣�� ���� �÷��� �� �뷡�� ������ȣ ã��
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
        
        // ArrayList�� �Ϲ� �迭�� �����Ͽ� ����
        answer = new int[fIndex.size()];
        
        for (int i=0; i < fIndex.size(); i++) {
        	
        	answer[i] = fIndex.get(i);
        	
        }
        
        return answer;
    }
	
}
