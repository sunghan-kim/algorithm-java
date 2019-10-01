package programmers.stackAndQueue.usage;

import java.util.LinkedList;
import java.util.Queue;

// http://tcpschool.com/java/java_collectionFramework_stackQueue

/**
 * 
 * @author shkim
 * 
 * 1. Queue<E> �������̽�
 * 
 *  - Ŭ������ ������ ���ð��� �޸� �ڹٿ��� ť �޸� ������ ������ �������̽� ���·� �����ȴ�.
 *  - �̷��� Queue �������̽��� ��ӹ޴� ���� �������̽��� ������ ����.
 *  
 *    1. Deque<E>
 *    2. BlockingDeque<E>
 *    3. BlockingQueue<E>
 *    4. TransferQueue<E>
 *    
 *  - ���� Queue �������̽��� ������������ ������ Ŭ������ ����� ����.
 *  - �� �߿����� Deque �������̽��� ������ LinkedList Ŭ������ ť �޸� ������ �����ϴ� ��
 *    ���� ���� ���ȴ�.
 *    
 *    
 * 2. ť �޸� ����
 * 
 *  - ť �޸� ������ ���� �޸� ������ �����͸� �����ϸ鼭
 *    ���Լ���(FIFO)�� �ø�ƽ�� ������ �ڷ� �����̴�.
 *  - ��, ���� ���� �����(push) �����Ͱ� ���� ���� ����(pop)�Ǵ� �����̴�.
 *  
 *  
 * 3. ����
 * 
 *   LinkedList<String> qu = new LinkedList<String>();
 *   Queue<String> qu = new LinkedList<String>();
 *   
 *   
 * 4. �޼ҵ�
 * 
 *  - Queue �������̽��� ť �޸� ������ ǥ���ϱ� ����,
 *    ������ ���� Collection �������̽� �޼ҵ常�� ��ӹ޾� ����Ѵ�.
 *    
 *   4.1 boolean add(E e)
 *   
 *     - �ش� ť�� �� �ڿ� ���޵� ��Ҹ� ������
 *     - ���� ���Կ� �����ϸ� true�� ��ȯ
 *     - ť�� ���� ������ ���� ������ �����ϸ� IllegalStateException�� �߻���Ŵ
 *   
 *   4.2 E element()
 *   
 *     - �ش� ť�� �� �տ� �ִ�(���� ���� �����) ��Ҹ� ��ȯ
 *     
 *   4.3 boolean offer(E e)
 *   
 *     - �ش� ť�� �� �ڿ� ���޵� ��Ҹ� ������
 *     
 *   4.4. E peek()
 *   
 *     - �ش� ť�� �� �տ� �ִ�(���� ���� �����) ��Ҹ� ��ȯ
 *     - ���� ť�� ��������� null�� ��ȯ
 *     
 *   4.5 E poll()
 *   
 *     - �ش� ť�� �� �տ� �ִ�(���� ���� �����) ��Ҹ� ��ȯ�ϰ�,
 *       �ش� ��Ҹ� ť���� ����
 *     - ���� ť�� ��������� null�� ��ȯ
 *     
 *   4.6 E remove()
 *   
 *     - �ش� ť�� �� �տ� �ִ�(���� ���� �����) ��Ҹ� ����
 *   
 *
 */
public class QueueUsage {

	public static void main(String[] args) {
		
		// ť ����
		Queue<String> qu = new LinkedList<String>();
		
		// add() �޼ҵ带 �̿��� ��� ����
		qu.add("��");
		qu.add("��");
		qu.add("��");
		qu.add("�ϳ�");
		
		// peek() �޼ҵ带 �̿��� ��� ��ȯ
		System.out.println(qu.peek());
		System.out.println(qu);
		
		// poll() �޼ҵ带 �̿��� ����� ��ȯ �� ����
		System.out.println(qu.poll());
		System.out.println(qu);
		
		// remove() �޼ҵ带 �̿��� ��� ����
		qu.remove("�ϳ�");
		System.out.println(qu);
		
	}
	
}
