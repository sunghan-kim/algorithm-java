package selectionSort;

// https://hyeonstorage.tistory.com/267?category=578561 - 참고

public class Sorting {
	
	public static void selectionSort(Comparable[] list) {
		
		int min;
		Comparable temp;
		
		// 리스트를 처음부터 탐색하며 Comparable에 정의된 compareTo에 따라 정렬한다.
		for (int index = 0; index < list.length-1; index++) {
			
			min = index;
			
			// 현재 index부터 마지막까지 탐색하며 가장 최소값을 찾는다.
			for (int scan = index+1; scan < list.length; scan++) {
				
				// 현재 위치와 scan 위치를 비교하여 가장 작은 값을 찾는다.
				// Comparable에 정의된 compareTo에 결과에 따라 비교
				if (list[scan].compareTo(list[min]) < 0) {
					min = scan;
				}
				
				// 현재 index와 최소값의 위치를 바꾼다.
				temp = list[min];
				list[min] = list[index];
				list[index] = temp;
				
			}
			
		}
		
	}
	
}
