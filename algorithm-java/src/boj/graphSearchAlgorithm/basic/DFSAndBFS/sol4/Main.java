package boj.graphSearchAlgorithm.basic.DFSAndBFS.sol4;

/*
 *   문제명 : DFS와 BFS
 *
 *   - https://www.acmicpc.net/problem/1260
 *   - 복습
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int n, m, v;
    private static StringTokenizer st;
    private static List<LinkedList<Integer>> graph;
    private static boolean[] visited;
    private static StringBuilder result;

    public static void DFS(int x) {
        LinkedList<Integer> list = graph.get(x);
        visited[x] = true;
        result.append(x+1).append(" ");

        for (int value : list) {
            if (!visited[value]) {
                DFS(value);
            }
        }
    }

    public static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        result.append(x+1).append(" ");

        while (!queue.isEmpty()) {
            int value = queue.poll();
            LinkedList<Integer> list = graph.get(value);

            for (int newValue : list) {
                if (!visited[newValue]) {
                    visited[newValue] = true;
                    queue.add(newValue);
                    result.append(newValue+1).append(" ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken())-1;

        graph = new ArrayList<>();
        for (int i=0; i < n; i++) graph.add(new LinkedList<>());

        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x-1).add(y-1);
            graph.get(y-1).add(x-1);
        }

        for (LinkedList<Integer> list : graph) Collections.sort(list);

        visited = new boolean[n];
        result = new StringBuilder();
        DFS(v);
        System.out.println(result.toString());

        visited = new boolean[n];
        result = new StringBuilder();
        BFS(v);
        System.out.println(result.toString());

        br.close();
    }
}
