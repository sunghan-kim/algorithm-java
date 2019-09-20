package blog.hyeonstorage.insertionSort;

// https://hyeonstorage.tistory.com/268?category=578561 참고

public class Sorting {
	
	public static void insertionSort(Comparable[] list) {
		
		// 정렬 비교대상 index 1 부터 루프를 돌면서 비교 삽입 정렬한다.
		for (int index=1; index < list.length; index++) {
			
			Comparable key = list[index];
			int position = index;
			
			// 정렬 부분집합의 뒤의 값부터 index 값을 비교하면서
			// index 값보다 작은 값이 나올때까지 밀어내고 적절한 위치에 삽입한다.
			while (position > 0 && key.compareTo(list[position-1]) < 0) {
				list[position] = list[position-1];
				position--;
			}
			
			list[position] = key;
			
		}
		
	}
	
}
