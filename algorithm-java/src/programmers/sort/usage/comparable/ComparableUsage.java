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
		 * 1. ��ü ���� ������ �ʿ伺
		 * 
		 */
		
		// - �⺻��(primitive) ������ (ex. ����, ����)�� ��� �� ������ �����Ѵ�.
		//    - 1 < 2, A < B
		
		// ���� �迭 ����
		int[] scores = {899, 982, 1090, 982, 1018};
		
		Arrays.sort(scores);
		
		System.out.println(Arrays.toString(scores));
		
		// Ư�� Ÿ���� ��ü�� ���ı����� ������ ������ �� ����
		// ���� ���� ������ �����Ͽ� �˷���� �Ѵ�.
		
		// �Ʒ� �ڵ� ���� �� ������ ���� �߻�
		//Collections.sort(players);
		
		/**
		 * 
		 * 2. Comparable �������̽�
		 * 
		 *  - ��ü�� ���� ������ �����ϴ� ù ��° ���
		 *   : ���� ��� Ŭ������ �ڹٿ��� �⺻������ �����ϴ� 'Comparable' �������̽��� �̿��Ͽ� ����
		 *   
		 *  - Player Ŭ���� ����
		 *  
		 *  - Comparable �������̽��� compareTo() �޼ҵ带 ����
		 *    ���ڷ� �Ѿ�� ���� Ÿ���� �ٸ� ��ü�� ��� �� ����
		 *    
		 *  - �޼ҵ带 ȣ���ϴ� ��ü�� ���ڷ� �Ѿ�� ��ü���� �۴�
		 *   -> ���� ����
		 *   
		 *  - ũ�Ⱑ ����
		 *   -> 0
		 *   
		 *  - �޼ҵ带 ȣ���ϴ� ��ü�� ���ڷ� �Ѿ�� ��ü���� ũ��
		 *   -> ��� ����
		 * 
		 */
		
		List<Player2> players2 = new ArrayList<Player2>();
		
		players2.add(new Player2("Alice", 899));
		players2.add(new Player2("Bob", 982));
		players2.add(new Player2("Chloe", 1090));
		players2.add(new Player2("Dale", 982));
		players2.add(new Player2("Eric", 1018));
				
		// ���� Collections.sort() �޼��忡�� Comparable �������̽����� ������
		// Comparable Ÿ���� Player ��ü�� ����Ʈ�� ���ڷ� �Ѿ�� ������
		// �� �̻� ������ ������ �߻����� �ʴ´�.
		Collections.sort(players2);
		
		// ���� �� ���̸� ����Ʈ�� ����غ��� ������ ���� ���� Chloe�� ����Ʈ�� �� ������ ��ġ�ϰ�,
		// ������ ���� ���� Alice�� ����Ʈ�� �� �ڿ� ��ġ�ϰ� �ȴ�.
		for (Player2 p : players2) {
			
			System.out.println(p.getName() + " : " + p.getScore());
			
		}
		
		
		System.out.println("---------------------------------------");
		
		/**
		 * 
		 * 3. Comparator ��ü ���
		 * 
		 *  - ���� ��� Ŭ������ �ڵ带 ���� ������ �� ���� ���
		 *  - �Ǵ� ���� �ϰ��� �ϴ� ��ü�� �̹� �����ϰ� �ִ� ���� ���ذ�
		 *    �ٸ� ���� �������� �����ϰ� ���� ��
		 *    
		 *  - �� �� �ʿ��� ���� Comparator �������̽��̴�.
		 *  
		 *  - Comparator �������̽��� ����ü�� Arrays.sort() �� Collections.sort() �� ����
		 *    ���� �޼����� �߰� ���ڷ� �ѱ�� ���� ������ ������ Ŭ������ ��ü��
		 *    ���� ���� ������ �����ϰ� ���ο� ���� �������� ��ü�� ������ �� �ִ�.
		 * 
		 */
		
		Comparator<Player> comparator = new Comparator<Player>() {
			
			@Override
			public int compare(Player a, Player b) {

				return b.getScore() - a.getScore(); // ��������
				//return a.getScore() - b.getScore(); // ��������
				
			}
			
		};
		
		Collections.sort(players, comparator);
		
		for (Player p : players) {
			
			System.out.println(p.getName() + " : " + p.getScore());
			
		}
		
		System.out.println("---------------------------------------");
		
		/**
		 * 
		 * 4. ���� �Լ��� ��ü
		 * 
		 *  - Comparator ��ü�� �޼ҵ尡 �ϳ� ���� �Լ��� �������̽��� �����ϱ� ������
		 *    ���� �Լ��� ��ü ����
		 * 
		 */
		
		// �������� ����
		Collections.sort(players, (a, b) -> b.getScore() - a.getScore());
		
		for (Player p : players) {
			
			System.out.println(p.getName() + " : " + p.getScore());
			
		}
		
		System.out.println("---------------------------------------");
		
		// �������� ����
		Collections.sort(players, (a, b) -> a.getScore() - b.getScore());
		
		for (Player p : players) {
			
			System.out.println(p.getName() + " : " + p.getScore());
			
		}
		
	}
	
}
