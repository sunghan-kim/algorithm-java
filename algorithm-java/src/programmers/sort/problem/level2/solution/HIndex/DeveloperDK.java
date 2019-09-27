package programmers.sort.problem.level2.solution.HIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// https://developerdk.tistory.com/27


/**
 * 
 * @author mktinfo
 * 
 *   - 나머지 논문이 h번 이하 인용됨
 *   -> "h번 이상 인용된 논문이 h편 이상인 h의 최대값"을 찾는 문제
 *
 */
public class DeveloperDK {

	/**
	 * 
	 * solution1
	 * 
	 *   - 제출결과 : 성공
	 * 
	 * @param citations
	 * @return
	 */
	public int solution1(int[] citations) {
		
		int answer = 0;
		
		// Int[]는 내림차순(Collections.reverseOrder())으로 정렬할 수 없으므로
		// Integer[]로 바꾸고 정렬
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
		
		// 인용된 논문 수가 i+1(편)보다 작아질 때 i를 return
		for (int i=0; i < citations.length; i++) {
			
			System.out.println(cArr[i] + " : " + (i+1));
			
			if (cArr[i] < i+1) {
				
				return i;
				
			}
			
		}
		
		// [30,40] 등 논문의 갯수가 인용수의 최소값보다 작은 경우
		// 해당 조건을 만족하지 못하므로 논문의 갯수를 return
        return citations.length;
		
	}
	
	/**
	 * 
	 * solution2
	 * 
	 *  - 제출 결과 : 성공
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
