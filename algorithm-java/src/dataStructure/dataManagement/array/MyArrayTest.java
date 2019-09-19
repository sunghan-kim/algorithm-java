package dataStructure.dataManagement.array;

// https://hyeonstorage.tistory.com/257?category=578561

public class MyArrayTest {

	public static void main(String[] args) {
		
		// 크기 5인 배열 객체 생성
		MyArray arr = new MyArray(5);
		
		// 배열에 데이터를 입력
		for (int i=1; i <= 5; i++) {
			arr.add("데이터-"+i);
		}
		
		// 현재 배열에 입력된 데이터 전체 출력 : toString()
		System.out.println(arr);
		
		// 배열의 0번째, 3번째 데이터를 가져와 출력
		System.out.println(arr.get(0));
		System.out.println(arr.get(3));
		
		// index == 3 의 데이터를 제거
		arr.remove(3);
		
		// 배열 데이터 출력
		System.out.println(arr);
		
		// index == 3 위치에 "데이터-4" 삽입
		arr.add(3, "데이터-4");
		
		// 배열 전체 출력
		System.out.println(arr);
		
	}
	
}
