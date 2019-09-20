package programmers.hash.about;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

// http://tech.javacafe.io/2018/12/03/HashMap/

/**
 * 
 * @author shkim
 * 
 * # 피보나치 수열 (HashMapUsage2.java의 3.1번)
 *
 */

public class Fibonacci {

	private Map<Integer, BigInteger> memoizeHashMap = new HashMap<>();
	
	{
		
		memoizeHashMap.put(0, BigInteger.ZERO);
		memoizeHashMap.put(1, BigInteger.ONE);
		memoizeHashMap.put(2, BigInteger.ONE);
		
	}
	
	private BigInteger fibonacci(int n) {
		
		if (memoizeHashMap.containsKey(n)) {
			
			return memoizeHashMap.get(n);
			
		} else {
			
			BigInteger result = fibonacci(n - 1).add(fibonacci(n - 2));
			
			memoizeHashMap.put(n, result);
			
			return result;
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Fibonacci fibonacci = new Fibonacci();
		
		for (int i=0; i < 100; i++) {
			
			System.out.println(i + " : " + fibonacci.fibonacci(i));
			
			System.out.println("----------------------------");
			
		}
		
		
	}
	
}
