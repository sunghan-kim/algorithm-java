package blog.hyeonstorage.insertionSort;

// https://hyeonstorage.tistory.com/268?category=578561 ����

public class Sorting {
	
	public static void insertionSort(Comparable[] list) {
		
		// ���� �񱳴�� index 1 ���� ������ ���鼭 �� ���� �����Ѵ�.
		for (int index=1; index < list.length; index++) {
			
			Comparable key = list[index];
			int position = index;
			
			// ���� �κ������� ���� ������ index ���� ���ϸ鼭
			// index ������ ���� ���� ���ö����� �о�� ������ ��ġ�� �����Ѵ�.
			while (position > 0 && key.compareTo(list[position-1]) < 0) {
				list[position] = list[position-1];
				position--;
			}
			
			list[position] = key;
			
		}
		
	}
	
}
