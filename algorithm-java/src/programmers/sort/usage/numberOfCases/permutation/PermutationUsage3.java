package programmers.sort.usage.numberOfCases.permutation;

import java.util.Arrays;

//https://redscreen.tistory.com/168

/**
 * 
 * @author shkim
 * 
 * # ����
 * 
 * 2. ����Լ� + ��ġ����(swap)�� �̿��� ����
 * 
 *   - ��ҿ� ��Ҹ� �ڸ� �ٲ�
 *   - depth ������ �̿��Ͽ� ������ �� �ִ� ����� ���� ����
 *   
 *   
 *   - P(4, 2)
 *   
 *   = (ù°[depth] <-> ù°(i) swap) [1,2,3,4] �߿��� '1' ���� x (��°[depth]���°(i) swap) [1,2,3,4] �߿��� '2' ���� => 12
 *     (ù°[depth] <-> ù°(i) swap) [1,2,3,4] �߿��� '1' ���� x (��°[depth]���°(i) swap) [1,3,2,4] �߿��� '3' ���� => 13
 *     (ù°[depth] <-> ù°(i) swap) [1,2,3,4] �߿��� '1' ���� x (��°[depth]���°(i) swap) [1,4,3,2] �߿��� '4' ���� => 14
 *     
 *     (ù°[depth] <-> ��°(i) swap) [2,1,3,4] �߿��� '2' ���� x (��°[depth]���°(i) swap) [2,1,3,4] �߿��� '1' ���� => 21
 *     (ù°[depth] <-> ��°(i) swap) [2,1,3,4] �߿��� '2' ���� x (��°[depth]���°(i) swap) [2,3,1,4] �߿��� '3' ���� => 23
 *     (ù°[depth] <-> ��°(i) swap) [2,1,3,4] �߿��� '2' ���� x (��°[depth]���°(i) swap) [2,4,3,1] �߿��� '4' ���� => 24
 *     
 *     (ù°[depth] <-> ��°(i) swap) [3,2,1,4] �߿��� '3' ���� x (��°[depth]���°(i) swap) [3,2,1,4] �߿��� '2' ���� => 32
 *     (ù°[depth] <-> ��°(i) swap) [3,2,1,4] �߿��� '3' ���� x (��°[depth]���°(i) swap) [3,1,2,4] �߿��� '1' ���� => 31
 *     (ù°[depth] <-> ��°(i) swap) [3,2,1,4] �߿��� '3' ���� x (��°[depth]���°(i) swap) [3,4,1,2] �߿��� '4' ���� => 34
 *     
 *     (ù°[depth] <-> ��°(i) swap) [4,2,3,1] �߿��� '4' ���� x (��°[depth]���°(i) swap) [4,2,3,1] �߿��� '2' ���� => 42
 *     (ù°[depth] <-> ��°(i) swap) [4,2,3,1] �߿��� '4' ���� x (��°[depth]���°(i) swap) [4,3,2,1] �߿��� '3' ���� => 43
 *     (ù°[depth] <-> ��°(i) swap) [4,2,3,1] �߿��� '4' ���� x (��°[depth]���°(i) swap) [4,1,3,2] �߿��� '1' ���� => 41
 *     
 *   - ���ΰ� ������ swap�ϴ� �κ��� ������, ���� ���̽��� ������
 *     (ex. [1,2,3,4]���� swap�Ǿ� [2,1,3,4] ���� ��� ����)
 *     
 *   - depth�� 0���� �������� ��, depth == r�� �Ǹ� r�� ��ŭ �����
 *   - �������� r�� 2�̹Ƿ�, index�� 0~1������ ���� 2���� ���
 *   
 *   
 *   - �� ������ �����ϴ� ���
 *   
 *     - for���� �̿��Ͽ� ���������� ���� depth ���ҿ� i��° ���Ҹ� swap
 *       (�ڿ������� swap�Ǿ� ù ��°�� �Ű��� ���Ұ� ���õ�)
 *       
 *     - �������� ȣ��Ǵ� ��� �Լ����� ������ �ε���(depth+1)�� �Ѱ��ָ� ������ �������鼭 ���� �ذ�
 *     
 *     - ������ ��
 *       : swap �޼ҵ� ������ ���ҵ��� ������ ����Ǳ� ������ �̸� �ٽ� �ǵ��� �־�� �Ѵ�.
 *
 */

public class PermutationUsage3 {

	private int n;		// nPr�� n
	private int r;		// nPr�� r
	private int[] res;	// �����
	
	// �ʱ�ȭ
	public PermutationUsage3(int n, int r) {
		
		this.n = n;
		this.r = r;
		res = new int[r];
		
	}
	
	public void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	public void perm(int[] arr, int depth) {
		
		// depth�� 0���� �������� ���, depth == r���� ����
		if (depth == r) {
			
			System.out.println(Arrays.toString(res));
			return;
			
		}
		
		for (int i=depth; i < n; i++) {
			
			swap(arr, depth, i);		// ����
			res[depth] = arr[depth];	// ���õ� ���� ����
			perm(arr, depth+1);			// ���ȣ��
			swap(arr, depth, i);		// ����
			
		}
		
	}
	
	public void multPerm(int[] arr, int depth) {
		
		// depth�� 0���� �������� ���, depth == r���� ����
		if (depth == r) {
			
			System.out.println(Arrays.toString(res));
			return;
			
		}
		
		// �ߺ�����
		for (int i=0; i < n; i++) { // i�� depth�� �ƴ� 0���� �����ϴ� ���� ������ ����
			
			swap(arr, depth, i);		// ����
			res[depth] = arr[depth];	// ���õ� ���� ����
			multPerm(arr, depth+1);			// ���ȣ��
			swap(arr, depth, i);		// ����
			
		}
		
	}
	
	public static void main(String[] args) {
		
		int r = 2;
		int[] arr = {1,2,3,4};
		
		PermutationUsage3 main = new PermutationUsage3(arr.length, r);
		
		// ���� (permutation)
		System.out.println("##### permutation #####");
		main.perm(arr, 0);
		
		System.out.println("----------------------------");
		
		// �ߺ����� (multiset permutation)
		System.out.println("##### multiset permutation #####");
		main.multPerm(arr, 0);
		
		
		
	}
	
}
