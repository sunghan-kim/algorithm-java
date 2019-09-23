package programmers.hash.problem.level3.solution.bestAlbum.developerdk;

// https://developerdk.tistory.com/13

	
// ���� ��ȣ(idx)�� ��� Ƚ��(plays)�� ���� Song Ŭ���� ����
public class Song implements Comparable<Song> {

	public int idx;
	public int plays;
	
	public Song(int idx, int plays) {
		
		this.idx = idx;
		this.plays = plays;
		
	}
	
	// ��� Ƚ��(plays) ū ���� �� ũ����,
	// ��� Ƚ���� ���ٸ� idx�� ���Ͽ� �� ���� ���� ũ���� ����
	@Override
	public int compareTo(Song o) {
		
		if (this.plays == o.plays) {
			
			if (this.idx > o.idx) {
				
				return 1;
				
			} else {
				
				return -1;
				
			}
			
		} else if (this.plays < o.plays) {
			
			return 1;
			
		} else {
			
			return -1;
			
		}
		
	}
	
}
