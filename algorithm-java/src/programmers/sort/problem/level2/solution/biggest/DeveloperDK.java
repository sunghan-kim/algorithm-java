package programmers.sort.problem.level2.solution.biggest;

import java.util.Arrays;
import java.util.Comparator;

// https://developerdk.tistory.com/24

public class DeveloperDK {

	/**
	 * 
	 * @param numbers
	 * @return
	 * 
	 * - ���� ��� : ����...
	 */
	public String solution(int[] numbers) {
		
		String answer = "";
		
		// int �迭�� String �迭�� ��ȯ
		String[] arr = new String[numbers.length];
		
		for (int i=0; i < numbers.length; i++) {
			
			arr[i] = (String.valueOf(numbers[i]));
			
		}
		
		System.out.println(Arrays.toString(arr));
		
		// �迭 ����
		//  - ���� ��Ģ���δ� 2���� ���Ͽ� �� ū ���� �켱������ �ֵ��� ����
		Arrays.sort(arr, new Comparator<String>() {
			
			@Override
			public int compare(String s1, String s2) {
				
				return (s2+s1).compareTo(s1+s2);
			}
			
		});
		
		
		System.out.println(Arrays.toString(arr));
		
		// 0000 ó�� 0���θ� �����Ǿ� ������ 0 return
		if (arr[0].equals("0")) return "0";
		
		// �� ���� ��� ���������� �����Ͽ� answer return
		for (int i=0; i < arr.length; i++) {
			
			answer += arr[i];
			
		}
		
		return answer;
		
	}
	
	public static void main(String[] args) {
		
		String a = "20";
		String b = "10";
		
		System.out.println(a.compareTo(b));
		
	}
	
}
