package programmers.sort.usage.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// https://mainia.tistory.com/2323



public class ListUsage {

	public static void main(String[] args) {
		
		// 1. add, get : �� �߰��ϰ� ������
		List listA = new ArrayList();
		
		listA.add("���");
		listA.add("ȫ�Ƹ�");
		listA.add(new String("ȫ�浿"));
		
		listA.add(1, "1��° ��Ұ�");
		
		System.out.println("listA : " + listA);
		
		System.out.println("--------------------------------------");
		
		// �ε����� ���� ��ȸ
		String element0 = listA.get(0).toString();
		System.out.println("element0 : " + element0);
		
		String element1 = listA.get(1).toString();
		System.out.println("element1 : " + element1);
		
		String element2 = listA.get(2).toString();
		System.out.println("element2 : " + element2);
		
		System.out.println("--------------------------------------");
		
		// Iterator�� ���� ��ü ��ȸ
		Iterator iterator = listA.iterator();
		
		while(iterator.hasNext()) {
			
			String element = (String) iterator.next();
			System.out.println("iterator's element : " + element);
			
		}
		
		System.out.println("--------------------------------------");
		
		// for-loop�� ���� ��ü ��ȸ
		for (Object object : listA) {
			
			String element = (String) object;
			System.out.println("for-loop's element : " + element);
			
		}
		
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		
		// 2. add(index, value) : �߰��� �� �ֱ�
		
		// 2.1 ȫ�浿 �տ� �� �߰� : indexOf() �޼��� �̿�
		int index = listA.indexOf("ȫ�浿");
		listA.add(index, "ȫ�浿 �տ� �� �߰�");
		
		System.out.println("--------------------------------------");
		
		// 2.2 ���� ���� Ȯ�� : contains() �޼��� �̿�
		System.out.println(listA.contains("ȫ�浿"));
		
		
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		
		// 3. remvoe : �� ����
		
		//   - remove(Object element)
		//   - remove(int index)
		
		System.out.println(listA.remove(0));
		System.out.println(listA.remove("ȫ�浿"));
		
		
	}
	
}
