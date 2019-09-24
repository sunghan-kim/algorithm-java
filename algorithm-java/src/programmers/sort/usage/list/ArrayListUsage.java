package programmers.sort.usage.list;

import java.util.ArrayList;

// https://edu.goorm.io/learn/lecture/41/%EB%B0%94%EB%A1%9C%EC%8B%A4%EC%8A%B5-%EC%83%9D%ED%99%9C%EC%BD%94%EB%94%A9-%EC%9E%90%EB%B0%94-java/lesson/39156/arraylist%EC%9D%98-%EC%82%AC%EC%9A%A9%EB%B2%95

public class ArrayListUsage {

	public static void main(String[] args) {
		
		ArrayList al = new ArrayList();
		
		al.add("one");
		al.add("two");
		al.add("three");
		
		// size()
		//  - ArrayList의 크기를 반환하는 메서드
		//	  (Array의 length 메서드와 동일한 기능)
		System.out.println("size : " + al.size());
		
		System.out.println("-------------------------------------");
		
		// get()
		//  - ArrayList의 특정 원소 추출
		for (int i=0; i < al.size(); i++) {
			
			System.out.println(al.get(i));
			
		}
		
		System.out.println("-------------------------------------");
		
		// ArrayList의 메서드 add는 인자로 어떤 형태의 값이 오는 지 알 수 없다.
		// 따라서 모든 데이터 타입의 조상인 Object 형식으로 데이터를 받는다.
		// 그러므로 get 메서드를 이용해 값을 꺼내도 Object 데이터 타입을 가지고 있으므로
		// "형변환" 작업을 해줘야 한다.
		for (int i=0; i < al.size(); i++) {
			
			// String val = al.get(i); <- 컴파일 오류 발생
			String val = (String) al.get(i);
			System.out.println(val);
			
		}
		
		System.out.println("-------------------------------------");
		
		// 하지만 위와 같이 형변환하는 것은 옛날 방식이다.
		// 이제는 아래와 같이 "제네릭"을 사용해야 한다.
		ArrayList<String> al2 = new ArrayList<String>();
		
		al2.add("one");
		al2.add("two");
		al2.add("three");
		
		for (int i=0; i < al2.size(); i++) {
			
			String val = al2.get(i);
			System.out.println(val);
			
		}
		
		// 제네릭을 사용하면 ArrayList 내에서 사용할 데이터 타입을 인스턴스를 생성할 때
		// 지정할 수 있기 때문에 데이터를 꺼낼 때 형변환을 하지 않아도 된다.
		
	}
	
}
