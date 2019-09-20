package blog.hyeonstorage.strategyPattern;

import blog.hyeonstorage.strategyPattern.cry.CryNoWay;
import blog.hyeonstorage.strategyPattern.fly.FlyNoway;

public class Turtle extends Animal { // Animal ���
	
	public Turtle() { // Turtle ��ü ������
		
		cry = new CryNoWay(); // Animal�� cry ������ Cry �������̽��� CryNoWay�� �����Ѵ�.
		fly = new FlyNoway(); // Animal�� fly ������ Fly �������̽��� FlyNoWay�� �����Ѵ�.
		
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("�ź���");
	}

}