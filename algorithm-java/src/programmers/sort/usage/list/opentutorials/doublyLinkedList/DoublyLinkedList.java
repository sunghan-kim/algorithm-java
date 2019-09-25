package programmers.sort.usage.list.opentutorials.doublyLinkedList;

// https://opentutorials.org/module/1335/8941

public class DoublyLinkedList {

	// 첫 번째 노드를 가리키는 필드
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node {
		
		// 데이터가 저장될 필드
		private Object data;
		
		// 다음 노드를 가리키는 필드
		private Node next;
		private Node prev;
		
		public Node(Object input) {
			
			this.data = input;
			this.next = null;
			this.prev = null;
			
		}
		
		// 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
		public String toString() {
			
			return String.valueOf(this.data);
			
		}
		
	}
	
	// 1. 시작 위치에 추가
	public void addFirst(Object input) {
		
		// 노드 생성
		Node newNode = new Node(input);
		
		// 새로운 노드의 다음 노드로 헤드를 지정
		newNode.next = head;
		
		// 기존에 노드가 있었다면 현재 헤드의 이전 노드로 새로운 노드를 지정
		if (head != null) {
			
			head.prev = newNode;
			
		}
		
		// 헤드로 새로운 노드 지정
		head = newNode;
		
		size++;
		
		if (head.next == null) {
			
			tail = head;
			
		}
		
	}
	
	// 2. 끝에 추가
	public void addLast(Object input) {
		
		// 노드 생성
		Node newNode = new Node(input);
		
		// 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드 사용
		if (size == 0) {
			addFirst(input);
		} else {
			
			// tail의 다음 노드로 생성한 노드 지정
			tail.next = newNode;
			
			// 새로운 노드의 이전 노드로 tail 지정
			newNode.prev = tail;
			
			// 마지막 노드 갱신
			tail = newNode;
			
			// 엘리먼트 개수 1 증가
			size++;
			
		}
		
	}
	
	// 3. 특정 위치에 추가
	public void add(int k, Object input) {
		
		// 만약 k가 0이라면 첫번째 노드에 추가하는 것
		// -> addFirst 사용
		if (k == 0) {
			
			addFirst(input);
			
		} else {
			
			Node temp1 = node(k-1);
			
			// k번째 노드를 temp2로 지정
			Node temp2 = temp1.next;
			
			// 새로운 노드 생성
			Node newNode = new Node(input);
			
			// temp1의 다음 노드로 새로운 노드를 지정
			temp1.next = newNode;
			
			// 새로운 노드의 다음 노드로 temp2를 지정
			newNode.next = temp2;
			
			// temp2의 이전 노드로 새로운 노드 지정
			if (temp2 != null) {
				
				temp2.prev = newNode;
				
			}
			
			// 새로운 노드의 이전 노드로 temp1 지정
			newNode.prev = temp1;
			
			size++;
			
			// 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드
			// -> tail로 지정
			if (newNode.next == null) {
				tail = newNode;
			}
			
		}
		
	}
	
	// 4. 노드 찾기
	Node node(int index) {
		
		// 노드의 인덱스가 전체 노드 수의 반보다 큰지 작은 지 계산
		if (index < size / 2) {
			
			// head부터 next를 이용해 인덱스에 해당하는 노드 찾기
			Node x = head;
			
			for (int i=0; i < index; i++) {
				
				x = x.next;
				
			}
			
			return x;
			
		} else {
			
			// tail부터 prev를 이용해서 인덱스에 해당하는 노드 찾기
			Node x = tail;
			
			for (int i=size-1; i > index; i--) {
				
				x = x.prev;
				
			}
			
			return x;
			
		}
		
	}
	
	// 5. 처음 노드 삭제
	public Object removeFirst() {
		
		// 첫 번째 노드를 temp로 지정하고, head의 값을 두번째 노드로 변경
		Node temp = head;
		
		head = temp.next;
		
		// 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담음
		Object returnData = temp.data;
		
		temp = null;
		
		// 리스트 내에 노드가 있다면 head의 이전 노드를 null로 지정
		if (head != null) {
			
			head.prev = null;
			
		}
		
		size--;
		
		return returnData;
		
	}
	
	// 6. 특정 위치 노드 삭제
	public Object remove(int k) {
		
		if (k == 0) {
			
			return removeFirst();
			
		}
		
		// k-1번째 노드를 temp로 지정
		Node temp = node(k-1);
		
		// temp.next를 삭제하기 전에 todoDeleted 변수에 보관
		Node todoDeleted = temp.next;
		
		// 삭제 대상 노드를 연결에서 분리
		temp.next = temp.next.next;
		
		if (temp.next != null) {
			
			// 삭제한 노드의 전후 노드를 연결
			temp.next.prev = temp;
			
		}
		
		// 삭제된 노드의 데이터를 리턴하기 위해 returnData에 데이터를 저장
		Object returnData = todoDeleted.data;
		
		// 삭제된 노드가 tail이었다면 이전 노드를 tail로 지정
		if (todoDeleted == tail) {
			
			tail = temp;
			
		}
		
		// cur.next 삭제
		todoDeleted = null;
		size--;
		
		return returnData;
		
	}
	
	// 7. 마지막 노드 삭제
	public Object remvoeLast() {
		
		return remove(size - 1);
		
	}
	
	// 8. 인덱스로 엘리먼트 가져오기
	public Object get(int k) {
		
		Node temp = node(k);
		
		return temp.data;
		
	}
	
	// 9. 탐색
	public int indexOf(Object data) {
		
		// 탐색 대상이 되는 노드를 temp로 지정
		Node temp = head;
		
		// 탐색 대상이 몇 번째 엘리먼트에 있는 지를 의미하는 변수로 index를 사용
		int index = 0;
		
		// 탐색 값과 탐색 대상 값 비교
		while (temp.data != data) {
			
			temp = temp.next;
			index++;
			
			// temp의 값이 null이라는 것은 더 이상 탐색 대상이 없다는 것
			if (temp == null) {
				
				return -1;
				
			}
			
		}
		
		// 탐색 대상을 찾았다면 대상의 인덱스 값을 리턴
		return index;
		
	}
	
	// 10. 반복
	public class ListIterator {
		
		private Node lastReturned;
		private Node next;
		private int nextIndex;
		
		ListIterator() {
			
			next = head;
			nextIndex = 0;
			
		}
		
		// 본 메소드를 호출하면 cursor의 참조값이 기존 cursor.next로 변경된다.
		public Object next() {
			
			lastReturned = next;
			next = next.next;
			nextIndex++;
			
			return lastReturned.data;
			
		}
		
		// cursor의 값이 없다면, 다시 말해서 더 이상 next를 통해서 가져올 노드가 없다 -> false 리턴
		// 이를 통해 next를 호출해도 되는 지를 사전에 판단할 수 있음
		public boolean hasNext() {
			
			return nextIndex < size;
			
		}
		
		public boolean hasPrevious() {
			
			return nextIndex > 0;
			
		}
		
		public Object previous() {
			
			if (next == null) {
				
				lastReturned = next = tail;
				
			} else {
				
				lastReturned = next = next.prev;
				
			}
			
			nextIndex--;
			
			return lastReturned.data;
			
		}
		
		public void add(Object input) {
			
			Node newNode = new Node(input);
			
			if (lastReturned == null) {
				
				head = newNode;
				newNode.next = next;
				
			} else {
				
				lastReturned.next = newNode;
				newNode.prev = lastReturned;
				
				if (next != null) {
					
					newNode.next = next;
					next.prev = newNode;
					
				} else {
					
					tail = newNode;
					
				}
				
			}
			
			lastReturned = newNode;
			nextIndex++;
			size++;
			
		}
		
		public void remove() {
			
			if (nextIndex == 0) {
				
				throw new IllegalStateException();
				
			}
			
			Node n = lastReturned.next;
			Node p = lastReturned.prev;
			
			if (p == null) {
				
				head = n;
				head.prev = null;
				lastReturned = null;
				
			} else {
				
				p.next = next;
				lastReturned.prev = null;
				
			}
			
			if (n == null) {
				
				tail = p;
				tail.next = null;
				
			} else {
				
				n.prev = p;
			}
			
			if (next == null) {
				
				lastReturned = tail;
				
			} else {
				
				lastReturned = next.prev;
				
			}
			
			size--;
			nextIndex--;
			
		}
		
	}
	
	
}
