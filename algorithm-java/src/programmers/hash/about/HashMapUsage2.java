package programmers.hash.about;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// http://tech.javacafe.io/2018/12/03/HashMap/

/**
 * 
 * @author shkim
 * 
 * # 자바 HashMap을 효과적으로 사용하는 방법
 * 
 * 
 *
 */

public class HashMapUsage2 {

	
	public static void main(String[] args) {
		
		// 1. HashMap 기본
		
		
		// 1.1 객체 생성
		
		// java 11에서 map을 만드는 방법
		//var productPrice = new HashMap<String, Double>();
		
		// java 8에서 map을 만드는 방법
		Map<String, Double> productPrice = new HashMap<>();
		
		
		// 1.2 map.put()
		
		// add value
		productPrice.put("Rice", 6.9);
		productPrice.put("Flour", 3.9);
		productPrice.put("Sugar", 4.9);
		productPrice.put("Milk", 3.9);
		productPrice.put("Egg", 1.9);
		
		
		// 1.3 map.get()
		
		//get value
		Double egg = productPrice.get("Egg");
		System.out.println("The price of Egg is: " + egg);
		
		System.out.println("-------------------------------");
		
		// 2. HashMap에서 모든 Key와 Value를 print 하기
		
		// 2.1 모든 key를 print하는 방법
		Set<String> keys = productPrice.keySet();
		
		for (String key : keys) {
			
			System.out.println(key);
			
		}
		
		// or
		
		// keys.forEach(key -> System.out.println(key));
		
		System.out.println("-------------------------------");
		
		// 2.2 모든 value를 print하는 방법
		Collection<Double> values = productPrice.values();
		
		for (Double value : values) {
			
			System.out.println(value);
			
		}
		
		System.out.println("-------------------------------");
		
		// 2.3 모든 key와 value를 같이 print 하는 방법
		Set<Map.Entry<String, Double>> entries = productPrice.entrySet();
		
		for (Map.Entry<String, Double> entry : entries) {
			
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			
		}
		
		System.out.println("-------------------------------");
		
		
		// 3. Key가 존재하는 지 알고 싶은 경우
		
		
		// 3.1 피보나치 수열
		//  - 재귀를 보여주는 유명한 수역
		//  - 피보나치 수열 공식 : f(n) = f(n-1) + f(n-2)
		
		//  - Fibonacci.java 참고
		
	}
	
	
}
