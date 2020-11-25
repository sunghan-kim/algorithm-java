package boj.dynamicProgramming.LCS.sol1;

/*
 *   문제명 : 가장 긴 공통 부분 수열(LCS)
 *
 *   - https://www.acmicpc.net/problem/9251
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String X = br.readLine();
        String Y = br.readLine();

        int[][] dp = new int[X.length()+1][Y.length()+1];

        for (int i=1; i < X.length()+1; i++) {
            for (int j=1; j < Y.length()+1; j++) {
                if (X.charAt(i-1) == Y.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[X.length()][Y.length()]);

        br.close();
    }
}
