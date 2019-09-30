package programmers.stackAndQueue.problem.level2.solution.printer;

import java.util.ArrayList;
import java.util.List;

// https://m.blog.naver.com/PostView.nhn?blogId=yongyos&logNo=221562721494&categoryNo=39&proxyReferer=https%3A%2F%2Fwww.google.com%2F

/**
 * 
 * @author shkim
 * 
 * - ������ : ����
 *
 */
public class HMYK {

	public int solution(int[] priorities, int location) {
		
		/*
		 * 
		 * 1. 
		 * 
		 *  - ������ ����� ������ list ����
		 *  - �Է��� �迭�� list�� ������� ��´�.
		 *  - �켱������ ���� ����� ������ �ٲ�� �Ǹ�
		 *    ���� ���ϴ� ��¹��� ������ �ٲ��.
		 *  - �ٲ�� ������ ���� �ε����� ������ ���� loc�� �����Ѵ�.
		 *  - ���� �� ��¹��� �� ��°�� ��µƴ� ���� ��Ÿ�� ���� cnt
		 * 
		 */
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i : priorities) list.add(i);
		
		int loc = location, cnt = 0;
		
		// 2. list�� ��Ұ� ������� �� ���� �ݺ�
		while (!list.isEmpty()) {
			
			// 3. �� �տ� �ִ� ��¹��� ���� ���� �켱�������� Ȯ���ϱ� ���� max_priority
			//    (boolean���� �ص� ��� ���� ��)
			int max_priority = list.get(0);
			
			for (int i=1; i < list.size(); i++) {
				
				// 4. ���� �� �տ� �ִ� ��¹����� ���� �켱������ ������ �ִ� ��¹��� ���� ���
				//    ��¹��� ��ġ ������ �ʿ��ϴ�.
				//    ���� �� �տ� ��ġ�� ��¹��� ���� ���ϴ� ��¹��̶��
				//    loc�� �� ������ �ε�����,
				//    �װ� �ƴ϶�� loc�� �ε��� ��ȣ�� 1 �����.
				if (list.get(0) < list.get(i)) {
					if (loc == 0) {
						loc = list.size() - 1;
					} else {
						loc--;
					}
					
					// 5. �� �տ� ��ġ�� ��¹����� �켱������ ���� ��¹��� �����Ƿ�
					//    �� �տ� ��ġ�� ��¹��� �� �ڷ� ����� ����
					//    ���� ������ max_prioritiy�� 0���� ����
					int tmp_priority = list.get(0);
					list.remove(0);
					list.add(tmp_priority);
					max_priority = 0;
					break;
				}
				
			}
			
			// 6. ���� ���� ���� �켱������ ��¹��� �� �տ� �ִٸ� max_priority�� 0�� �ƴ� ���̴�.
			//    �̶� ��¹��� ���(����Ʈ���� ����)�ϰ� cnt�� 1 ������Ų��.
			//    ���� ����� ��¹��� ���� ã�� ��¹��̶�� �ݺ����� �����Ѵ�.
			if (max_priority != 0) {
				
				list.remove(0);
				cnt++;
				if (loc == 0) {
					break;
				} else {
					loc--;
				}
				
			}
			
		}
		
		return cnt;
		
	}
	
}
