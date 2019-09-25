package programmers.sort.usage.list.opentutorials.doublyLinkedList;

// https://opentutorials.org/module/1335/8941

public class DoublyLinkedList {

	// ù ��° ��带 ����Ű�� �ʵ�
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node {
		
		// �����Ͱ� ����� �ʵ�
		private Object data;
		
		// ���� ��带 ����Ű�� �ʵ�
		private Node next;
		private Node prev;
		
		public Node(Object input) {
			
			this.data = input;
			this.next = null;
			this.prev = null;
			
		}
		
		// ����� ������ ���� ����ؼ� Ȯ���غ� �� �ִ� ���
		public String toString() {
			
			return String.valueOf(this.data);
			
		}
		
	}
	
	// 1. ���� ��ġ�� �߰�
	public void addFirst(Object input) {
		
		// ��� ����
		Node newNode = new Node(input);
		
		// ���ο� ����� ���� ���� ��带 ����
		newNode.next = head;
		
		// ������ ��尡 �־��ٸ� ���� ����� ���� ���� ���ο� ��带 ����
		if (head != null) {
			
			head.prev = newNode;
			
		}
		
		// ���� ���ο� ��� ����
		head = newNode;
		
		size++;
		
		if (head.next == null) {
			
			tail = head;
			
		}
		
	}
	
	// 2. ���� �߰�
	public void addLast(Object input) {
		
		// ��� ����
		Node newNode = new Node(input);
		
		// ����Ʈ�� ��尡 ���ٸ� ù��° ��带 �߰��ϴ� �޼ҵ� ���
		if (size == 0) {
			addFirst(input);
		} else {
			
			// tail�� ���� ���� ������ ��� ����
			tail.next = newNode;
			
			// ���ο� ����� ���� ���� tail ����
			newNode.prev = tail;
			
			// ������ ��� ����
			tail = newNode;
			
			// ������Ʈ ���� 1 ����
			size++;
			
		}
		
	}
	
	// 3. Ư�� ��ġ�� �߰�
	public void add(int k, Object input) {
		
		// ���� k�� 0�̶�� ù��° ��忡 �߰��ϴ� ��
		// -> addFirst ���
		if (k == 0) {
			
			addFirst(input);
			
		} else {
			
			Node temp1 = node(k-1);
			
			// k��° ��带 temp2�� ����
			Node temp2 = temp1.next;
			
			// ���ο� ��� ����
			Node newNode = new Node(input);
			
			// temp1�� ���� ���� ���ο� ��带 ����
			temp1.next = newNode;
			
			// ���ο� ����� ���� ���� temp2�� ����
			newNode.next = temp2;
			
			// temp2�� ���� ���� ���ο� ��� ����
			if (temp2 != null) {
				
				temp2.prev = newNode;
				
			}
			
			// ���ο� ����� ���� ���� temp1 ����
			newNode.prev = temp1;
			
			size++;
			
			// ���ο� ����� ���� ��尡 ���ٸ� ���ο� ��尡 ������ ���
			// -> tail�� ����
			if (newNode.next == null) {
				tail = newNode;
			}
			
		}
		
	}
	
	// 4. ��� ã��
	Node node(int index) {
		
		// ����� �ε����� ��ü ��� ���� �ݺ��� ū�� ���� �� ���
		if (index < size / 2) {
			
			// head���� next�� �̿��� �ε����� �ش��ϴ� ��� ã��
			Node x = head;
			
			for (int i=0; i < index; i++) {
				
				x = x.next;
				
			}
			
			return x;
			
		} else {
			
			// tail���� prev�� �̿��ؼ� �ε����� �ش��ϴ� ��� ã��
			Node x = tail;
			
			for (int i=size-1; i > index; i--) {
				
				x = x.prev;
				
			}
			
			return x;
			
		}
		
	}
	
	// 5. ó�� ��� ����
	public Object removeFirst() {
		
		// ù ��° ��带 temp�� �����ϰ�, head�� ���� �ι�° ���� ����
		Node temp = head;
		
		head = temp.next;
		
		// �����͸� �����ϱ� ���� ������ ���� �ӽ� ������ ����
		Object returnData = temp.data;
		
		temp = null;
		
		// ����Ʈ ���� ��尡 �ִٸ� head�� ���� ��带 null�� ����
		if (head != null) {
			
			head.prev = null;
			
		}
		
		size--;
		
		return returnData;
		
	}
	
	// 6. Ư�� ��ġ ��� ����
	public Object remove(int k) {
		
		if (k == 0) {
			
			return removeFirst();
			
		}
		
		// k-1��° ��带 temp�� ����
		Node temp = node(k-1);
		
		// temp.next�� �����ϱ� ���� todoDeleted ������ ����
		Node todoDeleted = temp.next;
		
		// ���� ��� ��带 ���ῡ�� �и�
		temp.next = temp.next.next;
		
		if (temp.next != null) {
			
			// ������ ����� ���� ��带 ����
			temp.next.prev = temp;
			
		}
		
		// ������ ����� �����͸� �����ϱ� ���� returnData�� �����͸� ����
		Object returnData = todoDeleted.data;
		
		// ������ ��尡 tail�̾��ٸ� ���� ��带 tail�� ����
		if (todoDeleted == tail) {
			
			tail = temp;
			
		}
		
		// cur.next ����
		todoDeleted = null;
		size--;
		
		return returnData;
		
	}
	
	// 7. ������ ��� ����
	public Object remvoeLast() {
		
		return remove(size - 1);
		
	}
	
	// 8. �ε����� ������Ʈ ��������
	public Object get(int k) {
		
		Node temp = node(k);
		
		return temp.data;
		
	}
	
	// 9. Ž��
	public int indexOf(Object data) {
		
		// Ž�� ����� �Ǵ� ��带 temp�� ����
		Node temp = head;
		
		// Ž�� ����� �� ��° ������Ʈ�� �ִ� ���� �ǹ��ϴ� ������ index�� ���
		int index = 0;
		
		// Ž�� ���� Ž�� ��� �� ��
		while (temp.data != data) {
			
			temp = temp.next;
			index++;
			
			// temp�� ���� null�̶�� ���� �� �̻� Ž�� ����� ���ٴ� ��
			if (temp == null) {
				
				return -1;
				
			}
			
		}
		
		// Ž�� ����� ã�Ҵٸ� ����� �ε��� ���� ����
		return index;
		
	}
	
	// 10. �ݺ�
	public class ListIterator {
		
		private Node lastReturned;
		private Node next;
		private int nextIndex;
		
		ListIterator() {
			
			next = head;
			nextIndex = 0;
			
		}
		
		// �� �޼ҵ带 ȣ���ϸ� cursor�� �������� ���� cursor.next�� ����ȴ�.
		public Object next() {
			
			lastReturned = next;
			next = next.next;
			nextIndex++;
			
			return lastReturned.data;
			
		}
		
		// cursor�� ���� ���ٸ�, �ٽ� ���ؼ� �� �̻� next�� ���ؼ� ������ ��尡 ���� -> false ����
		// �̸� ���� next�� ȣ���ص� �Ǵ� ���� ������ �Ǵ��� �� ����
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
