package boj.dynamicProgramming.tile01.sol1;

/*
 *   문제명 : 01타일
 *
 *   - https://www.acmicpc.net/problem/1904
 *   - 성공
 *
 * */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1000001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i < n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        System.out.println(dp[n]);
    }
}
