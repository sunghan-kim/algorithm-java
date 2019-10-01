package programmers.stackAndQueue.problem.level2.solution.truck;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/42583/solution_groups?language=java

/**
 * 
 * @author shkim
 * 
 * # ���α׷��ӽ� - �ٸ� ����� Ǯ��
 *
 */

public class Programmers {

	/**
	 * 
	 * solution1
	 * 
	 *  - HamYoungChan , Ż���� ����� , franhoon
	 * 
	 *  - Queue�� LinkedList ���
	 * 
	 *  - ������ : ����
	 *  
	 */
	class Truck {
		
		int weight;
		int move;
		
		public Truck(int weight) {
			this.weight = weight;
			this.move = 1;
		}
		
		public void moving() {
			move++;
		}
		
	}
	
	public int solution1(int bridge_length, int weight, int[] truck_weights) {
		
		Queue<Truck> waitQ = new LinkedList<>();
		Queue<Truck> moveQ = new LinkedList<>();
		
		for (int t : truck_weights) {
			
			waitQ.offer(new Truck(t)); // offer() : waitQ�� �� �ڿ� ����
			
		}
		
		int answer = 0;
		int curWeight = 0;
		
		while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
			
			answer++;
			
			if (moveQ.isEmpty()) {
				
				Truck t = waitQ.poll(); // poll() : waitQ���� �� ���� ��� ���� �� ����
				curWeight += t.weight;
				moveQ.offer(t);
				continue;
				
			}
			
			for (Truck t : moveQ) {
				
				t.moving();
				
			}
			
			if (moveQ.peek().move > bridge_length) {
				
				Truck t = moveQ.poll();
				curWeight -= t.weight;
				
			}
			
			if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
				
				Truck t = waitQ.poll();
				curWeight += t.weight;
				moveQ.offer(t);
				
			}
			
		}
		
		return answer;
		
	}
	
	/**
	 * 
	 * solution2
	 * 
	 *  - - , ��ȯ , ������ , Leenamgyo , �輼�� �� 2 ��
	 *  - Stack�� Map ���
	 *  
	 *  - ���� ��� : 
	 * 
	 */
	public int solution2(int bridge_length, int weight, int[] truck_weights) {
		 
		Stack<Integer> truckStack = new Stack<>();
		Map<Integer, Integer> bridgeMap = new HashMap<>();
		
		for (int i=truck_weights.length-1; i >= 0; i--) {
			
			truckStack.push(truck_weights[i]);
			
		}
		
		int answer = 0;
		int sum = 0;
		
		while(true) {
			
			answer++;
			
			if (bridgeMap.containsKey(answer)) {
				bridgeMap.remove(answer);
			}
			
			sum = bridgeMap.values().stream().mapToInt(Number::intValue).sum();
			
			if (!truckStack.isEmpty()) {
				
				if (sum + truckStack.peek() <= weight) {
					bridgeMap.put(answer+bridge_length, truckStack.pop());
				}
				
			}
			
			if (bridgeMap.isEmpty() && truckStack.isEmpty()) {
				break;
			}
			
		}
		
		return answer;
		
	}
}
