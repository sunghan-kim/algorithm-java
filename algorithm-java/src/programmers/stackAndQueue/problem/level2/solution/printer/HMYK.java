package programmers.stackAndQueue.problem.level2.solution.printer;

import java.util.ArrayList;
import java.util.List;

// https://m.blog.naver.com/PostView.nhn?blogId=yongyos&logNo=221562721494&categoryNo=39&proxyReferer=https%3A%2F%2Fwww.google.com%2F

/**
 * 
 * @author shkim
 * 
 * - 제출결과 : 성공
 *
 */
public class HMYK {

	public int solution(int[] priorities, int location) {
		
		/*
		 * 
		 * 1. 
		 * 
		 *  - 프린터 출력을 도와줄 list 생성
		 *  - 입력한 배열을 list에 순서대로 담는다.
		 *  - 우선순위에 따라 출력할 순서가 바뀌게 되면
		 *    내가 원하는 출력물의 순서도 바뀐다.
		 *  - 바뀌는 순서에 따라 인덱스를 저장할 변수 loc를 선언한다.
		 *  - 실제 내 출력물이 몇 번째에 출력됐는 지를 나타낼 변수 cnt
		 * 
		 */
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i : priorities) list.add(i);
		
		int loc = location, cnt = 0;
		
		// 2. list의 요소가 비어있을 때 까지 반복
		while (!list.isEmpty()) {
			
			// 3. 맨 앞에 있는 출력물이 가장 높은 우선순위인지 확인하기 위한 max_priority
			//    (boolean으로 해도 상관 없을 듯)
			int max_priority = list.get(0);
			
			for (int i=1; i < list.size(); i++) {
				
				// 4. 만약 맨 앞에 있는 출력물보다 높은 우선순위를 가지고 있는 출력물이 있을 경우
				//    출력물의 위치 조정이 필요하다.
				//    만약 맨 앞에 위치한 출력물이 내가 원하는 출력물이라면
				//    loc를 맨 마지막 인덱스로,
				//    그게 아니라면 loc의 인덱스 번호를 1 낮춘다.
				if (list.get(0) < list.get(i)) {
					if (loc == 0) {
						loc = list.size() - 1;
					} else {
						loc--;
					}
					
					// 5. 맨 앞에 위치한 출력물보다 우선순위가 높은 출력물이 있으므로
					//    맨 앞에 위치한 출력물을 맨 뒤로 옯기는 과정
					//    같은 이유로 max_prioritiy도 0으로 수정
					int tmp_priority = list.get(0);
					list.remove(0);
					list.add(tmp_priority);
					max_priority = 0;
					break;
				}
				
			}
			
			// 6. 만약 가장 높은 우선순위의 출력물이 맨 앞에 있다면 max_priority는 0이 아닐 것이다.
			//    이때 출력물을 출력(리스트에서 삭제)하고 cnt를 1 증가시킨다.
			//    만약 출력한 출력물이 내가 찾는 출력물이라면 반복문을 종료한다.
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
