package boj.graphSearchAlgorithm.basic.DFSAndBFS.sol3;

/*
 *   문제명 : DFS와 BFS
 *
 *   - https://www.acmicpc.net/problem/1260
 *   - 다른 사람 풀이
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
    private static StringBuilder sb;

    /*DFS (Depth First Search)*/
    public static void DFS(int x) {
        LinkedList<Integer> linkedList = graph.get(x);
        visited[x] = true;
        sb.append(x+1).append(" ");

        for (int u : linkedList) {
            if (!visited[u]) {
                visited[u] = true;
                DFS(u);
            }
        }
    }

    /*BFS(Breadth First Search)*/
    public static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        sb.append(x+1).append(" ");

        while (!queue.isEmpty()) {
            int point = queue.poll();
            LinkedList<Integer> linkedList = graph.get(point);

            for (Integer nextPoint : linkedList) {
                if (!visited[nextPoint]) {
                    queue.add(nextPoint);
                    visited[nextPoint] = true;
                    sb.append(nextPoint+1).append(" ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken()) - 1;

        graph = new ArrayList<>();
        for (int i=0; i < n; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a-1).add(b-1);
            graph.get(b-1).add(a-1);
        }

        for (int i=0; i < n; i++) Collections.sort(graph.get(i));

        visited = new boolean[n];
        sb = new StringBuilder();

        DFS(v);
        System.out.println(sb.toString());

        visited = new boolean[n];
        sb = new StringBuilder();

        BFS(v);
        System.out.println(sb.toString());

        br.close();
    }
}
