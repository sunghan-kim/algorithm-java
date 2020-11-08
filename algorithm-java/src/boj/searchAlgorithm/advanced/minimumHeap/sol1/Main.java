package boj.searchAlgorithm.advanced.minimumHeap.sol1;

/*
 *   문제명 : 최소 힙
 *
 *   - https://www.acmicpc.net/problem/1927
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder result = new StringBuilder();

        for (int i=0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());
            if (data == 0) result.append((minHeap.size() == 0) ? 0 : minHeap.poll()).append("\n");
            else minHeap.add(data);
        }

        System.out.println(result.toString());

        br.close();
    }
}
