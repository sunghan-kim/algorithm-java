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
		//  - ArrayList�� ũ�⸦ ��ȯ�ϴ� �޼���
		//	  (Array�� length �޼���� ������ ���)
		System.out.println("size : " + al.size());
		
		System.out.println("-------------------------------------");
		
		// get()
		//  - ArrayList�� Ư�� ���� ����
		for (int i=0; i < al.size(); i++) {
			
			System.out.println(al.get(i));
			
		}
		
		System.out.println("-------------------------------------");
		
		// ArrayList�� �޼��� add�� ���ڷ� � ������ ���� ���� �� �� �� ����.
		// ���� ��� ������ Ÿ���� ������ Object �������� �����͸� �޴´�.
		// �׷��Ƿ� get �޼��带 �̿��� ���� ������ Object ������ Ÿ���� ������ �����Ƿ�
		// "����ȯ" �۾��� ����� �Ѵ�.
		for (int i=0; i < al.size(); i++) {
			
			// String val = al.get(i); <- ������ ���� �߻�
			String val = (String) al.get(i);
			System.out.println(val);
			
		}
		
		System.out.println("-------------------------------------");
		
		// ������ ���� ���� ����ȯ�ϴ� ���� ���� ����̴�.
		// ������ �Ʒ��� ���� "���׸�"�� ����ؾ� �Ѵ�.
		ArrayList<String> al2 = new ArrayList<String>();
		
		al2.add("one");
		al2.add("two");
		al2.add("three");
		
		for (int i=0; i < al2.size(); i++) {
			
			String val = al2.get(i);
			System.out.println(val);
			
		}
		
		// ���׸��� ����ϸ� ArrayList ������ ����� ������ Ÿ���� �ν��Ͻ��� ������ ��
		// ������ �� �ֱ� ������ �����͸� ���� �� ����ȯ�� ���� �ʾƵ� �ȴ�.
		
	}
	
}
