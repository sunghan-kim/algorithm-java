package programmers.stackAndQueue.usage;

import java.util.Stack;

// http://tcpschool.com/java/java_collectionFramework_stackQueue

/**
 * 
 * @author shkim
 * 
 * 1. Stack<E> Ŭ����
 * 
 *  - Stack Ŭ������ List �÷��� Ŭ������ Vector Ŭ������ ��ӹ޾�,
 *    �������� ���� �޸� ������ Ŭ������ ����
 *    
 *  - ���� �޸� ������ ���� �޸� ������ �����͸� �����ϸ鼭
 *    ���Լ���(LIFO)�� �ø�ƽ�� ������ �ڷ� �����̴�.
 *  - ��, ���� ���߿� �����(push) �����Ͱ� ���� ���� ����(pop)�Ǵ� ����
 *  
 * 
 * 2. ����
 * 
 *  Stack<Integer> st = new Stack<Integer>();
 *  
 * 
 * 3. �޼ҵ�
 * 
 *  - Stack Ŭ������ ���� �޸� ������ ǥ���ϱ� ����
 *    Vector Ŭ������ �޼ҵ带 5���� ��ӹ޾� ����Ѵ�.
 *
 *   3.1 boolean empty()
 *   
 *     - �ش� ������ ��������� true ��ȯ
 *     - ������� ������ false ��ȯ
 *     
 *   3.2 E peek()
 *    
 *     - �ش� ������ ���� ��ܿ� �ִ�(���� ���������� �����) ��Ҹ� ��ȯ
 *     
 *   3.3 E pop()
 *   
 *     - �ش� ������ ���� ��ܿ� �ִ�(���� ���������� �����) ��Ҹ� ��ȯ�ϰ�,
 *       �ش� ��Ҹ� ���ÿ��� ������
 *       
 *   3.4 E push(E item)
 *   
 *     - �ش� ������ ���� ��ܿ� ���޵� ��Ҹ� ����
 *     
 *   3.5 int search(Object o)
 *   
 *     - �ش� ���ÿ��� ���޵� ��ü�� �����ϴ� ��ġ�� �ε����� ��ȯ
 *     - �̶� �ε����� ���� ��ܿ� �ִ�(���� ���������� �����) ����� ��ġ����
 *       0�� �ƴ� 1���� ������
 *
 */
public class StackUsage {

	public static void main(String[] args) {
		
		// ���� ����
		Stack<Integer> st = new Stack<Integer>();
		
		// push() �޼ҵ带 �̿��� ����� ����
		st.push(4);
		st.push(3);
		st.push(2);
		st.push(1);
		
		// peek() �޼ҵ带 �̿��� ����� ��ȯ
		System.out.println(st.peek());
		System.out.println(st);
		
		// pop() �޼ҵ带 �̿��� ����� ��ȯ �� ����
		System.out.println(st.pop());
		System.out.println(st);
		
		// search() �޼ҵ带 �̿��� ����� ��ġ �˻�
		System.out.println(st.search(4));
		System.out.println(st.search(3));
		
	}
	
}
