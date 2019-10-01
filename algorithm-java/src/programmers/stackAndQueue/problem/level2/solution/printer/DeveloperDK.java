package programmers.stackAndQueue.problem.level2.solution.printer;

import java.util.LinkedList;

// https://developerdk.tistory.com/15

/**
 * 
 * @author shkim
 * 
 * - ������ : ����
 *
 */
public class DeveloperDK {

	
	/**
	 * 
	 * @author shkim
	 * 
	 * Document Ŭ����
	 * 
	 *  - �߿䵵�� index�� �Բ� �������� ����̹Ƿ� ���� Document��� Ŭ������ �����Ͽ�
	 *    �־��� �迭�� ���� Document�� ��ȯ
	 *
	 */
	public class Document {
		
		int idx;
		int prioritie;
		
		public Document(int idx, int prioritie) {
			
			this.idx = idx;
			this.prioritie = prioritie;
			
		}
		
	}
	
	public int solution(int[] priorities, int location) {
		
		// LinkedList ����
		LinkedList<Document> list = new LinkedList<Document>();
		
		// Document�� ��ȯ�� ���� ���������� �־���
		for (int i=0; i < priorities.length; i++) {
			
			list.add(new Document(i, priorities[i]));
			
		}
		
		// �μ� ����
		int answer = 1;
		
		// ù ��° Document
		Document firstDc = null;
		
		// ����� ���������� üũ
		while (list.size() > 1) {
			
			// LinkedList�� ���� ó�� ���� firstDc�� ����
			firstDc = list.getFirst();
			
			for (int i=1; i < list.size(); i++) {
				
				// ���� ���� ���Ͽ� �߿䵵�� �� ���� ������ ������
				if (firstDc.prioritie < list.get(i).prioritie) {
					
					// ������� ���� ���������� ����
					list.addLast(firstDc);
					list.removeFirst();
					break;
					
				}
				
				// List�� ������(i=list.size()-1)�� �������������� �� �߿��� ������ ���ٸ�
				// �μ�
				if (i == list.size()-1) {
					
					// location�� ��ġ�ϴ� index�� ���� ������ �μ�� �� answer�� ���
					if (firstDc.idx == location) {
						return answer;
					}
					
					list.removeFirst();
					
					// �μⰡ �Ϸ�Ǹ� �μ������ �÷��ָ鼭 �� �������ݺ�
					answer++;
					
				}
				
			}
			
		}
		
		// list.size()�� 1�� ��� ������ �����̹Ƿ� �ٷ� answer�� ���
		return answer;
		
	}
	
}
