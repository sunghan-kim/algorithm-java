package boj.greedyAlgorithm.library.review.sol1;

/*
 *   문제명 : 도서관 (복습)
 *
 *   - https://www.acmicpc.net/problem/1461
 *
 * */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> array = new ArrayList<>();
        for (int i=0; i < n; i++) array.add(sc.nextInt());

        int maxValue = Math.max(Collections.max(array), -1 * Collections.min(array));

        PriorityQueue<Integer> positive = new PriorityQueue<>();
        PriorityQueue<Integer> negative = new PriorityQueue<>();

        for (int position : array) {
            if (position > 0) {
                positive.offer(-1 * position);
            } else {
                negative.offer(position);
            }
        }

        int result = 0;

        while (!positive.isEmpty()) {
            result += positive.poll();
            for (int i=0; i < m-1; i++) {
                if (!positive.isEmpty()) positive.poll();
            }
        }

        while (!negative.isEmpty()) {
            result += negative.poll();
            for (int i=0; i < m-1; i++) {
                if (!negative.isEmpty()) negative.poll();
            }
        }

        System.out.println(result * -2 - maxValue);

        sc.close();
    }
}
