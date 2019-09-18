package inheritance.extendsEx;

/*
 * 
 * Car 클래스
 *   - Vehicle을 상속 받음
 *   - printspd() 메소드에서는 speed를 직접 바로 사용
 *   - extends를 사용하여 메소드 뿐만 아니라 변수까지 사용 가능
 * 
 * */

/*
 * 
 * # 접근 지정자의 역할
 * 
 * 1. public
 *   - 다 됨
 *   - A 클래스를 B클래스에서 생성하고 a.var; 로 사용할 수 있다.
 *   - 다른 패키지에서도 가능
 *   
 * 2. protected
 *   - 상속 시 : 자식 클래스 -> 부모 클래스 호출 가능 (다른 패키지 가능)
 *   - 동일 패키지라면 비상속 시 가능
 *   - 상속 || 동일 패키지
 *   
 * 3. default
 *   - 상속 && 동일 패키지
 *   
 * 4. private
 *   - 클래스 내부에서만 사용 가능
 * 
 * */

/*
 * 
 * # Java는 다중 상속을 지원하지 않음
 * 
 *   - 다중상속이란 '할아버지-아버지-아들' 이런 뜻이 아님
 *   - 다중상속은 '부모노드에서 부모가 두 명 있는 것'
 * 
 * */

public class Car extends Vehicle {

	public void printspd() {
		System.out.println(speed);
	}
	
}
