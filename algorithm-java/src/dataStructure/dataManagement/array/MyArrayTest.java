package dataStructure.dataManagement.array;

// https://hyeonstorage.tistory.com/257?category=578561

public class MyArrayTest {

	public static void main(String[] args) {
		
		// ũ�� 5�� �迭 ��ü ����
		MyArray arr = new MyArray(5);
		
		// �迭�� �����͸� �Է�
		for (int i=1; i <= 5; i++) {
			arr.add("������-"+i);
		}
		
		// ���� �迭�� �Էµ� ������ ��ü ��� : toString()
		System.out.println(arr);
		
		// �迭�� 0��°, 3��° �����͸� ������ ���
		System.out.println(arr.get(0));
		System.out.println(arr.get(3));
		
		// index == 3 �� �����͸� ����
		arr.remove(3);
		
		// �迭 ������ ���
		System.out.println(arr);
		
		// index == 3 ��ġ�� "������-4" ����
		arr.add(3, "������-4");
		
		// �迭 ��ü ���
		System.out.println(arr);
		
	}
	
}
