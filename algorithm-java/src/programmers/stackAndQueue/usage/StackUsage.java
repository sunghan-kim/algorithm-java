package programmers.stackAndQueue.usage;

import java.util.Stack;

// http://tcpschool.com/java/java_collectionFramework_stackQueue

/**
 * 
 * @author shkim
 * 
 * 1. Stack<E> 클래스
 * 
 *  - Stack 클래스는 List 컬렉션 클래스의 Vector 클래스를 상속받아,
 *    전형적인 스택 메모리 구조의 클래스를 제공
 *    
 *  - 스택 메모리 구조는 선형 메모리 공간에 데이터를 저장하면서
 *    후입선출(LIFO)의 시멘틱을 따르는 자료 구조이다.
 *  - 즉, 가장 나중에 저장된(push) 데이터가 가장 먼저 인출(pop)되는 구조
 *  
 * 
 * 2. 문법
 * 
 *  Stack<Integer> st = new Stack<Integer>();
 *  
 * 
 * 3. 메소드
 * 
 *  - Stack 클래스는 스택 메모리 구조를 표현하기 위해
 *    Vector 클래스의 메소드를 5개만 상속받아 사용한다.
 *
 *   3.1 boolean empty()
 *   
 *     - 해당 스택이 비어있으면 true 반환
 *     - 비어있지 않으면 false 반환
 *     
 *   3.2 E peek()
 *    
 *     - 해당 스택의 제일 상단에 있는(제일 마지막으로 저장된) 요소를 반환
 *     
 *   3.3 E pop()
 *   
 *     - 해당 스택의 제일 상단에 있는(제일 마지막으로 저장된) 요소를 반환하고,
 *       해당 요소를 스택에서 제거함
 *       
 *   3.4 E push(E item)
 *   
 *     - 해당 스택의 제일 상단에 전달된 요소를 삽입
 *     
 *   3.5 int search(Object o)
 *   
 *     - 해당 스택에서 전달된 객체가 존재하는 위치의 인덱스를 반환
 *     - 이때 인덱스는 제일 상단에 있는(제일 마지막으로 저장된) 요소의 위치부터
 *       0이 아닌 1부터 시작함
 *
 */
public class StackUsage {

	public static void main(String[] args) {
		
		// 스택 생성
		Stack<Integer> st = new Stack<Integer>();
		
		// push() 메소드를 이용한 요소의 저장
		st.push(4);
		st.push(3);
		st.push(2);
		st.push(1);
		
		// peek() 메소드를 이용한 요소의 반환
		System.out.println(st.peek());
		System.out.println(st);
		
		// pop() 메소드를 이용한 요소의 반환 및 제거
		System.out.println(st.pop());
		System.out.println(st);
		
		// search() 메소드를 이용한 요소의 위치 검색
		System.out.println(st.search(4));
		System.out.println(st.search(3));
		
	}
	
}
