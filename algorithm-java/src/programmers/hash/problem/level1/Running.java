package programmers.hash.problem.level1;

import java.util.HashMap;
import java.util.Scanner;

import programmers.hash.problem.level1.solution.running.HMYK;

/**
 * 
 * @author shkim
 * 
 * ##### �������� ���� ���� #####
 * 
 * 
 * # ���� ����
 * 
 * ������ ������ �������� �����濡 �����Ͽ����ϴ�. 
 * �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.
 * �����濡 ������ �������� �̸��� ��� �迭 participant�� 
 * ������ �������� �̸��� ��� �迭 completion�� �־��� ��, 
 * �������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 *
 * # ���ѻ���
 * 
 * - ������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�.
 * - completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�.
 * - �������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
 * - ������ �߿��� ���������� ���� �� �ֽ��ϴ�.
 *
 */

public class Running {

	/**
	 * 
	 * # solution
	 * 
	 *   - HashMap �̿�
	 * 
	 * @param participant
	 * @param completion
	 * @return answer
	 * 
	 * ���� ��� : ����
	 * 
	 */
	public String solution(String[] participant, String[] completion) {
		
		String answer = "";
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
		for (String player : completion) hm.put(player, hm.get(player) - 1);
		
		for (String key : hm.keySet()) {
			if (hm.get(key) != 0) {
				answer = key;	
			}
		}
		
		return answer;
		
	}

	public static void main(String[] args) {
		
		String[] participant1 = {"leo", "kiki", "eden"};
		String[] completion1 = {"eden", "kiki"};
		
		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
		
		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
		String[] completion3 = {"stanko", "ana", "mislav"};
		
		String show;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Choose solution : ");
		
		show = scan.nextLine();
		
		String answer1 = "";
		String answer2 = "";
		String answer3 = "";
		
		System.out.println("-------------------------");
		
		if (show.equals("default")) { // ���α׷��ӽ� �ֺ� ����
		
			Running run = new Running();
			
			answer1 = run.solution(participant1, completion1);
			answer2 = run.solution(participant2, completion2);
			answer3 = run.solution(participant3, completion3);
			
		} else if (show.equals("HMYK_01")) {
			
			HMYK hmyk = new HMYK();
			
			answer1 = hmyk.solution1(participant1, completion1);
			answer2 = hmyk.solution1(participant2, completion2);
			answer3 = hmyk.solution1(participant3, completion3);
			
		} else if (show.equals("HYMK_02")) {
			
			HMYK hmyk = new HMYK();
			
			answer1 = hmyk.solution2(participant1, completion1);
			answer2 = hmyk.solution2(participant2, completion2);
			answer3 = hmyk.solution2(participant3, completion3);
			
		}
		
		System.out.println(answer1); // leo
		System.out.println(answer2); // vinko
		System.out.println(answer3); // mislav
		
	}
	
}
