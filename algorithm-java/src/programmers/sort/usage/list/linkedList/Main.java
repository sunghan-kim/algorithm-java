package programmers.sort.usage.list.linkedList;


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
		
	}
	
}
