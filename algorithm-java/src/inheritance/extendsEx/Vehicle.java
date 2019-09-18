package inheritance.extendsEx;

// https://zbomoon.tistory.com/13

/*
 * # ��� (inheritance)
 * 
 * 1. extends
 *   - �θ𿡼� ����/���Ǹ� �����
 *   - �ڽ��� �޼ҵ�/������ �״�� ����� �� ����
 *   
 * 2. implements (interface ����)
 *   - �θ� ��ü�� ���� ��
 *   - ����(����)�� �ڽĿ��� �������̵� �ؾ� ��
 *   
 * 3. abstract
 *   - extends�� interface�� ȥ��
 *   - extends�ϵ� �� ���� �߻� �޼ҵ�� �����Ǿ� �̝���
 * 
 * */

/*
 * 
 * - extends
 *   - ����� ��ǥ���� ����
 *   - �θ��� �޼ҵ带 �״�� ����� �� ����
 *   - �������̵� �� �ʿ� ���� �θ� �����Ǿ� �ִ� ���� ���� ��� ����
 * 
 * */

public class Vehicle {

	protected int speed = 3;
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
