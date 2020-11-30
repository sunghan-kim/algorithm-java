package boj.dynamicProgramming.guitarlist.sol1;

/*
 *   문제명 : 기타리스트
 *
 *   - https://www.acmicpc.net/problem/1495
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
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] V = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i < N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][M+1];
        dp[0][S] = 1;

        for (int i=1; i < N+1; i++) {
            for (int j=0; j < M+1; j++) {
                if (dp[i-1][j] == 0) continue;
                if (j - V[i-1] >= 0) dp[i][j-V[i-1]] = 1;
                if (j + V[i-1] <= M) dp[i][j+V[i-1]] = 1;
            }
        }

        int result = -1;

        for (int i=M; i > -1; i--) {
            if (dp[N][i] == 1) {
                result = i;
                break;
            }
        }

        System.out.println(result);

        br.close();
    }
}
