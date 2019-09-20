package blog.hyeonstorage.strategyPattern;

import blog.hyeonstorage.strategyPattern.cry.TigerCry;
import blog.hyeonstorage.strategyPattern.fly.FlyNoway;

//https://hyeonstorage.tistory.com/146?category=549763

public class Tiger extends Animal { // Animal ���

	public Tiger() { // Tiger ��ü ������
		
		cry = new TigerCry();	// Animal�� cry ������ Cry �������̽��� TigerCry�� �����Ѵ�.	
		fly = new FlyNoway();	// Animal�� fly ������ Fly �������̽��� FlyNoway�� �����Ѵ�. 
		
	}
	
	/*
	 * public void cry() { System.out.println("����"); }
	 * 
	 * public void display() { System.out.println("ȣ����"); }
	 */
	
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("ȣ����");
	}
	
}
