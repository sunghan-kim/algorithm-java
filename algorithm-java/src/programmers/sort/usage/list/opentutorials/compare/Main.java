package programmers.sort.usage.list.opentutorials.compare;

import programmers.sort.usage.list.opentutorials.arrayList.ArrayList;
import programmers.sort.usage.list.opentutorials.linkedList.LinkedList;

// https://opentutorials.org/module/1335/8857

public class Main {

	public static void main(String[] args) {
		
		ArrayList a = new ArrayList();
		
		a.addLast(10);
		a.addLast(20);
		a.addLast(30);
		
		
		
		LinkedList l = new LinkedList();
		
		l.addLast(10);
		l.addLast(20);
		l.addLast(30);
		
		
		
		// 1. addFirst() 비교
		
		// 1.1 ArrayList
		//  - 하나씩 다 뒤로 땡긴 다음 맨 처음에 삽입
		a.addFirst(5); 
		
		// 1.2 LinkedList
		//  - 새로 추가된 노드를 head로 지정하고, 기존의 head 노드를 새로운 노드의 next로 지정하기만 하면 끝
		l.addFirst(5); 
		
		
		// -> addFirst()의 경우 LinkedList의 성능이 더 우수하다!
		
		
		// 2. get() 비교
		
		// 2.1 ArrayList
		//  - 인덱스를 통해 메모리에 어떤 위치에 데이터가 있는 지 알고 있는 주소로 접근
		//  - random access 메모리의 특성 상 어느 주소로 접근하든지 동일한 속도를 보장받는다. (굉장히 빠른 처리 속도)
		System.out.println(a.get(2)); 
		
		// 2.2 LinkedList
		//  - 처음부터 찾아가야 한다. (next, next, ...) 
		System.out.println(l.get(2));
		
		// -> get() 의 경우 ArrayList의 성능이 더 우수하다!
		
		
		// 3. ListIterator() 비교
		
		// 3.1 ArrayList
		ArrayList.ListIterator ai = a.listIterator();
		
		while (ai.hasNext()) {
			
			if ((int)ai.next() == 20) {
				
				ai.add(25); // 중간 노드 추가 시 뒤의 노드를 전부 뒤로 밀어야 한다.
				
			}
			
		}
		
		//  - 또한 ArrayList는 추가 가능한 배열의 크기 (ex. 100)이 지정되어 있다. (100개 이상 추가 불가)
		//  - Java에선 지정된 크기 이상으로 ArrayList에 데이터가 추가되면 2배의 여유공간을 확보하게 된다.
		//  - 따라서 위의 특성이 Java에선 겉으로 드러나진 않는다.
		//  - 이러한 것을 "Dynamic Array(동적 배열)"이라고 한다.
		
		
		// 3.2 LinkedList
		LinkedList.ListIterator li = l.listIterator();
		
		while (li.hasNext()) {
			
			if ((int)li.next() == 20) {
				
				li.add(25); // 중간 노드 추가 시 이전 노드의 next를 추가된 노드로, 추가된 노드의 next를 20 값을 갖는 노드로 지정하면 끝
				
			}
			
		}
		
		//  - LinkedList는 메모리가 허용하는 데까지 노드를 추가할 수 있다. 
		//  - 직접 구현한 LinkedList는 java.collections 클래스의 LinkedList와는 약간 다르다.
		//  - java.collections 프레임워크의 LinkedList는 "Doubly Linked List"를 구현한 것이다.
		//  - 여기서 구현한 LinkedList는 단방향 LinkeList이다.
		
	}
	
}
