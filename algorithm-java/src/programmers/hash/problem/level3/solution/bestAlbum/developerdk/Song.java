package programmers.hash.problem.level3.solution.bestAlbum.developerdk;

// https://developerdk.tistory.com/13

	
// 고유 번호(idx)와 재생 횟수(plays)를 가진 Song 클래스 생성
public class Song implements Comparable<Song> {

	public int idx;
	public int plays;
	
	public Song(int idx, int plays) {
		
		this.idx = idx;
		this.plays = plays;
		
	}
	
	// 재생 횟수(plays) 큰 것이 더 크도록,
	// 재생 횟수가 같다면 idx를 비교하여 더 낮은 것이 크도록 설정
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
