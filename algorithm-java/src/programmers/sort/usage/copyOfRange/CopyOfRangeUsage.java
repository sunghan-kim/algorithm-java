package programmers.sort.usage.copyOfRange;

import java.util.Arrays;

// http://tcpschool.com/java/java_api_arrays


/**
 * 
 * @author shkim
 * 
 * # Arrays Ŭ���� 
 * 
 * 1. java.util ��Ű��
 * 
 *   - java.util ��Ű������ ���α׷��� �����ϴ� �� ����� �� �ִ� ������ ��ƿ��Ƽ Ŭ������ �ټ� ���ԵǾ� �ֽ��ϴ�.
 *   - ������ java.lang ��Ű�� �������� ���� ���� ���Ǵ� ��Ű���� java.util ��Ű���Դϴ�.
 *   - ������ import ���� ������� �ʾƵ� �ٷ� ����� �� �ִ� java.lang ��Ű���ʹ� �޸� 
 *     java.util ��Ű���� import ������ ��Ű���� �ҷ����� ������ Ŭ���� �̸������� ����� �� �ֽ��ϴ�.
 *     
 * 2. java.util.Arrays Ŭ����
 * 
 *   - Arrays Ŭ�������� �迭�� �ٷ�� ���� �پ��� �޼ҵ尡 ���ԵǾ� �ֽ��ϴ�.
 *   - Arrays Ŭ������ ��� �޼ҵ�� Ŭ���� �޼ҵ�(static method)�̹Ƿ�, ��ü�� �������� �ʰ� �ٷ� ����� �� �ֽ��ϴ�.
 *   - �� Ŭ������ java.util ��Ű���� ���ԵǹǷ�, �ݵ�� import ������ java.util ��Ű���� �ҷ����� ���� ����ؾ� �մϴ�.
 *   
 *   
 *   2.1 copyOfRange() �޼ҵ�
 *   
 *     - copyOfRange() �޼ҵ�� ���޹��� �迭�� Ư�� ������ �ش��ϴ� ��Ҹ��� ���ο� �迭�� �����Ͽ� ��ȯ�մϴ�.
 *     
 *     - ù ��° �Ű����� : ������ ����� �� ���� �迭�� ���޹���
 *     - �� ��° �Ű����� : ���� �迭���� ������ ���� �ε����� ���޹���
 *     - �� ��° �Ű����� : ���������� ����� �迭 ����� �ٷ� ���� �ε����� ���޹���
 *     
 *     - ��, �� ��° �Ű������� ���޵� �ε��� �ٷ� �������� �迭 ��ұ����� ����˴ϴ�.
 *     - �׸��� ���� �迭�� ���� Ÿ���� ����� ���ο� �迭�� ��ȯ�մϴ�.
 *
 */
public class CopyOfRangeUsage {

	public static void main(String[] args) {
		
		int[] arr1 = {1, 2, 3, 4, 5};
		
		int[] arr2 = Arrays.copyOfRange(arr1, 2, 4);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
	}
	
}
