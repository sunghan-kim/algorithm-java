package programmers.stackAndQueue.problem.level2.solution.printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// https://ju-nam2.tistory.com/38

public class Junam {

	public int solution(int[] priorities, int location) {
		
		// answer�� ���� ���ϴ� ����Ʈ�� ��� ����
		// index�� �켱������ ���� ���ϴ� �迭�� index�� ǥ���ϱ� ���� ����
		// max_change
		//  - max_change = 0 : �켱���� �ִ밪�� ������ ����
		//  - max_change = 1 : �켱������ ������Ѿ� �Ѵٴ� ���� ǥ���ϴ� ����
		int answer = 0;
		int index = 0;
		int max_change = 0;
		
		ArrayList<Integer> prior = new ArrayList<Integer>();
		
		for (int i=0; i < priorities.length; i++) {
			
			prior.add(priorities[i]);
			
		}
		
		System.out.println(prior);
		
		// Collections.max()�� ����ϸ� ���ϴ� �ִ��� ã�� ����
		// �׷��� ������������ ����� ���
		Collections.reverse(prior);
		
		int max = prior.get(0);
		
		while(true) {
			
			// index�� ���鼭 max���� �������� ����Ʈ�ϰ� �� ���� -1�� ����
			// �ϳ��� ����Ͽ����Ƿ� answer�� �߰��ϰ� �ִ� �켱������ ���� ����Ʈ�� ��µǾ����Ƿ�,
			// max_change ����ġ�� 1�� ����
			if (priorities[index] == max) {
				
				priorities[index] = -1;
				answer++;
				max_change = 1;
				
			} else {
				
				// index�� �����ϱ� ���ؼ� �ִ밪�� �ƴ϶�� 1�� ���������ְ�
				// ������ ���ٸ� 0���� �������
				if (index == priorities.length-1) {
					
					index = 0;
					
				} else {
					
					index++;
					
				}
				
			}
			
			// ���ϴ� location�� ����Ʈ�� ��µǾ -1�� �Ǹ� break
			if (priorities[location] == -1) {
				break;
			}
			
			// max_change�� 1�� �Ǹ� ������ �ִ� 
			
		}
		
		
		return answer;
		
	}
	
}
