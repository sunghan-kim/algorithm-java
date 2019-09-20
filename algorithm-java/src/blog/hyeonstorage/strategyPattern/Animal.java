package blog.hyeonstorage.strategyPattern;

import blog.hyeonstorage.strategyPattern.cry.Cry;
import blog.hyeonstorage.strategyPattern.fly.Fly;

// https://hyeonstorage.tistory.com/146?category=549763

public abstract class Animal { // Animal �߻� Ŭ����

	/*
	 * @uml.property name="fly"
	 * @uml.associationEnd
	 * */
	protected Fly fly; // Fly �������̽� ����
	
	/*
	 * @uml.property name="cry"
	 * @uml.associationEnd
	 * */	
	protected Cry cry; // Cry �������̽� ����
	
	
	public Animal() { // Animal ������
		
	}
	
	
	public void performFly() { // Fly �������̽��� ����� ��ü�� fly() �Լ� ����
		fly.fly();
	}
	
	public void performCry() { // Cry �������̽��� ����� ��ü�� cry() �Լ� ����
		cry.cry();
	}
	
	/*
	public void cry() { // ������ ���
		System.out.println("���.");
	}
	*/
	
	public void move() {
		System.out.println("�����δ�.");
	}
	
	/*
	public void display() {
		System.out.println("���");
	}
	*/
	
	public abstract void display(); // display() �Լ� �߻�ȭ
	
	

	
	
	
}
