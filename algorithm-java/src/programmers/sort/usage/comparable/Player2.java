package programmers.sort.usage.comparable;

public class Player2 implements Comparable<Player2> {

	private String name;
	private int score;
	
	public Player2(String name, int score) {
		
		this.name = name;
		this.score = score;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	@Override
	public int compareTo(Player2 o) {

		return o.getScore() - getScore(); // 내림차순 정렬
		//return getScore() - o.getScore(); // 오름차순 정렬
		
	}
	
}
