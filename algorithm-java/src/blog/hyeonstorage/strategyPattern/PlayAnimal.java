package blog.hyeonstorage.strategyPattern;

// https://hyeonstorage.tistory.com/146?category=549763

public class PlayAnimal {
	
	public static void main(String[] args) { // main �Լ� ����
		
		Animal tiger = new Tiger(); // Animal Ŭ������ ��ӹ��� Tiger ��ü ����
		
		tiger.display(); 			// Tiger�� display() �Լ� ����
		//tiger.move();
		//tiger.cry();
		tiger.performCry();			// Tiger�� performCry() �Լ� ����
		tiger.performFly();			// Tiger�� performFly() �Լ� ����
		
		System.out.println("--------------------------");
		
		Animal eagle = new Eagle();	// Animal Ŭ������ ��ӹ��� Eagle ��ü ����
		
		eagle.display();
		//eagle.move();
		//eagle.cry();
		eagle.performCry();
		eagle.performFly();
		
		System.out.println("--------------------------");
		
		Animal turtle = new Turtle();
		
		turtle.display();
		turtle.performCry();
		turtle.performFly();
		
	}
	
}
