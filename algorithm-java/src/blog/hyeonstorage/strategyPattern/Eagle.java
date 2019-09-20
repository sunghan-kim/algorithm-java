package blog.hyeonstorage.strategyPattern;

import blog.hyeonstorage.strategyPattern.cry.BirdCry;
import blog.hyeonstorage.strategyPattern.fly.FlyWithWings;

//https://hyeonstorage.tistory.com/146?category=549763

public class Eagle extends Animal { // Animal Class 상속

	public Eagle() { // Eagle 객체 생성자
	
		cry = new BirdCry();		// Animal의 cry 변수에 Cry 인터페이스의 BirdCry를 연결한다.
		fly = new FlyWithWings();	// Animal의 fly 변수에 Fly 인터페이스의 FlyWithWings를 연결한다.
		
	}
	
	/*
	 * public void cry() { System.out.println("까악"); }
	 * 
	 * public void display() { System.out.println("독수리"); }
	 */
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("독수리");
	}
	
	
}
