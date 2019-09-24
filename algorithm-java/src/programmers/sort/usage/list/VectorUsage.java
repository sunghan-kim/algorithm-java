package programmers.sort.usage.list;

import java.util.Vector;

// https://hyeonstorage.tistory.com/208


/**
 * 
 * @author shkim
 * 
 * 
 * # Vector
 * 
 *   - 가변길이 배열
 *   - 즉, Vector 클래스는 객체에 대한 참조값을 저장하는 배열이므로 
 *     다양한 객체들이 하나의 Vector에 저장될 수 있고 길이도 필요에 따라 증감할 수 있다는 점이 배열과 다른 점이다.
 *
 */

public class VectorUsage {

	public static void main(String[] args) {
		
		// Vector 객체에 String 객체를 담을 수 있으며, 
		// 용량은 3 이며, size가 용량을 초과했을 때, 3의 크기만큼 용량이 증가한다. 
		// (매개변수를 지정하지 않으면 기본 용량 10, 증가 용량 10이다.)
		Vector<String> vector = new Vector<String>(3);
		
		System.out.println("vector의 크기 : " + vector.size());
		System.out.println("vector의 용량 : " + vector.capacity());
		
		// vector.addElement() 로 String 객체를 4개 대입
		vector.addElement("하이언");
		vector.addElement("아이유");
		vector.addElement("버스커");
		vector.addElement("소녀시대");
		
		System.out.println("데이터 삽입 후 vector의 크기 : " + vector.size());
		System.out.println("데이터 삽입 후 vector의 용량 : " + vector.capacity());
		
		// size=4, capacity=6로 증가
		// 이것은 기본 용량 3에서 3보다 많은 객체가 대입되어, 용량이 3만큼 동적으로 증가한 것
		
		
		
	}
	
}
