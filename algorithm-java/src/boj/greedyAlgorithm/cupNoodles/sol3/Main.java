package boj.greedyAlgorithm.cupNoodles.sol3;

/*
 *   문제명 : 컵라면
 *
 *   - https://www.acmicpc.net/problem/1781
 *   - 해설코드 참고하여 sol1 개선
 *   - 그래도 실패...
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Problem implements Comparable<Problem> {
        private final int deadline;
        private final int cupNoodleCnt;

        private Problem(int deadline, int cupNoodleCnt) {
            this.deadline = deadline;
            this.cupNoodleCnt = cupNoodleCnt;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.deadline > o.deadline) {
                return 1;
            } else if (this.deadline == o.deadline) {
                if (this.cupNoodleCnt > o.cupNoodleCnt) {
                    return 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Problem> problems = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int cupNoodleCnt = Integer.parseInt(st.nextToken());
            problems.add(new Problem(deadline, cupNoodleCnt));
        }

        Collections.sort(problems);

        for (Problem p : problems) {
            queue.offer(p.cupNoodleCnt);
            if (queue.size() > p.deadline) queue.poll();
        }

        int result = 0;
        while (!queue.isEmpty()) {
            result += queue.poll();
        }

        System.out.println(result);

        br.close();
    }
}
