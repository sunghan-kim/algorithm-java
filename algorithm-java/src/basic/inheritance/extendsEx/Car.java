package basic.inheritance.extendsEx;

/*
 * 
 * Car Ŭ����
 *   - Vehicle�� ��� ����
 *   - printspd() �޼ҵ忡���� speed�� ���� �ٷ� ���
 *   - extends�� ����Ͽ� �޼ҵ� �Ӹ� �ƴ϶� �������� ��� ����
 * 
 * */

/*
 * 
 * # ���� �������� ����
 * 
 * 1. public
 *   - �� ��
 *   - A Ŭ������ BŬ�������� �����ϰ� a.var; �� ����� �� �ִ�.
 *   - �ٸ� ��Ű�������� ����
 *   
 * 2. protected
 *   - ��� �� : �ڽ� Ŭ���� -> �θ� Ŭ���� ȣ�� ���� (�ٸ� ��Ű�� ����)
 *   - ���� ��Ű����� ���� �� ����
 *   - ��� || ���� ��Ű��
 *   
 * 3. default
 *   - ��� && ���� ��Ű��
 *   
 * 4. private
 *   - Ŭ���� ���ο����� ��� ����
 * 
 * */

/*
 * 
 * # Java�� ���� ����� �������� ����
 * 
 *   - ���߻���̶� '�Ҿƹ���-�ƹ���-�Ƶ�' �̷� ���� �ƴ�
 *   - ���߻���� '�θ��忡�� �θ� �� �� �ִ� ��'
 * 
 * */

public class Car extends Vehicle {

	public void printspd() {
		System.out.println(speed);
	}
	
}