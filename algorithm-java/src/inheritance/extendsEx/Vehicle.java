package inheritance.extendsEx;

// https://zbomoon.tistory.com/13

/*
 * # 상속 (inheritance)
 * 
 * 1. extends
 *   - 부모에서 선언/정의를 모두함
 *   - 자식은 메소드/변수를 그대로 사용할 수 있음
 *   
 * 2. implements (interface 구현)
 *   - 부모 객체는 선언만 함
 *   - 정의(내용)은 자식에서 오버라이딩 해야 함
 *   
 * 3. abstract
 *   - extends와 interface의 혼합
 *   - extends하되 몇 개는 추상 메소드로 구현되어 이씅ㅁ
 * 
 * */

/*
 * 
 * - extends
 *   - 상속의 대표적인 형태
 *   - 부모의 메소드를 그대로 사용할 수 있음
 *   - 오버라이딩 할 필요 없이 부모에 구현되어 있는 것을 직접 사용 가능
 * 
 * */

public class Vehicle {

	protected int speed = 3;
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
