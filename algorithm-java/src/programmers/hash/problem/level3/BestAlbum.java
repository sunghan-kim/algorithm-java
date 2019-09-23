package programmers.hash.problem.level3;

import java.util.Arrays;
import java.util.HashMap;

import programmers.hash.problem.level3.solution.bestAlbum.SarahNa;

// https://programmers.co.kr/learn/courses/30/lessons/42579

/**
 * 
 * @author shkim
 * 
 * ##### ����Ʈ�ٹ� #####
 * 
 * # ���� ����
 * 
 * ��Ʈ���� ����Ʈ���� �帣 ���� ���� ���� ����� �뷡�� �� ���� ��� ����Ʈ �ٹ��� ����Ϸ� �մϴ�. 
 * �뷡�� ���� ��ȣ�� �����ϸ�, �뷡�� �����ϴ� ������ ������ �����ϴ�.
 * 
 *   1. ���� �뷡�� ���� ����� �帣�� ���� �����մϴ�.
 *   2. �帣 ������ ���� ����� �뷡�� ���� �����մϴ�.
 *   3. �帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�.
 *   
 * �뷡�� �帣�� ��Ÿ���� ���ڿ� �迭 genres�� 
 * �뷡�� ��� Ƚ���� ��Ÿ���� ���� �迭 plays�� �־��� ��, 
 * ����Ʈ �ٹ��� �� �뷡�� ���� ��ȣ�� ������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
 * 
 * 
 * # ���� ����
 * 
 *   - genres[i]�� ������ȣ�� i�� �뷡�� �帣�Դϴ�.
 *   - plays[i]�� ������ȣ�� i�� �뷡�� ����� Ƚ���Դϴ�.
 *   - genres�� plays�� ���̴� ������, �̴� 1 �̻� 10,000 �����Դϴ�.
 *   - �帣 ������ 100�� �̸��Դϴ�.
 *   - �帣�� ���� ���� �ϳ����, �ϳ��� � �����մϴ�.
 *   - ��� �帣�� ����� Ƚ���� �ٸ��ϴ�.
 * 
 * 
 * 
 * # ����� ��
 * 
 * (����1)
 * 
 *   - genres : ["classic", "pop", "classic", "classic", "pop"]
 *   - plays  : [500, 600, 150, 800, 2500]
 *   
 *   - return : [4,1,3,0] 
 *   
 *   - classic �帣�� 1,450ȸ(800+500+150) ����Ǿ�����, classic �뷡�� ������ ����.
 *   
 *     - ���� ��ȣ 3 : 800ȸ ���
 *     - ���� ��ȣ 0 : 500ȸ ���
 *     - ���� ��ȣ 2 : 150ȸ ���
 *     
 *   - pop �帣�� 3,100ȸ(2500+600) ����Ǿ�����, pop �뷡�� ������ ����.
 *     
 *     - ���� ��ȣ 4 : 2,500ȸ ���
 *     - ���� ��ȣ 1 : 600ȸ ���
 *     
 *   - ����, pop �帣�� [4, 1] �� �뷡�� ����,
 *     classic �帣�� [3,0] �뷡�� �� ������ �����Ѵ�.
 *     (pop �帣�� ���Ƚ���� classic �帣�� ���Ƚ������ ���� ����)
 *   
 */

public class BestAlbum {

	
	public int[] solution1(String[] genres, int[] plays) {
        int[] answer = {};
        
        
        return answer;
        
    }
	
	public static void main(String[] args) {
		
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		int[] answer = null;
		
		String show = "sarah"; // default, sarah, dk
				
		if (show.equals("default")) {
			
			BestAlbum ba = new BestAlbum();
			
			answer = ba.solution1(genres, plays);
			
		} else if (show.equals("sarah")) {
			
			SarahNa sr = new SarahNa();
			
			answer = sr.solution(genres, plays);
			
		} else if (show.equals("dk")) {
			
			
			
		}
				
		System.out.println(Arrays.toString(answer));
		
	}
	
}
