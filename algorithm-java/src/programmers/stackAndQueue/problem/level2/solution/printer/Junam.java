package programmers.stackAndQueue.problem.level2.solution.printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// https://ju-nam2.tistory.com/38


/**
 * 
 * @author shkim
 * 
 * - ������ : ����
 *
 */
public class Junam {

	public int solution(int[] priorities, int location) {
		
		// answer : ���� ���ϴ� ����Ʈ�� ��� ����
		int answer = 0;
		
		// index : �켱������ ���� ���ϴ� �迭�� index�� ǥ���ϱ� ���� ����
		int index = 0;
		
		// max_change
		//  - max_change = 0 : �켱���� �ִ밪�� ������ ����
		//  - max_change = 1 : �켱������ ������Ѿ� �Ѵٴ� ���� ǥ���ϴ� ����
		int max_change = 0;
		
		ArrayList<Integer> prior = new ArrayList<Integer>();
		
		for (int i=0; i < priorities.length; i++) {
			prior.add(priorities[i]);
		}
		
		// Collections.max()�� ����ϸ� ���ϴ� �ִ��� ã�Ⱑ ����
		// ���� ������������ �����Ͽ� ���
		Collections.sort(prior);
		Collections.reverse(prior);
		
		int max = prior.get(0);
		
		while(true) {
			
			System.out.println(prior);
			
			/*
			 * index�� ���鼭 max���� �������� ����Ʈ�ϰ� �� ���� -1�� ������ش�.
			 * �ϳ��� ����Ͽ����Ƿ� answer�� �߰���Ű�� �ִ� �켱������ ���� ����Ʈ�� ��µǾ����Ƿ�
			 * max_change ����ġ�� 1�� �ٲ��ش�.
			 */
			if (priorities[index] == max) {
				
				priorities[index] = -1;
				answer++;
				max_change = 1;
				
			} else {
				
				// index�� �����ϱ� ���ؼ� �ִ밪�� �ƴ϶�� 1�� ����������
				// ������ ���ٸ� 0���� ������ش�.
				if (index == priorities.length-1) {
					
					index = 0;
					
				} else {
					
					index++;
					
				}
				
			}
			
			// ���ϴ� location�� ����Ʈ�� ��µǾ -1�� �ȴٸ� break�Ѵ�.
			if (priorities[location] == -1) {
				
				break;
				
			}
			
			// max_change�� 1�� �Ǹ� ������ �ִ� �켱������ �������ְ� max�� �ٲ��ش�.
			// max_change�� 0���� �ٽ� ������ ����ġ�� ���ش�.
			if (max_change == 1) {
				
				prior.remove(0);
				max = prior.get(0);
				max_change = 0;
				
			}
			
		}
		
		return answer;
		
	}
	
	
	
}
