package boj.searchAlgorithm.basic.weightLimit.sol3;

/*
 *   문제명 : 중량 제한
 *
 *   - https://www.acmicpc.net/problem/1939
 *   - 복습
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Weight {
        int node;
        int weight;

        public Weight(int y, int weight) {
            this.node = y;
            this.weight = weight;
        }
    }

    static int N;
    static int M;
    static ArrayList<Weight> [] ADJ;
    static int START_NODE;
    static int END_NODE;

    public static boolean bfs(int weight) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(START_NODE);
        boolean[] visited = new boolean[N+1];
        visited[START_NODE] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Weight w : ADJ[node]) {
                if (!visited[w.node] && weight <= w.weight) {
                    visited[w.node] = true;
                    queue.offer(w.node);
                }
            }
        }

        return visited[END_NODE];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ADJ = new ArrayList[N+1];
        for (int i=0; i < N+1; i++) {
            ADJ[i] = new ArrayList<>();
        }

        int start = 1000000000;
        int end = 1;

        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            ADJ[x].add(new Weight(y, weight));
            ADJ[y].add(new Weight(x, weight));

            start = Math.min(start, weight);
            end = Math.max(end, weight);
        }

        st = new StringTokenizer(br.readLine());
        START_NODE = Integer.parseInt(st.nextToken());
        END_NODE = Integer.parseInt(st.nextToken());

        int result = start;

        while (start <= end) {
            int mid = (start+end) / 2;
            if (bfs(mid)) {
                result = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        System.out.println(result);

        br.close();
    }
}
