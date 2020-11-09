package boj.searchAlgorithm.advanced.sortingCards.sol1;

/*
 *   문제명 : 카드 정렬하기
 *
 *   - https://www.acmicpc.net/problem/1715
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
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i=0; i < n; i++) {
            int data = Integer.parseInt(br.readLine());
            heap.add(data);
        }

        int result = 0;
        while (heap.size() != 1) {
            int firstVal = heap.poll();
            int secondVal = heap.poll();
            int sumVal = firstVal + secondVal;
            result += sumVal;
            heap.add(sumVal);
        }

        System.out.println(result);

        br.close();
    }
}
