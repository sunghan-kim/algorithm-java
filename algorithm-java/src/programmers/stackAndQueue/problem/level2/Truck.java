package programmers.stackAndQueue.problem.level2;

import java.util.HashMap;
import java.util.LinkedList;

import programmers.stackAndQueue.problem.level2.solution.truck.DeveloperDK;
import programmers.stackAndQueue.problem.level2.solution.truck.Programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42583

/**
* 
* @author shkim
* 
* ##### �ٸ��� �������� Ʈ�� #####
* 
* 
* # ���� ����
* 
* Ʈ�� ���� �밡 ���� ���������� �� ���� �ٸ��� ������ ������ �ǳʷ� �մϴ�. 
* ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� �˾Ƴ��� �մϴ�. 
* Ʈ���� 1�ʿ� 1��ŭ �����̸�, 
* �ٸ� ���̴� bridge_length�̰� �ٸ��� ���� weight���� �ߵ��ϴ�.
* 
* �� Ʈ���� �ٸ��� ������ ������ ���� ���, �� Ʈ���� ���Դ� ������� �ʽ��ϴ�.
* 
* ���� ���, ���̰� 2�̰� 10kg ���Ը� �ߵ�� �ٸ��� �ֽ��ϴ�. 
* ���԰� [7, 4, 5, 6]kg�� Ʈ���� ������� �ִ� �ð� �ȿ� �ٸ��� �ǳʷ��� ������ ���� �ǳʾ� �մϴ�.
* 
*   ��� �ð�	�ٸ��� ���� Ʈ��	�ٸ��� �ǳʴ� Ʈ��	��� Ʈ��
*   0			[]					[]					[7,4,5,6]
*   1			[]					[7]					[4,5,6]
*   2			[]					[7]					[4,5,6]
*   3			[7]					[4]					[5,6]
*   4			[7]					[4,5]				[6]
*   5			[7,4]				[5]					[6]
*   6			[7,4,5]				[6]					[]
*   7			[7,4,5]				[6]					[]
*   8			[7,4,5,6]			[]					[]			
*   
* ����, ��� Ʈ���� �ٸ��� �������� �ּ� 8�ʰ� �ɸ��ϴ�.
* 
* 
* solution �Լ��� �Ű�����
* 
*  - �ٸ� ���� : bridgelength
*  - �ٸ��� �ߵ� �� �ִ� ���� : weight
*  - Ʈ���� ���� : truckweights
*  
* �̶� ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
*       
* 
* # ���� ����
* 
*  - bridge_length�� 1 �̻� 10,000 �����Դϴ�.
*  - weight�� 1 �̻� 10,000 �����Դϴ�.
*  - truck_weights�� ���̴� 1 �̻� 10,000 �����Դϴ�.
*  - ��� Ʈ���� ���Դ� 1 �̻� weight �����Դϴ�.
*  
* 
* # ����� ��
* 
* (����1)
* 
*   - bridge_length : 2
*   - weight 		: 10
*   - truck_weights : [7,4,5,6]
*   
*   - return : 	8
*   
*   
* (����1)
* 
*   - bridge_length : 100
*   - weight 		: 100
*   - truck_weights : [10]
*   
*   - return : 101
*   
*   
* (����1)
* 
*   - bridge_length : 100
*   - weight 		: 100
*   - truck_weights : [10,10,10,10,10,10,10,10,10,10]
*   
*   - return : 110
*   
*/

public class Truck {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        LinkedList<Integer> willCross = new LinkedList<Integer>();
        LinkedList<Integer> crossing = new LinkedList<Integer>();
        LinkedList<Integer> crossed = new LinkedList<Integer>();
        LinkedList<Integer> stayTime = new LinkedList<Integer>();
        
        
        for (int i : truck_weights) {
        	
        	willCross.add(i);
        	stayTime.add(0);
        	
        }
        
        System.out.println(willCross);
        System.out.println(stayTime);
        
        while (crossed.size() != truck_weights.length) {
        	
        	answer++;
        	
        	if (!crossing.isEmpty()) { // �ǳʰ� �ִ� Ʈ���� �ִٸ�
        		
        		// �ǳʰ� �ִ� Ʈ�� �� �� �տ� �ִ� Ʈ���� �ٸ����� �־��� �ð� üũ
        		// �ٸ����� �־��� �ð��� bridge_length�� ������ Crossed�� �̵�
        		
        	}
        	
        	System.out.println(answer);
        	
        	if (answer == 10) {
        		break;
        	}
        	
        }
        
        
        
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int bridge_length1 = 2;
		int weight1 = 10;
		int[] truck_weights1 = {7,4,5,6};
		
		int answer1 = 0;
		
		int bridge_length2 = 100;
		int weight2 = 100;
		int[] truck_weights2 = {10};
		
		int answer2 = 0;
		
		int bridge_length3 = 100;
		int weight3 = 100;
		int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};
		
		int answer3 = 0;
		
		String show = "pg02"; // default, dk, pg01, pg02
		
		if (show.equals("default")) {
			
			Truck tk = new Truck();
			
			answer1 = tk.solution(bridge_length1, weight1, truck_weights1);
			answer2 = tk.solution(bridge_length2, weight2, truck_weights2);
			answer3 = tk.solution(bridge_length3, weight3, truck_weights3);
			
		} else if (show.equals("dk")) {
			
			DeveloperDK dk = new DeveloperDK();
			
			answer1 = dk.solution(bridge_length1, weight1, truck_weights1);
			answer2 = dk.solution(bridge_length2, weight2, truck_weights2);
			answer3 = dk.solution(bridge_length3, weight3, truck_weights3);
			
		} else if (show.equals("pg01")) {
			
			Programmers pg01 = new Programmers();
			
			answer1 = pg01.solution1(bridge_length1, weight1, truck_weights1);
			answer2 = pg01.solution1(bridge_length2, weight2, truck_weights2);
			answer3 = pg01.solution1(bridge_length3, weight3, truck_weights3);
			
		} else if (show.equals("pg02")) {
			
			Programmers pg02 = new Programmers();
			
			answer1 = pg02.solution2(bridge_length1, weight1, truck_weights1);
			answer2 = pg02.solution2(bridge_length2, weight2, truck_weights2);
			answer3 = pg02.solution2(bridge_length3, weight3, truck_weights3);
			
		}
		
		System.out.println("answer1 : " + answer1); // 8
		System.out.println("answer2 : " + answer2); // 101
		System.out.println("answer3 : " + answer3); // 110
		
	}
	
}
