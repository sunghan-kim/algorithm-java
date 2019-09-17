package selectionSort;

// https://hyeonstorage.tistory.com/267?category=578561 - ����

public class Sorting {
	
	public static void selectionSort(Comparable[] list) {
		
		int min;
		Comparable temp;
		
		// ����Ʈ�� ó������ Ž���ϸ� Comparable�� ���ǵ� compareTo�� ���� �����Ѵ�.
		for (int index = 0; index < list.length-1; index++) {
			
			min = index;
			
			// ���� index���� ���������� Ž���ϸ� ���� �ּҰ��� ã�´�.
			for (int scan = index+1; scan < list.length; scan++) {
				
				// ���� ��ġ�� scan ��ġ�� ���Ͽ� ���� ���� ���� ã�´�.
				// Comparable�� ���ǵ� compareTo�� ����� ���� ��
				if (list[scan].compareTo(list[min]) < 0) {
					min = scan;
				}
				
				// ���� index�� �ּҰ��� ��ġ�� �ٲ۴�.
				temp = list[min];
				list[min] = list[index];
				list[index] = temp;
				
			}
			
		}
		
	}
	
}
