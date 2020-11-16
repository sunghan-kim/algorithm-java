package boj.dynamicProgramming.ordinaryBackpack.sol1;

/*
 *   문제명 : 평범한 배낭
 *
 *   - https://www.acmicpc.net/problem/12865
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][k+1];

        for (int i=1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for (int j=1; j < k+1; j++) {
                if (j < weight) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight]+value);
                }
            }
        }

        System.out.println(dp[n][k]);

        br.close();
    }
}
