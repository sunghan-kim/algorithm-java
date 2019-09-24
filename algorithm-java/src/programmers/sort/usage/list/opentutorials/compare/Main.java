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
		
		
		
		// 1. addFirst() ��
		
		// 1.1 ArrayList
		//  - �ϳ��� �� �ڷ� ���� ���� �� ó���� ����
		a.addFirst(5); 
		
		// 1.2 LinkedList
		//  - ���� �߰��� ��带 head�� �����ϰ�, ������ head ��带 ���ο� ����� next�� �����ϱ⸸ �ϸ� ��
		l.addFirst(5); 
		
		
		// -> addFirst()�� ��� LinkedList�� ������ �� ����ϴ�!
		
		
		// 2. get() ��
		
		// 2.1 ArrayList
		//  - �ε����� ���� �޸𸮿� � ��ġ�� �����Ͱ� �ִ� �� �˰� �ִ� �ּҷ� ����
		//  - random access �޸��� Ư�� �� ��� �ּҷ� �����ϵ��� ������ �ӵ��� ����޴´�. (������ ���� ó�� �ӵ�)
		System.out.println(a.get(2)); 
		
		// 2.2 LinkedList
		//  - ó������ ã�ư��� �Ѵ�. (next, next, ...) 
		System.out.println(l.get(2));
		
		// -> get() �� ��� ArrayList�� ������ �� ����ϴ�!
		
		
		// 3. ListIterator() ��
		
		// 3.1 ArrayList
		ArrayList.ListIterator ai = a.listIterator();
		
		while (ai.hasNext()) {
			
			if ((int)ai.next() == 20) {
				
				ai.add(25); // �߰� ��� �߰� �� ���� ��带 ���� �ڷ� �о�� �Ѵ�.
				
			}
			
		}
		
		//  - ���� ArrayList�� �߰� ������ �迭�� ũ�� (ex. 100)�� �����Ǿ� �ִ�. (100�� �̻� �߰� �Ұ�)
		//  - Java���� ������ ũ�� �̻����� ArrayList�� �����Ͱ� �߰��Ǹ� 2���� ���������� Ȯ���ϰ� �ȴ�.
		//  - ���� ���� Ư���� Java���� ������ �巯���� �ʴ´�.
		//  - �̷��� ���� "Dynamic Array(���� �迭)"�̶�� �Ѵ�.
		
		
		// 3.2 LinkedList
		LinkedList.ListIterator li = l.listIterator();
		
		while (li.hasNext()) {
			
			if ((int)li.next() == 20) {
				
				li.add(25); // �߰� ��� �߰� �� ���� ����� next�� �߰��� ����, �߰��� ����� next�� 20 ���� ���� ���� �����ϸ� ��
				
			}
			
		}
		
		//  - LinkedList�� �޸𸮰� ����ϴ� ������ ��带 �߰��� �� �ִ�. 
		//  - ���� ������ LinkedList�� java.collections Ŭ������ LinkedList�ʹ� �ణ �ٸ���.
		//  - java.collections �����ӿ�ũ�� LinkedList�� "Doubly Linked List"�� ������ ���̴�.
		//  - ���⼭ ������ LinkedList�� �ܹ��� LinkeList�̴�.
		
	}
	
}
