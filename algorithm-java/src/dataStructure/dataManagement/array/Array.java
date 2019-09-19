package dataStructure.dataManagement.array;

// https://hyeonstorage.tistory.com/257?category=578561

/**
 * 
 * @author shkim
 * 
 * # JAVA 배열을 이용한 자료의 관리
 * 
 * - 배열은 초기 생성시에 그 크기를 미리 지정해야 한다.
 * - 초기에 지정한 크기는 바꿀 수 없다.
 *   -> 생성한 크기보다 많은 자료를 저장할 수 없음
 *      (효율적인 자료구조로 사용하는 데 제약이 따른다.
 *
 */

public class Array {

	public static void main(String[] args) {

		// 1. 배열 선언, 생성 및 초기화
		// 배열 선언
		String[] arr;
		
		// new 키워드를 이용해 배열 생성
		// 배열 생성 시 배열 크기 지정 필요
		arr = new String[10];
		
		// 다차원 배열 선언시에는 항상 정방형 구조로만 만들 수 있는 것은 아님
		// 아래의 이차원 배열은 3행을 생성한 후 각 행을 5, 10, 8 열로 각각 다른 크기로 배열 생성
		int[][] arr2;
		arr2 = new int[3][];
		arr2[0] = new int[5];
		arr2[1] = new int[10];
		arr2[2] = new int[8];
		
		// 배열 생성 시 각 요소는 생성한 데이터 타입의 초기값으로 초기화됨
		// - 정수형 데이터 타입 = 0
		// - 실수형 데이터 타입 = 0.0 or 0.0f
		// - boolean 타입 = false
		// - char 타입 = ''
		// - String과 같은 객체를 참조하는 경우 = null
		
		
		// 2. 배열의 자료 관리 (삽입, 검색, 삭제)
		
		// 2.1 자료의 삽입
		int[] arr3 = new int[20];
		int size = 0;
		
		for (int i=0; i < arr3.length; i++) {
			arr3[i] = i+1;
			size++;
		}
		
		// 2.2 자료의 검색
		// - 자료의 중복이 없을 경우 배열의 처음부터 순차적으로 비교하여 매칭되는 데이터가 있을 경우
		//   비교작업을 중지해도 됨
		// - 중복이 있는 경우는 모든 요소를 순차적으로 비교하는 작업을 해야 한다.
		int searchKey = 5;
		for (int i=0; i < size; i++) {
			if (arr3[i] == searchKey) {
				System.out.println(i + "번째에 " + searchKey + " 을 찼았다.");
				break; // 중복자료가 있어 모든 배열을 찾아야 하는 경우 break를 제거
			}
		}
		
		// 2.3 자료의 삭제
		int deleteKey = 5;
		for (int i=0; i < size; i++) {
			if (arr3[i] == deleteKey) {
				
				// deleteKey를 찾으면 삭제 후 뒤의 데이터를 앞으로 한칸씩 밀어주기 위해
				// for문으로 뒤의 데이터를 앞의 열로 대입시키고 배열의 크기(size)를 감소시킨다.
				for (int k=i; k < size-1; k++) {
					arr3[k] = arr3[k+1];
				}
				
				size--;
				break; // 중복데이터가 있으면 break를 제거하여 배열 전체를 탐색
				
			}
		}
		
	}
	
	
}
