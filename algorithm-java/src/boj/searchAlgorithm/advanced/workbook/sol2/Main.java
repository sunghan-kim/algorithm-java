package boj.searchAlgorithm.advanced.workbook.sol2;

/*
 *   문제명 : 문제집
 *
 *   - https://www.acmicpc.net/problem/1766
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;

    public static void topologicalSort(List<List<Integer>> tree, int[] indegree) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i=1; i <= n; i++) {
            if (indegree[i] == 0) heap.offer(i);
        }

        while (!heap.isEmpty()) {
            int data = heap.poll();
            for (int y : tree.get(data)) {
                indegree[y]--;
                if (indegree[y] == 0) heap.offer(y);
            }

            System.out.print(data + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<List<Integer>> tree = new ArrayList<>();
        int[] indegree = new int[n+1];

        for (int i=0; i < n+1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree.get(x).add(y);
            indegree[y]++;
        }

        topologicalSort(tree, indegree);

        br.close();
    }
}
