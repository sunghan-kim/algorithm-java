package strategyPattern;

//https://hyeonstorage.tistory.com/146?category=549763

public class PlayAnimal {
	
	public static void main(String[] args) {
		
		Animal tiger = new Tiger(); // AnimalÀÇ Tiger °´Ã¼ »ý¼º
		
		tiger.display();
		tiger.move();
		tiger.cry();
		
		System.out.println("-------------");
		
		Animal eagle = new Eagle();
		
		eagle.display();
		eagle.move();
		eagle.cry();
		
	}
	
}
