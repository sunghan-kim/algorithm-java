package boj.graphSearchAlgorithm.basic.virus.sol1;

/*
 *   문제명 : 바이러스
 *
 *   - https://www.acmicpc.net/problem/2606
 *   - DFS 사용
 *   - 성공 (14448KB, 144ms)
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static StringTokenizer st;
    private static boolean[] visited;
    private static List<List<Integer>> graph;
    private static int cnt;

    private static void dfs(int x) {
        cnt++;
        visited[x] = true;

        for (int v : graph.get(x)) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        graph = new ArrayList<>();
        for (int i=0; i < n+1; i++) graph.add(new ArrayList<>());

        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(1);
        System.out.println(cnt-1);

        br.close();
    }
}
