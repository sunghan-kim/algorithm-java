package strategyPattern;

// https://hyeonstorage.tistory.com/146?category=549763

public class Animal { // Animal 추상 클래스

	public Animal() {
		
	}
	
	public void cry() { // 동물의 울기
		System.out.println("운다.");
	}
	
	public void move() {
		System.out.println("움직인다.");
	}
	
	public void display() {
		System.out.println("모습");
	}
	
}
