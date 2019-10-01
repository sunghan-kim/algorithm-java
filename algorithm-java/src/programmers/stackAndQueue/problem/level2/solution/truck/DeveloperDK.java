package programmers.stackAndQueue.problem.level2.solution.truck;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://developerdk.tistory.com/16



public class DeveloperDK {

	// Truck Ŭ���� ����
	//  - weight : Ʈ�� ����
	//  - distance : ���� �̵��Ÿ�
	public class Truck {
		
		int weight;
		int distance;
		
		public Truck(int weight, int distance) {
			
			this.weight = weight;
			this.distance = distance;
			
		}
		
	}
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		
		// time : �ð�
		int time = 0;
		
		// weightLeft : ���� �ߵ� �� �ִ� ����
		int weightLeft = weight;
		
		// Truck�� ���� �ӽ� ����
		Truck truck = null;
		
		// outside : �ٸ� �� ������� Ʈ��
		Queue<Truck> outside = new LinkedList<Truck>();
		
		// inside : �ٸ� �� Ʈ��
		//  - inside�� ���������� ���� �Ÿ��� for���� ���� ���ҽ������ �ϱ� ������
		//    ArrayList�� ���
		List<Truck> inside = new ArrayList<Truck>();
		
		for (int t : truck_weights) {
			
			outside.add(new Truck(t, bridge_length));
			
		}
		
		while (!(inside.isEmpty() && outside.isEmpty())) { // �ٸ� �� Ʈ���� ������������� �ݺ�
			
			time++;
			
			// �ٸ� �� Ʈ��(inside)�� distance �̻� ����������
			// inside���� �������ְ�, ���� ���Ե� ����������
			if (!inside.isEmpty() && inside.get(0).distance <= 0) {
				
				weightLeft += inside.get(0).weight;
				inside.remove(0);
				
			}
			
			// ���� ���Ժ��� ������ Ʈ���� �ִٸ� inside�� �־���
			if (!outside.isEmpty() && weightLeft - outside.peek().weight >= 0) {
				
				weightLeft -= outside.peek().weight;
				inside.add(outside.poll());
				
			}
			
			// �ٸ� �� Ʈ��(inside)�� distance�� 1�� ����
			for (int i=0; i < inside.size(); i++) {
				truck = inside.get(i);
				truck.distance--;
			}
			
		}
		
		return time;
		
	}
	
}
