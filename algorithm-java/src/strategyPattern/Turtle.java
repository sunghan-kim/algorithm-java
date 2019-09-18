package strategyPattern;

import strategyPattern.cry.CryNoWay;
import strategyPattern.fly.FlyNoway;

public class Turtle extends Animal { // Animal 상속
	
	public Turtle() { // Turtle 객체 생성자
		
		cry = new CryNoWay(); // Animal의 cry 변수에 Cry 인터페이스의 CryNoWay를 연결한다.
		fly = new FlyNoway(); // Animal의 fly 변수에 Fly 인터페이스의 FlyNoWay를 연결한다.
		
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("거북이");
	}

}
