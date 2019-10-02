package programmers.stackAndQueue.problem.level2.solution.funcDev;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution3 {

	int progressesCount;
	int[] needDays;
	
	ArrayList<Integer> workCountStorage;
	
	public int[] solution3(int[] progresses, int[] speeds) {
		
		// Init
		progressesCount = progresses.length;
		needDays = new int[progressesCount];
		workCountStorage = new ArrayList<>();
		
		// 필요한 작업일 계산
		this.calcNeedDays(progresses,  speeds);
		
		System.out.println(Arrays.toString(needDays));
		
		return null;
		
	}
	
	private void calcNeedDays(int[] progresses, int[] speeds) {
		
		for (int i=0; i < progressesCount; i++) {
			
			double remainProgress = 100 - progresses[i];
			double fNeedDay = remainProgress / speeds[i];
			
			needDays[i] = (int)Math.ceil(fNeedDay);
			
		}
		
	}
	
}
