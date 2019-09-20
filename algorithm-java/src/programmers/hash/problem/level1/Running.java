package programmers.hash.problem.level1;

import java.util.HashMap;
import java.util.Scanner;

import programmers.hash.problem.level1.solution.running.HMYK;

/**
 * 
 * @author shkim
 * 
 * ##### 완주하지 못한 선수 #####
 * 
 * 
 * # 문제 설명
 * 
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 
 * 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 
 * 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * # 제한사항
 * 
 * - 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * - completion의 길이는 participant의 길이보다 1 작습니다.
 * - 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * - 참가자 중에는 동명이인이 있을 수 있습니다.
 *
 */

public class Running {

	/**
	 * 
	 * # solution
	 * 
	 *   - HashMap 이용
	 * 
	 * @param participant
	 * @param completion
	 * @return answer
	 * 
	 * 제출 결과 : 성공
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
		
		if (show.equals("default")) { // 프로그래머스 최빈 정답
		
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
