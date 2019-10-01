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
* ##### 다리를 지나가는 트럭 #####
* 
* 
* # 문제 설명
* 
* 트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 
* 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 
* 트럭은 1초에 1만큼 움직이며, 
* 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
* 
* ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
* 
* 예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 
* 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
* 
*   경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
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
* 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
* 
* 
* solution 함수의 매개변수
* 
*  - 다리 길이 : bridgelength
*  - 다리가 견딜 수 있는 무게 : weight
*  - 트럭별 무게 : truckweights
*  
* 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
*       
* 
* # 제한 사항
* 
*  - bridge_length는 1 이상 10,000 이하입니다.
*  - weight는 1 이상 10,000 이하입니다.
*  - truck_weights의 길이는 1 이상 10,000 이하입니다.
*  - 모든 트럭의 무게는 1 이상 weight 이하입니다.
*  
* 
* # 입출력 예
* 
* (예시1)
* 
*   - bridge_length : 2
*   - weight 		: 10
*   - truck_weights : [7,4,5,6]
*   
*   - return : 	8
*   
*   
* (예시1)
* 
*   - bridge_length : 100
*   - weight 		: 100
*   - truck_weights : [10]
*   
*   - return : 101
*   
*   
* (예시1)
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
        	
        	if (!crossing.isEmpty()) { // 건너고 있는 트럭이 있다면
        		
        		// 건너고 있는 트럭 중 맨 앞에 있는 트럭의 다리위에 있었던 시간 체크
        		// 다리위에 있었던 시간이 bridge_length와 같으면 Crossed로 이동
        		
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
