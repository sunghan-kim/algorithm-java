package blog.hyeonstorage.dataStructure.dataManagement.array;

// https://hyeonstorage.tistory.com/257?category=578561

/**
 * 
 * @author shkim
 * 
 * # JAVA �迭�� �̿��� �ڷ��� ����
 * 
 * - �迭�� �ʱ� �����ÿ� �� ũ�⸦ �̸� �����ؾ� �Ѵ�.
 * - �ʱ⿡ ������ ũ��� �ٲ� �� ����.
 *   -> ������ ũ�⺸�� ���� �ڷḦ ������ �� ����
 *      (ȿ������ �ڷᱸ���� ����ϴ� �� ������ ������.
 *
 */

public class Array {

	public static void main(String[] args) {

		// 1. �迭 ����, ���� �� �ʱ�ȭ
		// �迭 ����
		String[] arr;
		
		// new Ű���带 �̿��� �迭 ����
		// �迭 ���� �� �迭 ũ�� ���� �ʿ�
		arr = new String[10];
		
		// ������ �迭 ����ÿ��� �׻� ������ �����θ� ���� �� �ִ� ���� �ƴ�
		// �Ʒ��� ������ �迭�� 3���� ������ �� �� ���� 5, 10, 8 ���� ���� �ٸ� ũ��� �迭 ����
		int[][] arr2;
		arr2 = new int[3][];
		arr2[0] = new int[5];
		arr2[1] = new int[10];
		arr2[2] = new int[8];
		
		// �迭 ���� �� �� ��Ҵ� ������ ������ Ÿ���� �ʱⰪ���� �ʱ�ȭ��
		// - ������ ������ Ÿ�� = 0
		// - �Ǽ��� ������ Ÿ�� = 0.0 or 0.0f
		// - boolean Ÿ�� = false
		// - char Ÿ�� = ''
		// - String�� ���� ��ü�� �����ϴ� ��� = null
		
		
		// 2. �迭�� �ڷ� ���� (����, �˻�, ����)
		
		// 2.1 �ڷ��� ����
		int[] arr3 = new int[20];
		int size = 0;
		
		for (int i=0; i < arr3.length; i++) {
			arr3[i] = i+1;
			size++;
		}
		
		// 2.2 �ڷ��� �˻�
		// - �ڷ��� �ߺ��� ���� ��� �迭�� ó������ ���������� ���Ͽ� ��Ī�Ǵ� �����Ͱ� ���� ���
		//   ���۾��� �����ص� ��
		// - �ߺ��� �ִ� ���� ��� ��Ҹ� ���������� ���ϴ� �۾��� �ؾ� �Ѵ�.
		int searchKey = 5;
		for (int i=0; i < size; i++) {
			if (arr3[i] == searchKey) {
				System.out.println(i + "��°�� " + searchKey + " �� á�Ҵ�.");
				break; // �ߺ��ڷᰡ �־� ��� �迭�� ã�ƾ� �ϴ� ��� break�� ����
			}
		}
		
		// 2.3 �ڷ��� ����
		int deleteKey = 5;
		for (int i=0; i < size; i++) {
			if (arr3[i] == deleteKey) {
				
				// deleteKey�� ã���� ���� �� ���� �����͸� ������ ��ĭ�� �о��ֱ� ����
				// for������ ���� �����͸� ���� ���� ���Խ�Ű�� �迭�� ũ��(size)�� ���ҽ�Ų��.
				for (int k=i; k < size-1; k++) {
					arr3[k] = arr3[k+1];
				}
				
				size--;
				break; // �ߺ������Ͱ� ������ break�� �����Ͽ� �迭 ��ü�� Ž��
				
			}
		}
		
	}
	
	
}