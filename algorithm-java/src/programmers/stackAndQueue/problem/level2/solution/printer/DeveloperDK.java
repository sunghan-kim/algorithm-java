package programmers.stackAndQueue.problem.level2.solution.printer;

import java.util.LinkedList;

// https://developerdk.tistory.com/15

/**
 * 
 * @author shkim
 * 
 * - 제출결과 : 성공
 *
 */
public class DeveloperDK {

	
	/**
	 * 
	 * @author shkim
	 * 
	 * Document 클래스
	 * 
	 *  - 중요도와 index가 함께 묶여야할 요소이므로 따로 Document라는 클래스를 정의하여
	 *    주어진 배열의 값을 Document로 변환
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
		
		// LinkedList 생성
		LinkedList<Document> list = new LinkedList<Document>();
		
		// Document로 변환한 값을 순차적으로 넣어줌
		for (int i=0; i < priorities.length; i++) {
			
			list.add(new Document(i, priorities[i]));
			
		}
		
		// 인쇄 순번
		int answer = 1;
		
		// 첫 번째 Document
		Document firstDc = null;
		
		// 대기목록 순차적으로 체크
		while (list.size() > 1) {
			
			// LinkedList의 가장 처음 값을 firstDc에 저장
			firstDc = list.getFirst();
			
			for (int i=1; i < list.size(); i++) {
				
				// 다음 값과 비교하여 중요도가 더 높은 문서가 있으면
				if (firstDc.prioritie < list.get(i).prioritie) {
					
					// 대기목록의 가장 마지막으로 보냄
					list.addLast(firstDc);
					list.removeFirst();
					break;
					
				}
				
				// List의 마지막(i=list.size()-1)에 도달했을떄까지 더 중요한 문서가 없다면
				// 인쇄
				if (i == list.size()-1) {
					
					// location과 일치하는 index를 가진 문서가 인쇄될 때 answer를 출력
					if (firstDc.idx == location) {
						return answer;
					}
					
					list.removeFirst();
					
					// 인쇄가 완료되면 인쇄순번을 올려주면서 위 과정을반복
					answer++;
					
				}
				
			}
			
		}
		
		// list.size()가 1일 경우 마지막 문서이므로 바로 answer를 출력
		return answer;
		
	}
	
}
