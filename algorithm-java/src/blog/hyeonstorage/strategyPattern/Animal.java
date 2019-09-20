package blog.hyeonstorage.strategyPattern;

import blog.hyeonstorage.strategyPattern.cry.Cry;
import blog.hyeonstorage.strategyPattern.fly.Fly;

// https://hyeonstorage.tistory.com/146?category=549763

public abstract class Animal { // Animal 추상 클래스

	/*
	 * @uml.property name="fly"
	 * @uml.associationEnd
	 * */
	protected Fly fly; // Fly 인터페이스 선언
	
	/*
	 * @uml.property name="cry"
	 * @uml.associationEnd
	 * */	
	protected Cry cry; // Cry 인터페이스 선언
	
	
	public Animal() { // Animal 생성자
		
	}
	
	
	public void performFly() { // Fly 인터페이스에 연결된 객체의 fly() 함수 실행
		fly.fly();
	}
	
	public void performCry() { // Cry 인터페이스에 연결된 객체의 cry() 함수 실행
		cry.cry();
	}
	
	/*
	public void cry() { // 동물의 울기
		System.out.println("운다.");
	}
	*/
	
	public void move() {
		System.out.println("움직인다.");
	}
	
	/*
	public void display() {
		System.out.println("모습");
	}
	*/
	
	public abstract void display(); // display() 함수 추상화
	
	

	
	
	
}
