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
 * # �ڹ� HashMap�� ȿ�������� ����ϴ� ���
 * 
 * 
 *
 */

public class HashMapUsage2 {

	
	public static void main(String[] args) {
		
		// 1. HashMap �⺻
		
		
		// 1.1 ��ü ����
		
		// java 11���� map�� ����� ���
		//var productPrice = new HashMap<String, Double>();
		
		// java 8���� map�� ����� ���
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
		
		// 2. HashMap���� ��� Key�� Value�� print �ϱ�
		
		// 2.1 ��� key�� print�ϴ� ���
		Set<String> keys = productPrice.keySet();
		
		for (String key : keys) {
			
			System.out.println(key);
			
		}
		
		// or
		
		// keys.forEach(key -> System.out.println(key));
		
		System.out.println("-------------------------------");
		
		// 2.2 ��� value�� print�ϴ� ���
		Collection<Double> values = productPrice.values();
		
		for (Double value : values) {
			
			System.out.println(value);
			
		}
		
		System.out.println("-------------------------------");
		
		// 2.3 ��� key�� value�� ���� print �ϴ� ���
		Set<Map.Entry<String, Double>> entries = productPrice.entrySet();
		
		for (Map.Entry<String, Double> entry : entries) {
			
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			
		}
		
		System.out.println("-------------------------------");
		
		
		// 3. Key�� �����ϴ� �� �˰� ���� ���
		
		
		// 3.1 �Ǻ���ġ ����
		//  - ��͸� �����ִ� ������ ����
		//  - �Ǻ���ġ ���� ���� : f(n) = f(n-1) + f(n-2)
		
		//  - Fibonacci.java ����
		
	}
	
	
}
