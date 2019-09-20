package programmers.hash.about;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// https://vaert.tistory.com/107

/**
 * 
 * @author shkim
 * 
 * # HashMap 함수 제대로 알고 사용하기
 * 
 * 
 * 1. HashMap이란?
 * 
 *   - HashMap은 Map을 구현
 *   - Key와 value를 묶어 하나의 entry로 저장한다는 특징을 가짐
 *   - 그리고 hashing을 사용하기 때문에 많은 양의 데이터를 검색하는데 뛰어난 성능을 보임
 *   
 *   - Map 인터페이스의 한 종류
 *   - ("Key", value)로 이뤄져 있다.
 *   - key 값은 중복 불가능
 *   - value는 중복 가능 (value에 null값도 사용 가능)
 *   - 멀티쓰레드에서 동시에 HashMap을 건드려 Key-value값을 사용하면 문제가 될 수 있다.
 *     (멀티쓰레드에서는 HashTable을 사용)
 *     
 *     
 * 2. HashMap 생성자 / 메서드
 * 
 *   2.1 HashMap()
 *   
 *     - HashMap 객체 생성
 *     
 *     ex) HashMap<String , Integer> map = new HashMap<String , Integer>();
 *     ex) Map<String, Integer> map = new HashMap<String, integer>();
 *     
 *     
 *   2.2 HashMap(int initialCapacity)
 *   
 *     - 지정된 값을 초기 용량으로 하는 HashMap객체를 생성한다.
 *     
 *     
 *   2.3 HashMap(int initlalCapacity, float loadFactory)
 *   
 *     - 지정된 값을 초기용량과 load factory의 HashMap 객체를 생성한다.
 *     
 *     
 *   2.4 HashMap(Map m)
 *     
 *     - 주어진 Map에 저장된 모든 요소를 포함하는 HashMap을 생성한다.
 *     
 *     
 *   2.5 void clear()
 *   
 *     - HashMap에 저장된 모든 객체를 제거한다.
 *     
 *     ex) map.clear();
 *     
 *     
 *   2.6 Object clone()
 *     
 *     - 현재 HashMap을 복제하여 반환한다.
 *     
 *     ex) newmap = (HashMap)map.clone();
 *     
 *     
 *   2.7 boolean containsKey(Object Key)
 *   
 *     - HashMap에 지정된 키(Key)가 포함되어 있는 지 알려준다.
 *     
 *     
 *   2.8 boolean containsValue(Object value)
 *    
 *     - HashMap에 지정된 값(Value)가 포함되어 있는 지 알려준다.
 *     
 *     
 *   2.9 Set entrySet()
 *   
 *     - HashMap에 저장된 Key-Value 값을 엔트리(키와 값을 결합)의 형태로 Set에 저장하여 반환
 *     
 *     ex) map.put("A", 1);
 *     	   map.put("B", 2);
 *         map.put("C", 3);
 *         
 *         Set set = map.entrySet();
 *         System.out.println("set values are" + set);
 *         
 *         (result) set values: [A=1,B=2,C=3]
 *         
 *  
 *   2.10 Object get(Object key)
 *   
 *     - 지정된 Key의 값을 반환한다.
 *     
 *     ex) map.put("A", 1);
 *     	   map.put("B", 2);
 *         map.put("C", 3);
 *         
 *         String val = (String)map.get("B");
 *         System.out.println("Value for key B is: " + val);
 *         
 *         (result) Value for key B is 2
 *         
 *         
 *   2.11 boolean isEmpty
 *   
 *     - HashMap이 비어있는 지 확인한다.
 *     
 *     ex) boolean val = map.isEmpty();
 *     
 *     
 *   2.12 Set keySet()
 *   
 *     - HashMap에 저장된 모든 키가 저장된 Set을 반환한다.
 *     
 *     ex) map.put("A", 1);
 *     	   map.put("B", 2);
 *         map.put("C", 3);
 *         
 *         Set keyset = map.KeySet();
 *         System.out.println("Key set values are" + keyset);
 *         
 *         (result) Key set values are [A,B,C]
 *         
 *         
 *   2.13 Object put(Object Key, Object Value)
 *   
 *     - HashMap에 키와 값을 저장
 *     
 *     ex) map.put("A", "aaa");
 *     	   map.put("B", "bbb");
 *         map.put("C", "ccc");
 *   
 *   
 *   2.14 void putAll(Map m)
 *   
 *     - Map에 해당하는 모든 요소를 HashMap에 저장한다.
 *     
 *     
 *   2.15 Object remove(Object key)
 *   
 *     - HashMap에 지정된 키로 저장된 값을 제거한다.
 *     
 *     ex) map.remove("key");
 *     
 *     
 *   2.16 int size()
 *   
 *     - HashMap에 저장된 요소의 개수를 반환
 *     
 *     
 *   2.17 Collection values()
 *   
 *     - HashMap에 저장된 모든 값을 컬렉션 형태로 반환한다.
 *
 */

public class HashMapUsage1 {

	public static void main(String[] args) {
		
		HashMap<String, Integer> fruitMap = new HashMap();
		
		fruitMap.put("사과", 1000);
		fruitMap.put("배", 2000);
		fruitMap.put("자두", 3000);
		fruitMap.put("수박", 4000);
		
		// get() -> Key에 해당하는 Value 출력
		System.out.println(fruitMap.get("자두")); // 3000
		
		// values() -> 저장된 모든 Value 출력
		System.out.println(fruitMap.values()); // [2000, 4000, 1000, 3000]

		
		// HashMap에 넣은 Key와 Value를 Set에 넣고
		// iterator에 값으로 Set 정보를 담아준다.
		
		// Iterator itr = fruitMap.entrySet().iterator(); 와 같다.
		
		Set<Entry<String, Integer>> set = fruitMap.entrySet();
		
		Iterator<Entry<String, Integer>> itr = set.iterator();
		
		while(itr.hasNext()) {
			
			Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)itr.next();
			System.out.println("이름 : " + e.getKey() + ", 가격 : " + e.getValue() + "원");
			
		}
		
	}
	
}
