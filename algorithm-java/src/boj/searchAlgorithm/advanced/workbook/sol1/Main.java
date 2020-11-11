package boj.searchAlgorithm.advanced.workbook.sol1;

/*
 *   문제명 : 문제집
 *
 *   - https://www.acmicpc.net/problem/1766
 *   - 실패
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> tree = new ArrayList<>();
        tree.add(new ArrayList<>());
        int[] inDegree = new int[n+1];

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (tree.get(x) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(y);
                tree.add(x, list);
            } else {
                tree.get(x).add(y);
            }

            inDegree[y]++;
        }

        for (int i=1; i < n+1; i++) {
            if (inDegree[i] == 0) heap.offer(i);
        }

        while (heap.size() > 0) {
            int data = heap.poll();
            result.add(data);
            for (int y : tree.get(data)) {
                inDegree[y]--;
                if (inDegree[y] == 0) heap.offer(y);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i < result.size()-1) sb.append(" ");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
