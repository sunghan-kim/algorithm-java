package programmers.sort.usage.list.linkedList;

// https://opentutorials.org/module/1335/8857

public class LinkedList {

	/**
	 * 1. 노드(버텍스) 구현
	 * 
	 *   - LinkedList에서 가장 중요한 것이 바로 노드의 구현
	 *   - 노드는 실제로 데이터가 저장되는 그릇과 같은 것이기 때문에 
	 *     이것부터 구현을 시작
	 *   - 자바는 객체지향 언어이기 때문에 노드는 객체로 만들기 딱 좋은 대상이다.
	 *   - 그리고 노드 객체는 리스트의 내부 부품이기 때문에 외부에는 노출되지 않는 것이 좋다.
	 *     (private으로 지정)
	 *   
	 *   - head : 첫 번째 노드를 지정하는 참조값
	 *   - tail : 마지막 노드를 지정
	 *   - size : 노드의 크기
	 *   
	 *   - 노드를 변경할 때마다 이 값들을 수정해야 한다.
	 *   -  tail이나 size는 마지막 노드를 찾거나 노드의 수를 셀 때 연산의 횟수를 획기적으로 줄여준다.
	 *   
	 *   - 객체 Node는 내부적으로 data와 next 변수를 가지고 있다.
	 *     - data : 노드의 값
	 *     - next : 다음 노드를 가리키는 참조값
	 *   
	 */
	
	// 1.1 첫 번째 노드를 가리키는 필드
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node {
		
		// 1.2 데이터가 저장될 필드
		private Object data;
		
		// 1.3 다음 노드를 가리키는 필드
		private Node next;
		
		public Node(Object input) {
			
			this.data = input;
			this.next = null;
			
		}
		
		// 1.4 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
		public String toString() {
			
			return String.valueOf(this.data);
			
		}
		
	}
	
	/**
	 * 2. 데이터 추가
	 * 
	 */
	
	/**
	 * 
	 * 2.1 시작에 추가
	 * 
	 */
	public void addFirst(Object input) {
		
		// 2.1.1 노드 생성
		Node newNode = new Node(input);
		
		// 2.1.2 새로운 노드의 다음 노드로 해드를 지정
		newNode.next = head;
		
		// 2.1.3 헤드로 새로운 노드를 지정
		head = newNode;
		size++;
		
		if (head.next == null) {
			
			tail = head;
			
		}
		
	}
	
	/**
	 * 
	 * 2.2 끝에 추가
	 * 
	 *   - 리스트의 끝에 데이터를 추가할 때는 tail을 사용합니다. 
	 *   - tail이 없이도 구현이 가능합니다. 
	 *   - 하지만 tail이 없다면 마지막 노드를 찾아야 할 것입니다.
	 *   - 리스트의 끝에 데이터를 추가하는 작업은 자주 있는 작업이고, 
	 *     마지막 노드를 찾는 작업은 첫 노드부터 마지막 노드까지 순차적으로 탐색을 해야 하기 때문에 
	 *     최악의 상황이라고 할 수 있습니다. 
	 *   - 그래서 우리 수업에서는 tail을 사용합니다.
	 * 
	 */
	public void addLast(Object input) {
		
		// 2.2.1 노드 생성
		Node newNode = new Node(input);
		
		// 2.2.2 리스트의 노드가 없다면 첫번째 노드를 추가하는 메서드 사용
		if (size == 0) {
			
			addFirst(input);
			
		} else {
			
			// 2.2.3 마지막 노드의 다음 노드로 생성한 노드를 지정
			tail.next = newNode;
			
			// 2.2.4 마지막 노드 갱신
			tail = newNode;
			
			// 2.2.5 엘리먼트 개수 1 증가
			size++;
			
		}
		
	}
	
	/**
	 * 
	 * 2.3 중간에 추가
	 * 
	 */
	
	// 2.3.1 특정 위치의 노드를 찾아내는 방법
	Node node(int index) {
		
		Node x = head;
		
		for (int i=0; i < index; i++) {
			
			x = x.next;
			
		}
		
		return x;
		
	}
	
	// 2.3.2 node 메소드 이용 특정 위치에 노드 추가
	public void add(int k, Object input) {
		
		// 2.3.2.1 k=0 -> 첫 번째 노드에 추가 -> addFirst 사용
		if (k == 0) {
			
			addFirst(input);
			
		} else {
			
			Node temp1 = node(k-1);
			
			// 2.3.2.2 k번째 노드를 temp2로 지정
			Node temp2 = temp1.next;
			
			// 2.3.2.3 새로운 노드 생성
			Node newNode = new Node(input);
			
			// 2.3.2.4 temp1의 다음 노드로 새로운 노드를 지정
			temp1.next = newNode;
			
			// 2.3.2.5 새로운 노드의 다음 노드로 temp2를 지정
			newNode.next = temp2;
			
			// 2.3.2.6 엘리먼트 갯수 증가
			size++;
			
			// 2.3.2.7 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드
			//         -> tail 지정
			if (newNode.next == null) {
				
				tail = newNode;
				
			}
			
		}
		
	}
	
	/**
	 * 
	 * 3. 출력
	 * 
	 *   - 제대로 데이터가 추가 되고 있는지 확인하는 방법이 필요
	 *   - LinkedList의 toString 메소드를 구현해서 리스트가 제대로 만들어지고 있는지는 확인하는 코드를 작성해봅시다.
	 * 
	 */
	
	public String toString() {
		
		// 3.1 노드가 없으면 [] 리턴
		if (head == null) {
			
			return "[]";
			
		}
		
		// 3.2 탐색 시작
		Node temp = head;
		String str = "[";
		
		// 3.3 다음 노드가 없을 때까지 반복문 실행
		//     (마지막 노드는 다음 노드가 없기 때문에 아래 구문은 마지막 노드는 제외됨
		while(temp.next != null) {
			
			str += temp.data + ",";
			temp = temp.next;
			
		}
		
		// 3.4 마지막 노드를 출력결과에 포함
		str += temp.data;
		
		return str+"]";
		
	}
	
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
	public Object removeFirst() {
		
		// 4.1.1 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경
		Node temp = head;
		head = temp.next;
		
		// 4.1.2 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담음
		Object returnData = temp.data;
		temp = null;
		size--;
		
		return returnData;
		
	}
	
	/**
	 * 
	 * 4.2 중간의 데이터를 삭제
	 * 
	 */
	public Object remove(int k) {
		
		// 4.2.1 k=0 -> 첫번째 노드 삭제 -> removeFirst() 호출
		if (k==0) {
			removeFirst();
		}
		
		// 4.2.2 k-1번째 노드를 temp의 값으로 지정
		Node temp = node(k-1);
		
		// 4.2.3 삭제 노드를 todoDeleted에 기록
		//		 (삭제 노드를 지금 제거하면 삭제 앞 노드와 삭제 뒤 노드를 연결할 수 없다.
		Node todoDeleted = temp.next;
		
		// 4.2.4 삭제 앞 노드의 다음 노드로 삭제 뒤 노드를 지정
		temp.next = temp.next.next;
		
		// 4.2.5 삭제된 데이터를 리턴하기 위해 returnData에 데이터를 저장
		Object returnData = todoDeleted.data;
		
		if (todoDeleted == tail) {
			
			tail = temp;
			
		}
		
		// 4.2.6 cur.next를 삭제
		todoDeleted = null;
		
		size--;
		
		return returnData;
		
	}
}
