package programmers.sort.problem.level2.solution.HIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// https://developerdk.tistory.com/27


/**
 * 
 * @author mktinfo
 * 
 *   - ������ ���� h�� ���� �ο��
 *   -> "h�� �̻� �ο�� ���� h�� �̻��� h�� �ִ밪"�� ã�� ����
 *
 */
public class DeveloperDK {

	/**
	 * 
	 * solution1
	 * 
	 *   - ������ : ����
	 * 
	 * @param citations
	 * @return
	 */
	public int solution1(int[] citations) {
		
		int answer = 0;
		
		// Int[]�� ��������(Collections.reverseOrder())���� ������ �� �����Ƿ�
		// Integer[]�� �ٲٰ� ����
		Integer[] cArr = new Integer[citations.length];
		
		for (int i=0; i < citations.length; i++) {
			
			cArr[i] = citations[i];
			
		}
		
		Arrays.sort(cArr, Collections.reverseOrder());
		
		
		// [6,5,3,1,0]
		// - 6 > 0
		// - 5 > 1
		// - 3 > 2
		// ---------- return 3
		// - 1 < 3
		// - 0 < 4
		
		// �ο�� �� ���� i+1(��)���� �۾��� �� i�� return
		for (int i=0; i < citations.length; i++) {
			
			System.out.println(cArr[i] + " : " + (i+1));
			
			if (cArr[i] < i+1) {
				
				return i;
				
			}
			
		}
		
		// [30,40] �� ���� ������ �ο���� �ּҰ����� ���� ���
		// �ش� ������ �������� ���ϹǷ� ���� ������ return
        return citations.length;
		
	}
	
	/**
	 * 
	 * solution2
	 * 
	 *  - ���� ��� : ����
	 * 
	 * @param citations
	 * @return
	 */
	public int solution2(int[] citations) {
		
		//int answer = 0;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i=0; i < citations.length; i++) {
			list.add(citations[i]);
		}
		
		Collections.sort(list);
		Collections.reverse(list);
		
		System.out.println(list);
		
		for (int i=0; i < citations.length; i++) {
			
			if (list.get(i) < i+1) {
				return i;
			}
			
		}
		
		return citations.length;
		
		
	}
	
	public static void main(String[] args) {
		
		int[] citations = {3, 0, 6, 1, 5};
		
		DeveloperDK dk = new DeveloperDK();
		
		int answer1 = 0;
		answer1 = dk.solution1(citations);
		
		System.out.println(answer1);
		
		int answer2 = 0;
		//answer2 = dk.solution2(citations);
		
		//System.out.println(answer2);
		
	}
	
}
