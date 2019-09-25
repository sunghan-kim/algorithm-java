package programmers.sort.usage.numberOfCases.permutation;

import java.util.ArrayList;
import java.util.Arrays;

// https://redscreen.tistory.com/168

/**
 * 
 * @author shkim
 * 
 * # ���� (Permutation)
 * 
 * 1. n�� �߿��� r���� �����Ѵ�.
 * 
 *   - ������ n������ r���� �����ϴ� �˰���
 *   
 *   - ������ �з� (2����)
 *   
 *     - �ߺ��� ������� �ʰ� n�� �߿� r�� �̱� (����)
 *     - �ߺ��� ����ϰ� n�� �߿� r�� �̱� (�ߺ�����) 
 *     
 *     
 * 2. ����Լ� + ArrayList�� �̿��� ����
 * 
 *   - ������ ��ȭ��
 *   
 *     : 0 <= r >= n�� �����ϴ� ���� n, r�� ���� ��, ������ ����Ͽ� r���� ���Ҹ� ����
 *     
 *     P(n, r) = n(n-1)(n-2)...(n-r+1)
 *             = n! / (n-r)!
 *             
 *             
 *   - Ȯ��
 *   
 *     - P(5, 3) = 5 x 4 x 3
 *     
 *     - P(5, 3) = 5���� ������ �� 1�� ���� x 4���� ������ �� 1�� ���� x 3���� ������ �� 1�� ����
 *     
 *     - P(5, 3) = [1,2,3,4,5] �߿��� '1' ���� x [2,3,4,5] �߿��� '2' ���� x [3,4,5] �߿��� '3' ���� => 123
 *     			   [1,2,3,4,5] �߿��� '1' ���� x [2,3,4,5] �߿��� '2' ���� x [3,4,5] �߿��� '4' ���� => 124
 *     			   [1,2,3,4,5] �߿��� '1' ���� x [2,3,4,5] �߿��� '2' ���� x [3,4,5] �߿��� '5' ���� => 125
 *     
 *     			   [1,2,3,4,5] �߿��� '1' ���� x [2,3,4,5] �߿��� '3' ���� x [2,4,5] �߿��� '2' ���� => 132
 *     			   [1,2,3,4,5] �߿��� '1' ���� x [2,3,4,5] �߿��� '3' ���� x [2,4,5] �߿��� '4' ���� => 134
 *     			   [1,2,3,4,5] �߿��� '1' ���� x [2,3,4,5] �߿��� '3' ���� x [2,4,5] �߿��� '5' ���� => 135
 *          
 *     			   [1,2,3,4,5] �߿��� '1' ���� x [2,3,4,5] �߿��� '4' ���� x [2,3,5] �߿��� '2' ���� => 142
 *     			   [1,2,3,4,5] �߿��� '1' ���� x [2,3,4,5] �߿��� '4' ���� x [2,3,5] �߿��� '3' ���� => 143
 *     			   [1,2,3,4,5] �߿��� '1' ���� x [2,3,4,5] �߿��� '4' ���� x [2,3,5] �߿��� '5' ���� => 145
 *     
 *     			   [1,2,3,4,5] �߿��� '1' ���� x [2,3,4,5] �߿��� '5' ���� x [2,3,4] �߿��� '2' ���� => 152
 *     			   [1,2,3,4,5] �߿��� '1' ���� x [2,3,4,5] �߿��� '5' ���� x [2,3,4] �߿��� '3' ���� => 153
 *     			   [1,2,3,4,5] �߿��� '1' ���� x [2,3,4,5] �߿��� '5' ���� x [2,3,4] �߿��� '4' ���� => 154
 *     
 *                 [1,2,3,4,5] �߿��� '2' ���� x [1,3,4,5] �߿��� '1' ���� x [3,4,5] �߿��� '3' ���� => 213
 *                 
 *                 ...                         x ...                       x ...
 *                 
 *                 (��� ����� ���� ���� ������ �ݺ�)
 *               
 *     - ���õ� �������� �ٷ� ����ϰų�, ��� �������� fix�� ���Ŀ� ����ص� ��
 *       (Ȯ���̶� �����ص� ����)
 *       
 *     - ���� �ݺ����� ������ ���δٸ�, �̸� ��������� ������ �� ����
 *     
 *     - '�־��� �ڷᱸ������ ���Ҹ� ����'�ϴ� ����� �����ϰ�,
 *       ���� ȣ��Ǵ� ����Լ��� ������ �������� �� ������ ������ �Ѱ��ָ� �ȴ�.
 *       
 *     - ������ ��
 *       : ����Լ��� ���� ���Ŀ��� �� ���� ����� ���Ͽ� remove�� ���Ҹ� �ٽ� ���� index�� �־���� �Ѵ�.
 *     
 *     
 *     
 */

public class PermutationUsage2 {

	private int n;	// nPr�� n
	private int r;	// nPr�� r
	private ArrayList<Integer> itemList;
	private int[] res;
	
	// �ʱ�ȭ
	public PermutationUsage2(int[] intArr, int r) {
		
		this.r = r;					// nPr�� r
		this.n = intArr.length;		// nPr�� n
		this.res = new int[r];		// �ᱣ�� �迭
		
		// �������� �� ����Ʈ
		itemList = new ArrayList<Integer>();
		
		for (int item : intArr) {
			
			itemList.add(item);
			
		}
		
	}
	
	public void perm(int depth) {
		
		perm(itemList, 0);
		
	}
	
	public void perm(ArrayList<Integer> itemList, int depth) {
		
		// depth�� 0���� �������� ���, depth == r���� ����
		if (depth == r) {
			
			System.out.println(Arrays.toString(res));
			return;
			
		}
		
		for (int i=0; i < n-depth; i++) {
			
			res[depth] = itemList.remove(i);	// ������ ���� + ����Ʈ���� ����
			perm(itemList, depth+1);			// ���ȣ��
			itemList.add(i, res[depth]);		// ���ŵ� ������ ����
			
		}
		
	}
	
	
	public void multPerm(int depth) {
		
		multPerm(itemList, 0);
		
	}
	
	public void multPerm(ArrayList<Integer> itemList, int depth) {
		
		if (depth == r) {
			
			System.out.println(Arrays.toString(res));
			return;
			
		}
		
		for (int i=0; i < n-depth; i++) {
			
			res[depth] = itemList.get(i);		// ������ ���� + ����Ʈ���� ����
			multPerm(itemList, depth+1);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		int r = 3;
		int[] arr = {1,2,3,4,5};
		
		PermutationUsage2 main = new PermutationUsage2(arr, r);
		
		// ���� (permutation)
		System.out.println("##### permutation #####");
		main.perm(0);
		
		System.out.println("----------------------------");
		
		// �ߺ����� (multiset permutation)
		System.out.println("##### multiset permutation #####");
		main.multPerm(0);
		
	}
	
	
	
	
	
}
