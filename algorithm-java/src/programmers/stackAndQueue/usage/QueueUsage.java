package programmers.stackAndQueue.usage;

import java.util.LinkedList;
import java.util.Queue;

// http://tcpschool.com/java/java_collectionFramework_stackQueue

/**
 * 
 * @author shkim
 * 
 * 1. Queue<E> 인터페이스
 * 
 *  - 클래스로 구현된 스택과는 달리 자바에서 큐 메모리 구조는 별도의 인터페이스 형태로 제공된다.
 *  - 이러한 Queue 인터페이스를 상속받는 하위 인터페이스는 다음과 같다.
 *  
 *    1. Deque<E>
 *    2. BlockingDeque<E>
 *    3. BlockingQueue<E>
 *    4. TransferQueue<E>
 *    
 *  - 따라서 Queue 인터페이스를 직간접적으로 구현한 클래스는 상당히 많다.
 *  - 그 중에서도 Deque 인터페이스를 구현한 LinkedList 클래스가 큐 메모리 구조를 구현하는 데
 *    가장 많이 사용된다.
 *    
 *    
 * 2. 큐 메모리 구조
 * 
 *  - 큐 메모리 구조는 선형 메모리 공간에 데이터를 저장하면서
 *    선입선출(FIFO)의 시멘틱을 따르는 자료 구조이다.
 *  - 즉, 가장 먼저 저장된(push) 데이터가 가장 먼저 인출(pop)되는 구조이다.
 *  
 *  
 * 3. 문법
 * 
 *   LinkedList<String> qu = new LinkedList<String>();
 *   Queue<String> qu = new LinkedList<String>();
 *   
 *   
 * 4. 메소드
 * 
 *  - Queue 인터페이스는 큐 메모리 구조를 표현하기 위해,
 *    다음과 같은 Collection 인터페이스 메소드만을 상속받아 사용한다.
 *    
 *   4.1 boolean add(E e)
 *   
 *     - 해당 큐의 맨 뒤에 전달된 요소를 삽입함
 *     - 만약 삽입에 성공하면 true를 반환
 *     - 큐에 여유 공간이 없어 삽입이 실패하면 IllegalStateException을 발생시킴
 *   
 *   4.2 E element()
 *   
 *     - 해당 큐의 맨 앞에 있는(제일 먼저 저장된) 요소를 반환
 *     
 *   4.3 boolean offer(E e)
 *   
 *     - 해당 큐의 맨 뒤에 전달된 요소를 삽입함
 *     
 *   4.4. E peek()
 *   
 *     - 해당 큐의 맨 앞에 있는(제일 먼저 저장된) 요소를 반환
 *     - 만약 큐가 비어있으면 null을 반환
 *     
 *   4.5 E poll()
 *   
 *     - 해당 큐의 맨 앞에 있는(제일 먼저 저장된) 요소를 반환하고,
 *       해당 요소를 큐에서 제거
 *     - 만약 큐가 비어있으면 null을 반환
 *     
 *   4.6 E remove()
 *   
 *     - 해당 큐의 맨 앞에 있는(제일 먼저 저장된) 요소를 제거
 *   
 *
 */
public class QueueUsage {

	public static void main(String[] args) {
		
		// 큐 생성
		Queue<String> qu = new LinkedList<String>();
		
		// add() 메소드를 이용한 요소 저장
		qu.add("넷");
		qu.add("둘");
		qu.add("셋");
		qu.add("하나");
		
		// peek() 메소드를 이용한 요소 반환
		System.out.println(qu.peek());
		System.out.println(qu);
		
		// poll() 메소드를 이용한 요소의 반환 및 제거
		System.out.println(qu.poll());
		System.out.println(qu);
		
		// remove() 메소드를 이용한 요소 제거
		qu.remove("하나");
		System.out.println(qu);
		
	}
	
}
