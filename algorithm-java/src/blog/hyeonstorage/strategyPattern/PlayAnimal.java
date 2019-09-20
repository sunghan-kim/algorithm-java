package blog.hyeonstorage.strategyPattern;

// https://hyeonstorage.tistory.com/146?category=549763

public class PlayAnimal {
	
	public static void main(String[] args) { // main 함수 실행
		
		Animal tiger = new Tiger(); // Animal 클래스를 상속받은 Tiger 객체 생성
		
		tiger.display(); 			// Tiger의 display() 함수 실행
		//tiger.move();
		//tiger.cry();
		tiger.performCry();			// Tiger의 performCry() 함수 실행
		tiger.performFly();			// Tiger의 performFly() 함수 실행
		
		System.out.println("--------------------------");
		
		Animal eagle = new Eagle();	// Animal 클래스를 상속받은 Eagle 객체 생성
		
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
