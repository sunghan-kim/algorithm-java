package boj.greedyAlgorithm.change.review.sol1;

/*
 *   문제명 : 거스름돈 (복습)
 *
 *   - https://www.acmicpc.net/problem/5585
 *   - 성공
 *
 * */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int changes = 1000 - sc.nextInt();
        int[] coins = {500, 100, 50, 10, 5, 1};
        int coinCnt = 0;
        for (int coin : coins) {
            int val = changes / coin;
            coinCnt += val;
            changes -= coin * val;
        }
        System.out.println(coinCnt);
    }
}
