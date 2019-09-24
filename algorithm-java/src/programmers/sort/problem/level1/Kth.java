package programmers.sort.problem.level1;

import java.util.Arrays;

import programmers.sort.problem.level1.solution.kth.Programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42748

/**
* 
* @author shkim
* 
* ##### K��°�� #####
* 
* # ���� ����
* 
* �迭 array�� i��° ���ں��� j��° ���ڱ��� �ڸ��� �������� ��, 
* k��°�� �ִ� ���� ���Ϸ� �մϴ�.
* 
* ���� ��� array�� [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3�̶��
* 
*   1. array�� 2��°���� 5��°���� �ڸ��� [5, 2, 6, 3]�Դϴ�.
*   2. 1���� ���� �迭�� �����ϸ� [2, 3, 5, 6]�Դϴ�.
*   3. 2���� ���� �迭�� 3��° ���ڴ� 5�Դϴ�.
*   
* �迭 array, [i, j, k]�� ���ҷ� ���� 2���� �迭 commands�� �Ű������� �־��� ��, 
* commands�� ��� ���ҿ� ���� �ռ� ������ ������ �������� �� ���� ����� �迭�� ��� 
* return �ϵ��� solution �Լ��� �ۼ����ּ���.
* 
* 
* # ���� ����
* 
* - array�� ���̴� 1 �̻� 100 �����Դϴ�.
* - array�� �� ���Ҵ� 1 �̻� 100 �����Դϴ�.
* - commands�� ���̴� 1 �̻� 50 �����Դϴ�.
* - commands�� �� ���Ҵ� ���̰� 3�Դϴ�.
* 
* 
* # ����� ��
* 
* (����1)
* 
*   - array : [1, 5, 2, 6, 3, 7, 4]
*   - commands  : [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
*   
*   - return : [5, 6, 3]
*   
*   - [1, 5, 2, 6, 3, 7, 4]�� 2��°���� 5��°���� �ڸ� �� �����մϴ�. 
*     [2, 3, 5, 6]�� �� ��° ���ڴ� 5�Դϴ�.
*     
*   - [1, 5, 2, 6, 3, 7, 4]�� 4��°���� 4��°���� �ڸ� �� �����մϴ�. 
*     [6]�� ù ��° ���ڴ� 6�Դϴ�.
*     
*   - [1, 5, 2, 6, 3, 7, 4]�� 1��°���� 7��°���� �ڸ��ϴ�. 
*     [1, 2, 3, 4, 5, 6, 7]�� �� ��° ���ڴ� 3�Դϴ�.
*   
*/

public class Kth {

	public int[] solution(int[] array, int[][] commands) {
		
		// commands�� ������ŭ�� answer �迭 �ʱ�ȭ
        int[] answer = new int[commands.length];
        
        for (int i=0; i < commands.length; i++) {
        	
        	// ������ command ���� �Ҵ�
        	int[] cmd = commands[i];
        	
        	// �߶� ũ�� ��ŭ�� �ڸ� �迭 �ʱ�ȭ
        	int[] subArr = new int[cmd[1] - cmd[0] + 1];
        	
        	for (int j=cmd[0]-1; j < cmd[1]; j++) {
        		
        		subArr[j-cmd[0]+1] = array[j];
        		
        	}
        	
        	// �ڸ� �迭 ����
        	Arrays.sort(subArr);
        	
        	answer[i] = subArr[cmd[2]-1];
        	
        }
        
        return answer;
        
    }
	
	public static void main(String[] args) {
		
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] answer = null;
		
		String show = "pgrs_01"; // default, pgrs_01, pgrs_02
		
		if (show.equals("default")) {
			
			Kth kth = new Kth();
			
			answer = kth.solution(array, commands);
			
		} else if (show.equals("pgrs_01")) {
			
			Programmers pgrs = new Programmers();
			
			answer = pgrs.solution1(array, commands);
			
		} else if (show.equals("pgrs_02")) {
			
			Programmers pgrs = new Programmers();
			
			answer = pgrs.solution2(array, commands);
			
		}
			
		System.out.println(Arrays.toString(answer));
		
	}
	
}
