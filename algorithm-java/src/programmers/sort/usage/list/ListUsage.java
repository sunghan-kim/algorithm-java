package programmers.sort.usage.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// https://mainia.tistory.com/2323



public class ListUsage {

	public static void main(String[] args) {
		
		// 1. add, get : 값 추가하고 꺼내기
		List listA = new ArrayList();
		
		listA.add("김삿갓");
		listA.add("홍아리");
		listA.add(new String("홍길동"));
		
		listA.add(1, "1번째 요소값");
		
		System.out.println("listA : " + listA);
		
		System.out.println("--------------------------------------");
		
		// 인덱스를 통한 조회
		String element0 = listA.get(0).toString();
		System.out.println("element0 : " + element0);
		
		String element1 = listA.get(1).toString();
		System.out.println("element1 : " + element1);
		
		String element2 = listA.get(2).toString();
		System.out.println("element2 : " + element2);
		
		System.out.println("--------------------------------------");
		
		// Iterator를 통한 전체 조회
		Iterator iterator = listA.iterator();
		
		while(iterator.hasNext()) {
			
			String element = (String) iterator.next();
			System.out.println("iterator's element : " + element);
			
		}
		
		System.out.println("--------------------------------------");
		
		// for-loop를 통한 전체 조회
		for (Object object : listA) {
			
			String element = (String) object;
			System.out.println("for-loop's element : " + element);
			
		}
		
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		
		// 2. add(index, value) : 중간에 값 넣기
		
		// 2.1 홍길동 앞에 값 추가 : indexOf() 메서드 이용
		int index = listA.indexOf("홍길동");
		listA.add(index, "홍길동 앞에 값 추가");
		
		System.out.println("--------------------------------------");
		
		// 2.2 존재 여부 확인 : contains() 메서드 이용
		System.out.println(listA.contains("홍길동"));
		
		
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		
		// 3. remvoe : 값 삭제
		
		//   - remove(Object element)
		//   - remove(int index)
		
		System.out.println(listA.remove(0));
		System.out.println(listA.remove("홍길동"));
		
		
	}
	
}
