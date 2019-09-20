package blog.hyeonstorage.strategyPattern;

import blog.hyeonstorage.strategyPattern.cry.BirdCry;
import blog.hyeonstorage.strategyPattern.fly.FlyWithWings;

//https://hyeonstorage.tistory.com/146?category=549763

public class Eagle extends Animal { // Animal Class ���

	public Eagle() { // Eagle ��ü ������
	
		cry = new BirdCry();		// Animal�� cry ������ Cry �������̽��� BirdCry�� �����Ѵ�.
		fly = new FlyWithWings();	// Animal�� fly ������ Fly �������̽��� FlyWithWings�� �����Ѵ�.
		
	}
	
	/*
	 * public void cry() { System.out.println("���"); }
	 * 
	 * public void display() { System.out.println("������"); }
	 */
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}
	
	
}
