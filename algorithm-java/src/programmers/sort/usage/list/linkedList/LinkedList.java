package programmers.sort.usage.list.linkedList;

// https://opentutorials.org/module/1335/8857

public class LinkedList {

	/**
	 * 1. ���(���ؽ�) ����
	 * 
	 *   - LinkedList���� ���� �߿��� ���� �ٷ� ����� ����
	 *   - ���� ������ �����Ͱ� ����Ǵ� �׸��� ���� ���̱� ������ 
	 *     �̰ͺ��� ������ ����
	 *   - �ڹٴ� ��ü���� ����̱� ������ ���� ��ü�� ����� �� ���� ����̴�.
	 *   - �׸��� ��� ��ü�� ����Ʈ�� ���� ��ǰ�̱� ������ �ܺο��� ������� �ʴ� ���� ����.
	 *     (private���� ����)
	 *   
	 *   - head : ù ��° ��带 �����ϴ� ������
	 *   - tail : ������ ��带 ����
	 *   - size : ����� ũ��
	 *   
	 *   - ��带 ������ ������ �� ������ �����ؾ� �Ѵ�.
	 *   -  tail�̳� size�� ������ ��带 ã�ų� ����� ���� �� �� ������ Ƚ���� ȹ�������� �ٿ��ش�.
	 *   
	 *   - ��ü Node�� ���������� data�� next ������ ������ �ִ�.
	 *     - data : ����� ��
	 *     - next : ���� ��带 ����Ű�� ������
	 *   
	 */
	
	// 1.1 ù ��° ��带 ����Ű�� �ʵ�
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node {
		
		// 1.2 �����Ͱ� ����� �ʵ�
		private Object data;
		
		// 1.3 ���� ��带 ����Ű�� �ʵ�
		private Node next;
		
		public Node(Object input) {
			
			this.data = input;
			this.next = null;
			
		}
		
		// 1.4 ����� ������ ���� ����ؼ� Ȯ���غ� �� �ִ� ���
		public String toString() {
			
			return String.valueOf(this.data);
			
		}
		
	}
	
	/**
	 * 2. ������ �߰�
	 * 
	 */
	
	/**
	 * 
	 * 2.1 ���ۿ� �߰�
	 * 
	 */
	public void addFirst(Object input) {
		
		// 2.1.1 ��� ����
		Node newNode = new Node(input);
		
		// 2.1.2 ���ο� ����� ���� ���� �ص带 ����
		newNode.next = head;
		
		// 2.1.3 ���� ���ο� ��带 ����
		head = newNode;
		size++;
		
		if (head.next == null) {
			
			tail = head;
			
		}
		
	}
	
	/**
	 * 
	 * 2.2 ���� �߰�
	 * 
	 *   - ����Ʈ�� ���� �����͸� �߰��� ���� tail�� ����մϴ�. 
	 *   - tail�� ���̵� ������ �����մϴ�. 
	 *   - ������ tail�� ���ٸ� ������ ��带 ã�ƾ� �� ���Դϴ�.
	 *   - ����Ʈ�� ���� �����͸� �߰��ϴ� �۾��� ���� �ִ� �۾��̰�, 
	 *     ������ ��带 ã�� �۾��� ù ������ ������ ������ ���������� Ž���� �ؾ� �ϱ� ������ 
	 *     �־��� ��Ȳ�̶�� �� �� �ֽ��ϴ�. 
	 *   - �׷��� �츮 ���������� tail�� ����մϴ�.
	 * 
	 */
	public void addLast(Object input) {
		
		// 2.2.1 ��� ����
		Node newNode = new Node(input);
		
		// 2.2.2 ����Ʈ�� ��尡 ���ٸ� ù��° ��带 �߰��ϴ� �޼��� ���
		if (size == 0) {
			
			addFirst(input);
			
		} else {
			
			// 2.2.3 ������ ����� ���� ���� ������ ��带 ����
			tail.next = newNode;
			
			// 2.2.4 ������ ��� ����
			tail = newNode;
			
			// 2.2.5 ������Ʈ ���� 1 ����
			size++;
			
		}
		
	}
	
	/**
	 * 
	 * 2.3 �߰��� �߰�
	 * 
	 */
	
	// 2.3.1 Ư�� ��ġ�� ��带 ã�Ƴ��� ���
	Node node(int index) {
		
		Node x = head;
		
		for (int i=0; i < index; i++) {
			
			x = x.next;
			
		}
		
		return x;
		
	}
	
	// 2.3.2 node �޼ҵ� �̿� Ư�� ��ġ�� ��� �߰�
	public void add(int k, Object input) {
		
		// 2.3.2.1 k=0 -> ù ��° ��忡 �߰� -> addFirst ���
		if (k == 0) {
			
			addFirst(input);
			
		} else {
			
			Node temp1 = node(k-1);
			
			// 2.3.2.2 k��° ��带 temp2�� ����
			Node temp2 = temp1.next;
			
			// 2.3.2.3 ���ο� ��� ����
			Node newNode = new Node(input);
			
			// 2.3.2.4 temp1�� ���� ���� ���ο� ��带 ����
			temp1.next = newNode;
			
			// 2.3.2.5 ���ο� ����� ���� ���� temp2�� ����
			newNode.next = temp2;
			
			// 2.3.2.6 ������Ʈ ���� ����
			size++;
			
			// 2.3.2.7 ���ο� ����� ���� ��尡 ���ٸ� ���ο� ��尡 ������ ���
			//         -> tail ����
			if (newNode.next == null) {
				
				tail = newNode;
				
			}
			
		}
		
	}
	
	/**
	 * 
	 * 3. ���
	 * 
	 *   - ����� �����Ͱ� �߰� �ǰ� �ִ��� Ȯ���ϴ� ����� �ʿ�
	 *   - LinkedList�� toString �޼ҵ带 �����ؼ� ����Ʈ�� ����� ��������� �ִ����� Ȯ���ϴ� �ڵ带 �ۼ��غ��ô�.
	 * 
	 */
	
	public String toString() {
		
		// 3.1 ��尡 ������ [] ����
		if (head == null) {
			
			return "[]";
			
		}
		
		// 3.2 Ž�� ����
		Node temp = head;
		String str = "[";
		
		// 3.3 ���� ��尡 ���� ������ �ݺ��� ����
		//     (������ ���� ���� ��尡 ���� ������ �Ʒ� ������ ������ ���� ���ܵ�
		while(temp.next != null) {
			
			str += temp.data + ",";
			temp = temp.next;
			
		}
		
		// 3.4 ������ ��带 ��°���� ����
		str += temp.data;
		
		return str+"]";
		
	}
	
	/**
	 * 
	 * 4. ����
	 * 
	 */
	
	/**
	 * 
	 * 4.1 ó�� ��� ����
	 * 
	 */
	public Object removeFirst() {
		
		// 4.1.1 ù��° ��带 temp�� �����ϰ� head�� ���� �ι�° ���� ����
		Node temp = head;
		head = temp.next;
		
		// 4.1.2 �����͸� �����ϱ� ���� ������ ���� �ӽ� ������ ����
		Object returnData = temp.data;
		temp = null;
		size--;
		
		return returnData;
		
	}
	
	/**
	 * 
	 * 4.2 �߰��� �����͸� ����
	 * 
	 */
	public Object remove(int k) {
		
		// 4.2.1 k=0 -> ù��° ��� ���� -> removeFirst() ȣ��
		if (k==0) {
			removeFirst();
		}
		
		// 4.2.2 k-1��° ��带 temp�� ������ ����
		Node temp = node(k-1);
		
		// 4.2.3 ���� ��带 todoDeleted�� ���
		//		 (���� ��带 ���� �����ϸ� ���� �� ���� ���� �� ��带 ������ �� ����.
		Node todoDeleted = temp.next;
		
		// 4.2.4 ���� �� ����� ���� ���� ���� �� ��带 ����
		temp.next = temp.next.next;
		
		// 4.2.5 ������ �����͸� �����ϱ� ���� returnData�� �����͸� ����
		Object returnData = todoDeleted.data;
		
		if (todoDeleted == tail) {
			
			tail = temp;
			
		}
		
		// 4.2.6 cur.next�� ����
		todoDeleted = null;
		
		size--;
		
		return returnData;
		
	}
}
