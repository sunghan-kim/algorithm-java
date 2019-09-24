package programmers.sort.usage.list;

import java.util.Vector;

// https://hyeonstorage.tistory.com/208


/**
 * 
 * @author shkim
 * 
 * 
 * # Vector
 * 
 *   - �������� �迭
 *   - ��, Vector Ŭ������ ��ü�� ���� �������� �����ϴ� �迭�̹Ƿ� 
 *     �پ��� ��ü���� �ϳ��� Vector�� ����� �� �ְ� ���̵� �ʿ信 ���� ������ �� �ִٴ� ���� �迭�� �ٸ� ���̴�.
 *
 */

public class VectorUsage {

	public static void main(String[] args) {
		
		// Vector ��ü�� String ��ü�� ���� �� ������, 
		// �뷮�� 3 �̸�, size�� �뷮�� �ʰ����� ��, 3�� ũ�⸸ŭ �뷮�� �����Ѵ�. 
		// (�Ű������� �������� ������ �⺻ �뷮 10, ���� �뷮 10�̴�.)
		Vector<String> vector = new Vector<String>(3);
		
		System.out.println("vector�� ũ�� : " + vector.size());
		System.out.println("vector�� �뷮 : " + vector.capacity());
		
		// vector.addElement() �� String ��ü�� 4�� ����
		vector.addElement("���̾�");
		vector.addElement("������");
		vector.addElement("����Ŀ");
		vector.addElement("�ҳ�ô�");
		
		System.out.println("������ ���� �� vector�� ũ�� : " + vector.size());
		System.out.println("������ ���� �� vector�� �뷮 : " + vector.capacity());
		
		// size=4, capacity=6�� ����
		// �̰��� �⺻ �뷮 3���� 3���� ���� ��ü�� ���ԵǾ�, �뷮�� 3��ŭ �������� ������ ��
		
		
		
	}
	
}
