package programmers.sort.problem.level2;

// https://programmers.co.kr/learn/courses/30/lessons/42747

/**
* 
* @author shkim
* 
* ##### H-Index #####
* 
* # ���� ����
* 
* H-Index�� �������� ���꼺�� ������� ��Ÿ���� ��ǥ�Դϴ�. 
* ��� �������� H-Index�� ��Ÿ���� ���� h�� ���Ϸ��� �մϴ�. 
* ��Ű���1�� ������, H-Index�� ������ ���� ���մϴ�.
* 
* � �����ڰ� ��ǥ�� �� n�� ��, 
* h�� �̻� �ο�� ���� h�� �̻��̰� ������ ���� h�� ���� �ο�Ǿ��ٸ� 
* h�� �� �������� H-Index�Դϴ�.
* 
* � �����ڰ� ��ǥ�� ���� �ο� Ƚ���� ���� �迭 citations�� �Ű������� �־��� ��, 
* �� �������� H-Index�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
* 
* 
* # ���� ����
* 
* - �����ڰ� ��ǥ�� ���� ���� 1�� �̻� 1,000�� �����Դϴ�.
* - ���� �ο� Ƚ���� 0ȸ �̻� 10,000ȸ �����Դϴ�.
* 
* 
* # ����� ��
* 
* (����1)
* 
*   - citations : [3, 0, 6, 1, 5]
*   
*   - return : 3
*   
*   
* # ����� �� ����
* 
* �� �����ڰ� ��ǥ�� ���� ���� 5���̰�, ���� 3���� ���� 3ȸ �̻� �ο�Ǿ����ϴ�. 
* �׸��� ������ 2���� ���� 3ȸ ���� �ο�Ǿ��� ������ �� �������� H-Index�� 3�Դϴ�.
*   
*/

public class HIndex {

	private int n;
	private int h;
	
	public int solution(int[] citations) {
        int answer = 0;
        
        n = citations.length;
        
        h = n/2;
        
        findH(citations, n, h);
        
        answer = h;
        
        return answer;
    }
	
	public void findH(int[] arr, int n, int h) {
		
		int bigger = 0;
		int smaller = 0;
		
		for (int i=0; i < n; i++) {
			
			if (arr[i] >= h) bigger++;
			
		}
		
		System.out.println("bigger : " + bigger);
		
		if (bigger > h) {
			findH(arr, n, h-1);
		} else if (bigger < h) {
			findH(arr, n, h+1);
		} else {
			
			return;
			
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] citations = {3, 0, 6, 1, 5};
		
		int answer = 0;
		
		String show = "default"; // default
		
		if (show.equals("default")) {
			
			HIndex hidx = new HIndex();
			
			answer = hidx.solution(citations);
			
		}
		
		System.out.println("answer : " + answer);
		
	}
	
}
