package programmers.stackAndQueue.problem.level2.solution.truck;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://developerdk.tistory.com/16



public class DeveloperDK {

	// Truck 클래스 생성
	//  - weight : 트럭 무게
	//  - distance : 남은 이동거리
	public class Truck {
		
		int weight;
		int distance;
		
		public Truck(int weight, int distance) {
			
			this.weight = weight;
			this.distance = distance;
			
		}
		
	}
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		
		// time : 시간
		int time = 0;
		
		// weightLeft : 남은 견딜 수 있는 무게
		int weightLeft = weight;
		
		// Truck을 담을 임시 변수
		Truck truck = null;
		
		// outside : 다리 밖 대기중인 트럭
		Queue<Truck> outside = new LinkedList<Truck>();
		
		// inside : 다리 위 트럭
		//  - inside는 순차적으로 남은 거리를 for문을 돌며 감소시켜줘야 하기 때문에
		//    ArrayList를 사용
		List<Truck> inside = new ArrayList<Truck>();
		
		for (int t : truck_weights) {
			
			outside.add(new Truck(t, bridge_length));
			
		}
		
		while (!(inside.isEmpty() && outside.isEmpty())) { // 다리 위 트럭이 비어있을때까지 반복
			
			time++;
			
			// 다리 위 트럭(inside)이 distance 이상 지나갔으면
			// inside에서 제거해주고, 남은 무게도 증가시켜줌
			if (!inside.isEmpty() && inside.get(0).distance <= 0) {
				
				weightLeft += inside.get(0).weight;
				inside.remove(0);
				
			}
			
			// 남은 무게보다 가벼운 트럭이 있다면 inside로 넣어줌
			if (!outside.isEmpty() && weightLeft - outside.peek().weight >= 0) {
				
				weightLeft -= outside.peek().weight;
				inside.add(outside.poll());
				
			}
			
			// 다리 위 트럭(inside)의 distance를 1씩 감소
			for (int i=0; i < inside.size(); i++) {
				truck = inside.get(i);
				truck.distance--;
			}
			
		}
		
		return time;
		
	}
	
}
