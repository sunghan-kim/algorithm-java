package boj.graphSearchAlgorithm.basic.DFSAndBFS.sol1;

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

    private static List<List<Integer>> GRAPH;

    public static String dfs(int v) {
        StringBuilder sb = new StringBuilder();
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> needVisit = new Stack<>();

        needVisit.push(v);

        for (List<Integer> list : GRAPH) {
            Collections.reverse(list);
        }

        while (!needVisit.isEmpty()) {
            int node = needVisit.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                for (Integer value : GRAPH.get(node)) {
                    needVisit.push(value);
                }
            }
        }

        for (Integer value : visited) {
            sb.append(value).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        GRAPH = new ArrayList<>();

        for (int i=0; i < n+1; i++) {
            GRAPH.add(new ArrayList<>());
        }

        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            GRAPH.get(x).add(y);
            GRAPH.get(y).add(x);
        }

        String dfsResult = dfs(v);
        System.out.println(dfsResult);

        br.close();
    }
}
