package programmers.hash.problem.level3.solution.bestAlbum;

import java.util.HashMap;
import java.util.HashSet;

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
	 * - HashSet Ŭ������ �̿��� �帣�� �������� �̾Ƴ���.
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
        
        
        return answer;
    }
	
}
