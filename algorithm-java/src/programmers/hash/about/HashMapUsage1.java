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
 * # HashMap �Լ� ����� �˰� ����ϱ�
 * 
 * 
 * 1. HashMap�̶�?
 * 
 *   - HashMap�� Map�� ����
 *   - Key�� value�� ���� �ϳ��� entry�� �����Ѵٴ� Ư¡�� ����
 *   - �׸��� hashing�� ����ϱ� ������ ���� ���� �����͸� �˻��ϴµ� �پ ������ ����
 *   
 *   - Map �������̽��� �� ����
 *   - ("Key", value)�� �̷��� �ִ�.
 *   - key ���� �ߺ� �Ұ���
 *   - value�� �ߺ� ���� (value�� null���� ��� ����)
 *   - ��Ƽ�����忡�� ���ÿ� HashMap�� �ǵ�� Key-value���� ����ϸ� ������ �� �� �ִ�.
 *     (��Ƽ�����忡���� HashTable�� ���)
 *     
 *     
 * 2. HashMap ������ / �޼���
 * 
 *   2.1 HashMap()
 *   
 *     - HashMap ��ü ����
 *     
 *     ex) HashMap<String , Integer> map = new HashMap<String , Integer>();
 *     ex) Map<String, Integer> map = new HashMap<String, integer>();
 *     
 *     
 *   2.2 HashMap(int initialCapacity)
 *   
 *     - ������ ���� �ʱ� �뷮���� �ϴ� HashMap��ü�� �����Ѵ�.
 *     
 *     
 *   2.3 HashMap(int initlalCapacity, float loadFactory)
 *   
 *     - ������ ���� �ʱ�뷮�� load factory�� HashMap ��ü�� �����Ѵ�.
 *     
 *     
 *   2.4 HashMap(Map m)
 *     
 *     - �־��� Map�� ����� ��� ��Ҹ� �����ϴ� HashMap�� �����Ѵ�.
 *     
 *     
 *   2.5 void clear()
 *   
 *     - HashMap�� ����� ��� ��ü�� �����Ѵ�.
 *     
 *     ex) map.clear();
 *     
 *     
 *   2.6 Object clone()
 *     
 *     - ���� HashMap�� �����Ͽ� ��ȯ�Ѵ�.
 *     
 *     ex) newmap = (HashMap)map.clone();
 *     
 *     
 *   2.7 boolean containsKey(Object Key)
 *   
 *     - HashMap�� ������ Ű(Key)�� ���ԵǾ� �ִ� �� �˷��ش�.
 *     
 *     
 *   2.8 boolean containsValue(Object value)
 *    
 *     - HashMap�� ������ ��(Value)�� ���ԵǾ� �ִ� �� �˷��ش�.
 *     
 *     
 *   2.9 Set entrySet()
 *   
 *     - HashMap�� ����� Key-Value ���� ��Ʈ��(Ű�� ���� ����)�� ���·� Set�� �����Ͽ� ��ȯ
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
 *     - ������ Key�� ���� ��ȯ�Ѵ�.
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
 *     - HashMap�� ����ִ� �� Ȯ���Ѵ�.
 *     
 *     ex) boolean val = map.isEmpty();
 *     
 *     
 *   2.12 Set keySet()
 *   
 *     - HashMap�� ����� ��� Ű�� ����� Set�� ��ȯ�Ѵ�.
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
 *     - HashMap�� Ű�� ���� ����
 *     
 *     ex) map.put("A", "aaa");
 *     	   map.put("B", "bbb");
 *         map.put("C", "ccc");
 *   
 *   
 *   2.14 void putAll(Map m)
 *   
 *     - Map�� �ش��ϴ� ��� ��Ҹ� HashMap�� �����Ѵ�.
 *     
 *     
 *   2.15 Object remove(Object key)
 *   
 *     - HashMap�� ������ Ű�� ����� ���� �����Ѵ�.
 *     
 *     ex) map.remove("key");
 *     
 *     
 *   2.16 int size()
 *   
 *     - HashMap�� ����� ����� ������ ��ȯ
 *     
 *     
 *   2.17 Collection values()
 *   
 *     - HashMap�� ����� ��� ���� �÷��� ���·� ��ȯ�Ѵ�.
 *
 */

public class HashMapUsage1 {

	public static void main(String[] args) {
		
		HashMap<String, Integer> fruitMap = new HashMap();
		
		fruitMap.put("���", 1000);
		fruitMap.put("��", 2000);
		fruitMap.put("�ڵ�", 3000);
		fruitMap.put("����", 4000);
		
		// get() -> Key�� �ش��ϴ� Value ���
		System.out.println(fruitMap.get("�ڵ�")); // 3000
		
		// values() -> ����� ��� Value ���
		System.out.println(fruitMap.values()); // [2000, 4000, 1000, 3000]

		
		// HashMap�� ���� Key�� Value�� Set�� �ְ�
		// iterator�� ������ Set ������ ����ش�.
		
		// Iterator itr = fruitMap.entrySet().iterator(); �� ����.
		
		Set<Entry<String, Integer>> set = fruitMap.entrySet();
		
		Iterator<Entry<String, Integer>> itr = set.iterator();
		
		while(itr.hasNext()) {
			
			Map.Entry<String, Integer> e = (Map.Entry<String, Integer>)itr.next();
			System.out.println("�̸� : " + e.getKey() + ", ���� : " + e.getValue() + "��");
			
		}
		
	}
	
}
