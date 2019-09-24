package programmers.hash.usage.hashMap;

import java.util.HashMap;
import java.util.Map;

// https://blog.naver.com/PostView.nhn?blogId=yongyos&logNo=221478536324

/**
 * 
 * @author shkim
 * 
 * # [Java] MAP - getOrDefault Ȱ��
 * 
 * 
 * public V getOrDefault(Object key, V defaultValue)
 * 
 *   - ã�� key�� �ʿ� �����ϸ� ã�� key�� value ��ȯ
 *   - ã�� key�� �ʿ� ������ value�� defaultValue�� �ʱ�ȭ
 *
 */

public class HashMapUsage3 {

	public static void main(String[] args) {
		
		String[] arr1 = {"mislav", "stanko", "mislav", "ana"};
		String[] arr2 = {"stanko", "ana", "mislav"};
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (String a : arr1) map.put(a, map.getOrDefault(a, 0) + 1);
		
		System.out.println(map);
		
		// �ߺ��� ���� "mislav"�� ã���� �ϴ� Ű�� �����Ƿ� 1�� ��ȯ�� ��
		// +1�� �ؼ� 2�� �� ���
		
	}
	
}
