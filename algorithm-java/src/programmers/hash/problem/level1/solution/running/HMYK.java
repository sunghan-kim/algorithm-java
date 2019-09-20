package programmers.hash.problem.level1.solution.running;

import java.util.Arrays;
import java.util.HashMap;

import programmers.hash.problem.level1.Running;

// https://blog.naver.com/PostView.nhn?blogId=yongyos&logNo=221478544472&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView

/**
 * 
 * @author shkim
 * 
 * # 완주하지 못한 선수
 * 
 * 
 * HMYK - 첫 번째 방법
 *
 */

public class HMYK {
	
	public String solution1(String[] participant, String[] completion) {
		
		// 1. 두 배열을 오름차순 정렬
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		for (int i=0; i < completion.length; i++) {
			
			// 2. 두 배열을 오름 차순으로 정렬했을 때 같은 값이 나열되어 있어야 한다.
			//    만약 같은 인덱스를 비교했을 경우 값이 다르면 해당 값은 완주하지 못한 선수다.
			if (!participant[i].equals(completion[i])) return participant[i];
			
		}
		
		return participant[participant.length-1];
		
	}
	
	
	public String solution2(String[] participant, String[] completion) {
		
		String notRunner = "";
		
		// 1. 완주자와 완주하지 못한 자를 구분하기 위한 맵 선언
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		// 2. 참가자(participant) 모두 맵에 입력
		//   - 이때 동명인을 구분하기 위해 getOrDefault 메서드 이용
		//   - 이렇게 하면 참가자의 이름과 수를 구할 수 있다.
		for (String runner : participant) map.put(runner, map.getOrDefault(runner, 0) + 1);
		
		// 3. 찾고자 하는 참가자가 있다면 참가자의 수를 -1 해준다.
		//    (동명인이 있을수도 있기 때문에 이와 같이 구현)
		for (String runner : completion) map.put(runner, map.get(runner) - 1);
		
		for (String runner : map.keySet()) {
			
			// 4. 정상적으로 모두 완주했으면 참가자의 수는 0이 되어야 한다.
			//   - 하지만 완주하지 못했다면 0이 되지 않는다.
			//   - 그러므로 0이 아닌 값은 완주하지 못한 선수이다.
			if (map.get(runner) != 0) {
				notRunner = runner;
				break;
			}
			
		}
		
		return notRunner;
		
	}
	
}
