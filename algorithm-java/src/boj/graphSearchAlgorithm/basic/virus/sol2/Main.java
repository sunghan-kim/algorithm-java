package boj.graphSearchAlgorithm.basic.virus.sol2;

/*
 *   문제명 : 바이러스
 *
 *   - https://www.acmicpc.net/problem/2606
 *   - BFS 사용
 *   - 성공 (14316KB, 128ms)
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int n, m;
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int cnt;

    private static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;
        cnt++;

        while (!q.isEmpty()) {
            int nowPos = q.poll();
            for (int nextPos : graph.get(nowPos)) {
                if (!visited[nextPos]) {
                    q.offer(nextPos);
                    visited[nextPos] = true;
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i=0; i < n+1; i++) graph.add(new ArrayList<>());

        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[n+1];

        bfs(1);
        System.out.println(cnt-1);

        br.close();
    }
}
