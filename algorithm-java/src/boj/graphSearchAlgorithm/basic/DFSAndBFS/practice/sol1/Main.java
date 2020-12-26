package boj.graphSearchAlgorithm.basic.DFSAndBFS.practice.sol1;

/*
 *   문제명 : DFS와 BFS
 *
 *   - https://www.acmicpc.net/problem/1260
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static StringTokenizer st;
    private static int n, m, v;
    private static List<LinkedList<Integer>> graph;
    private static boolean[] visited;
    private static StringBuilder result;

    private static void dfs(int v) {
        visited[v] = true;
        result.append(v).append(" ");

        for (int g : graph.get(v)) {
            if (!visited[g]) dfs(g);
        }
    }

    private static void bfs(int v) {
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        result.append(v).append(" ");

        while (!queue.isEmpty()) {
            for (int g : graph.get(queue.pollFirst())) {
                if (!visited[g]) {
                    visited[g] = true;
                    queue.offer(g);
                    result.append(g).append(" ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i=0; i < n+1; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (LinkedList<Integer> list : graph) Collections.sort(list);

        visited = new boolean[n+1];
        result = new StringBuilder();
        dfs(v);
        System.out.println(result.toString());

        visited = new boolean[n+1];
        result = new StringBuilder();
        bfs(v);
        System.out.println(result.toString());

        br.close();
    }
}
