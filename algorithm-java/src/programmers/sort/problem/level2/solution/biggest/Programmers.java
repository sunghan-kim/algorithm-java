package programmers.sort.problem.level2.solution.biggest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/42746/solution_groups?language=java

/**
 * 
 * @author shkim
 * 
 * ���α׷��ӽ� �ٸ� ����� Ǯ�� ���
 *
 */

public class Programmers {

	/**
	 * 
	 * solution1
	 * 
	 *  - ������ , ��⹮ , �輼�� , ��ȯ , �Ȱ� �� 5 ��
	 *  - Collection ���
	 * 
	 * @param numbers
	 * @return answer
	 * 
	 */
	public String solution1(int[] numbers) {
		
		String answer = "";
		
		List<Integer> list = new ArrayList<>();
		
		
		for (int i=0; i < numbers.length; i++) {
			
			list.add(numbers[i]);
			
		}
		
		Collections.sort(list, (a,b) -> {
			
			String as = String.valueOf(a), bs = String.valueOf(b);
			return -Integer.compare(Integer.parseInt(as+bs), Integer.parseInt(bs+as));
			
		});
		
		StringBuilder sb = new StringBuilder();
		
		for (Integer i : list) {
			
			sb.append(i);
			
		}
		
		answer = sb.toString();
		
		if (answer.charAt(0) == '0') {
			
			return "0";
			
		} else {
			
			return answer;
			
		}
		
	}
	
	/**
	 * 
	 * solution2
	 * 
	 *  - JandB , �輼��
	 * 
	 * @param numbers
	 * @return
	 * 
	 */
	public String solution2(int[] numbers) {
		
		String[] s = new String[numbers.length];
		
		for (int i=0; i < numbers.length; i++) {
			
			s[i] = String.valueOf(numbers[i]);
			
		}
		
		Arrays.sort(s, new Comparator<String>() {
			
			@Override
			public int compare(String a, String b) {
				
				if (a.charAt(0) == b.charAt(0)) {
					
					int aa = Integer.parseInt(a+b);
					int bb = Integer.parseInt(b+a);
					
					return bb-aa;
					
				}
				
				return b.charAt(0) - a.charAt(0);
				
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i < s.length; i++) {
			
			sb.append(s[i]);
			
		}
		
		return sb.charAt(0) == '0' ? "0" : sb.toString();
		
	}
	
}
