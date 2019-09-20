package blog.hyeonstorage.strategyPattern;

import blog.hyeonstorage.strategyPattern.cry.TigerCry;
import blog.hyeonstorage.strategyPattern.fly.FlyNoway;

//https://hyeonstorage.tistory.com/146?category=549763

public class Tiger extends Animal { // Animal 상속

	public Tiger() { // Tiger 객체 생성자
		
		cry = new TigerCry();	// Animal의 cry 변수에 Cry 인터페이스의 TigerCry를 연결한다.	
		fly = new FlyNoway();	// Animal의 fly 변수에 Fly 인터페이스의 FlyNoway를 연결한다. 
		
	}
	
	/*
	 * public void cry() { System.out.println("어흥"); }
	 * 
	 * public void display() { System.out.println("호랑이"); }
	 */
	
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("호랑이");
	}
	
}
