package programmers.sort.usage.comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// https://www.daleseo.com/java-comparable-comparator/

public class ComparableUsage {

	public static void main(String[] args) {
		
		List<Player> players = new ArrayList<Player>();
		
		players.add(new Player("Alice", 899));
		players.add(new Player("Bob", 982));
		players.add(new Player("Chloe", 1090));
		players.add(new Player("Dale", 982));
		players.add(new Player("Eric", 1018));
		
		/**
		 * 
		 * 1. 객체 정렬 기준의 필요성
		 * 
		 */
		
		// - 기본형(primitive) 데이터 (ex. 숫자, 문자)는 대소 비교 개념이 존재한다.
		//    - 1 < 2, A < B
		
		// 점수 배열 정렬
		int[] scores = {899, 982, 1090, 982, 1018};
		
		Arrays.sort(scores);
		
		System.out.println(Arrays.toString(scores));
		
		// 특정 타입의 객체는 정렬기준이 없으면 정렬할 수 없음
		// 따라서 정렬 기준을 정의하여 알려줘야 한다.
		
		// 아래 코드 수행 시 컴파일 에러 발생
		//Collections.sort(players);
		
		/**
		 * 
		 * 2. Comparable 인터페이스
		 * 
		 *  - 객체의 정렬 기준을 정의하는 첫 번째 방법
		 *   : 정렬 대상 클래스를 자바에서 기본적으로 제공하는 'Comparable' 인터페이스를 이용하여 구현
		 *   
		 *  - Player 클래스 참고
		 *  
		 *  - Comparable 인터페이스의 compareTo() 메소드를 통해
		 *    인자로 넘어온 같은 타입의 다른 객체와 대소 비교 가능
		 *    
		 *  - 메소드를 호출하는 객체가 인자로 넘어온 객체보다 작다
		 *   -> 음수 리턴
		 *   
		 *  - 크기가 동일
		 *   -> 0
		 *   
		 *  - 메소드를 호출하는 객체가 인자로 넘어온 객체보다 크다
		 *   -> 양수 리턴
		 * 
		 */
		
		List<Player2> players2 = new ArrayList<Player2>();
		
		players2.add(new Player2("Alice", 899));
		players2.add(new Player2("Bob", 982));
		players2.add(new Player2("Chloe", 1090));
		players2.add(new Player2("Dale", 982));
		players2.add(new Player2("Eric", 1018));
				
		// 이제 Collections.sort() 메서드에는 Comparable 인터페이스에서 구현한
		// Comparable 타입의 Player 객체의 리스트가 인자로 넘어가기 때문에
		// 더 이상 컴파일 에러가 발생하지 않는다.
		Collections.sort(players2);
		
		// 정렬 후 게이머 리스트를 출력해보면 점수가 제일 높은 Chloe가 리스트의 맨 앞으로 위치하고,
		// 점수가 제일 낮은 Alice가 리스트의 맨 뒤에 위치하게 된다.
		for (Player2 p : players2) {
			
			System.out.println(p.getName() + " : " + p.getScore());
			
		}
		
		
		System.out.println("---------------------------------------");
		
		/**
		 * 
		 * 3. Comparator 객체 사용
		 * 
		 *  - 정렬 대상 클래스의 코드를 직접 수정할 수 없는 경우
		 *  - 또는 정렬 하고자 하는 객체에 이미 존재하고 있는 정렬 기준과
		 *    다른 저렬 기준으로 정렬하고 싶을 때
		 *    
		 *  - 이 때 필요한 것이 Comparator 인터페이스이다.
		 *  
		 *  - Comparator 인터페이스의 구현체를 Arrays.sort() 나 Collections.sort() 와 같은
		 *    정렬 메서드의 추가 인자로 넘기면 정렬 기준을 누락된 클래스의 객체나
		 *    기존 정렬 기준을 무시하고 새로운 정렬 기준으로 객체를 정렬할 수 있다.
		 * 
		 */
		
		Comparator<Player> comparator = new Comparator<Player>() {
			
			@Override
			public int compare(Player a, Player b) {

				return b.getScore() - a.getScore(); // 내림차순
				//return a.getScore() - b.getScore(); // 오름차순
				
			}
			
		};
		
		Collections.sort(players, comparator);
		
		for (Player p : players) {
			
			System.out.println(p.getName() + " : " + p.getScore());
			
		}
		
		System.out.println("---------------------------------------");
		
		/**
		 * 
		 * 4. 람다 함수로 대체
		 * 
		 *  - Comparator 객체는 메소드가 하나 뿐인 함수형 인터페이스를 구현하기 때문에
		 *    람다 함수로 대체 가능
		 * 
		 */
		
		// 내림차순 정렬
		Collections.sort(players, (a, b) -> b.getScore() - a.getScore());
		
		for (Player p : players) {
			
			System.out.println(p.getName() + " : " + p.getScore());
			
		}
		
		System.out.println("---------------------------------------");
		
		// 오름차순 정렬
		Collections.sort(players, (a, b) -> a.getScore() - b.getScore());
		
		for (Player p : players) {
			
			System.out.println(p.getName() + " : " + p.getScore());
			
		}
		
	}
	
}
