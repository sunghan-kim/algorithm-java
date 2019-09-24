package programmers.hash.usage.hashMap;

import java.util.HashMap;
import java.util.Map;

// https://blog.naver.com/PostView.nhn?blogId=yongyos&logNo=221478536324

/**
 * 
 * @author shkim
 * 
 * # [Java] MAP - getOrDefault 활용
 * 
 * 
 * public V getOrDefault(Object key, V defaultValue)
 * 
 *   - 찾는 key가 맵에 존재하면 찾는 key의 value 반환
 *   - 찾는 key가 맵에 없으면 value를 defaultValue로 초기화
 *
 */

public class HashMapUsage3 {

	public static void main(String[] args) {
		
		String[] arr1 = {"mislav", "stanko", "mislav", "ana"};
		String[] arr2 = {"stanko", "ana", "mislav"};
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (String a : arr1) map.put(a, map.getOrDefault(a, 0) + 1);
		
		System.out.println(map);
		
		// 중복된 값인 "mislav"는 찾고자 하는 키가 있으므로 1을 반환한 후
		// +1을 해서 2가 된 모습
		
	}
	
}
