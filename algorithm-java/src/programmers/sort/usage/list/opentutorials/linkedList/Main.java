package programmers.sort.usage.list.opentutorials.linkedList;

import java.util.ListIterator;

// https://opentutorials.org/module/1335/8857

public class Main {

	public static void main(String[] args) {
		
		LinkedList numbers = new LinkedList();
		
		/**
		 * 3. 출력
		 */
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		
		System.out.println(numbers);
		
		System.out.println("-------------------------------");
		
		/**
		 * 
		 * 4. 삭제
		 * 
		 */
		
		/**
		 * 
		 * 4.1 처음 노드 삭제
		 * 
		 */
		LinkedList numbers2 = new LinkedList();
		
		numbers2.addLast(5);
		numbers2.addLast(10);
		numbers2.addLast(20);
		numbers2.addLast(30);
		
		System.out.println(numbers2);
		System.out.println(numbers2.removeFirst());
		System.out.println(numbers2);
		
		System.out.println("-------------------------------");
		
		/**
		 * 
		 * 4.2 중간의 데이터를 삭제
		 * 
		 */
		
		LinkedList numbers3 = new LinkedList();
		
		numbers3.addLast(5);
		numbers3.addLast(10);
		numbers3.addLast(20);
		numbers3.addLast(30);
		
		System.out.println(numbers3);
		System.out.println(numbers3.remove(1));
		System.out.println(numbers3);
		
		System.out.println("-------------------------------");
		
		/**
		 * 
		 * 5. 엘리먼트의 크기
		 * 
		 */
		LinkedList numbers4 = new LinkedList();
		
		numbers4.addLast(10);
		numbers4.addLast(20);
		numbers4.addLast(30);
		
		System.out.println(numbers4.size());
		
		System.out.println("-------------------------------");
		
		/**
		 * 
		 * 6. 엘리먼트 가져오기
		 * 
		 */
		
		LinkedList numbers5 = new LinkedList();
		
		numbers5.addLast(10);
		numbers5.addLast(20);
		numbers5.addLast(30);
		
		System.out.println(numbers5.get(0));
		System.out.println(numbers5.get(1));
		System.out.println(numbers5.get(2));
		
		System.out.println("-------------------------------");
		
		/**
		 * 
		 * 7. 탐색
		 * 
		 */
		
		LinkedList numbers6 = new LinkedList();
		
		numbers6.addLast(10);
		numbers6.addLast(20);
		numbers6.addLast(30);
		
		System.out.println(numbers6.indexOf(10));
		System.out.println(numbers6.indexOf(20));
		System.out.println(numbers6.indexOf(30));
		System.out.println(numbers6.indexOf(40));
		
		System.out.println("-------------------------------");
		
		/**
		 * 
		 * 8. 반복 
		 * 
		 */
		
		/**
		 * 
		 * 8.1 Iterator 객체 생성과 next 메서드
		 * 
		 */
		
		// 기본적인 반복 작업
		for (int i=0; i < numbers6.size(); i++) {
			
			System.out.println(numbers6.get(i));
			
		}
		
		System.out.println("-------------------------------");
		
		// 하지만 이 방법은 LinkedList에선 유용하지 않다.
		// ArrayList와 달리 LinkedList에서 get은 효율적이지 않기 때문이다.
		// get을 호출할 때마다 내부적으로 반복문이 실행된다.
		// 이런 경우 Iterator를 사용하는 것이 유리하다.
		// Iterator는 내부적으로 반복 처리된 노드가 무엇인지에 대한 정보를 유지하기 때문이다.
		LinkedList numbers7 = new LinkedList();
		
		numbers7.addLast(10);
		numbers7.addLast(20);
		numbers7.addLast(30);
		
		LinkedList.ListIterator li = numbers7.listIterator();
		
		System.out.println(li.next());
		System.out.println(li.next());
		System.out.println(li.next());
		
		System.out.println("-------------------------------");
		
		/**
		 * 
		 * 8.2 hasNext
		 * 
		 */
		
		LinkedList numbers8 = new LinkedList();
		
		numbers8.addLast(10);
		numbers8.addLast(20);
		numbers8.addLast(30);
		
		LinkedList.ListIterator li2 = numbers8.listIterator();
		
		while (li2.hasNext()) {
			
			System.out.println(li2.next());
			
		}
		
		System.out.println("-------------------------------");
		
		/**
		 * 
		 * 8.3 add
		 * 
		 */
		LinkedList numbers9 = new LinkedList();
		
		numbers9.addLast(10);
		numbers9.addLast(30);
		
		LinkedList.ListIterator li3 = numbers9.listIterator();
		
		while (li3.hasNext()) {
			
			if ((int)li3.next() == 10) {
				
				li3.add(20);
				
			}
			
		}
		
		System.out.println(numbers9);
		
		System.out.println("-------------------------------");
		
		/**
		 * 
		 * 8.4 remove
		 * 
		 */
		LinkedList numbers10 = new LinkedList();
		
		numbers10.addLast(10);
		numbers10.addLast(15);
		numbers10.addLast(20);
		numbers10.addLast(30);
		
		LinkedList.ListIterator li4 = numbers10.listIterator();
		
		while (li4.hasNext()) {
			
			if ((int)li4.next() == 15) {
				
				li4.remove();
				
			}
			
		}
		
		System.out.println(numbers10);
		
	}
	
}
