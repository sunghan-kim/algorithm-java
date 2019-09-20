package programmers.hash.problem.level1.solution.running;

import java.util.Arrays;
import java.util.HashMap;

import programmers.hash.problem.level1.Running;

// https://blog.naver.com/PostView.nhn?blogId=yongyos&logNo=221478544472&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView

/**
 * 
 * @author shkim
 * 
 * # �������� ���� ����
 * 
 * 
 * HMYK - ù ��° ���
 *
 */

public class HMYK {
	
	public String solution1(String[] participant, String[] completion) {
		
		// 1. �� �迭�� �������� ����
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		for (int i=0; i < completion.length; i++) {
			
			// 2. �� �迭�� ���� �������� �������� �� ���� ���� �����Ǿ� �־�� �Ѵ�.
			//    ���� ���� �ε����� ������ ��� ���� �ٸ��� �ش� ���� �������� ���� ������.
			if (!participant[i].equals(completion[i])) return participant[i];
			
		}
		
		return participant[participant.length-1];
		
	}
	
	
	public String solution2(String[] participant, String[] completion) {
		
		String notRunner = "";
		
		// 1. �����ڿ� �������� ���� �ڸ� �����ϱ� ���� �� ����
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		// 2. ������(participant) ��� �ʿ� �Է�
		//   - �̶� �������� �����ϱ� ���� getOrDefault �޼��� �̿�
		//   - �̷��� �ϸ� �������� �̸��� ���� ���� �� �ִ�.
		for (String runner : participant) map.put(runner, map.getOrDefault(runner, 0) + 1);
		
		// 3. ã���� �ϴ� �����ڰ� �ִٸ� �������� ���� -1 ���ش�.
		//    (�������� �������� �ֱ� ������ �̿� ���� ����)
		for (String runner : completion) map.put(runner, map.get(runner) - 1);
		
		for (String runner : map.keySet()) {
			
			// 4. ���������� ��� ���������� �������� ���� 0�� �Ǿ�� �Ѵ�.
			//   - ������ �������� ���ߴٸ� 0�� ���� �ʴ´�.
			//   - �׷��Ƿ� 0�� �ƴ� ���� �������� ���� �����̴�.
			if (map.get(runner) != 0) {
				notRunner = runner;
				break;
			}
			
		}
		
		return notRunner;
		
	}
	
}
