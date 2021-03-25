package boj.dynamicProgramming.sumOf2dArray.sol1;

/*
 *   문제명 : 2차원 배열의 합
 *
 *   - https://www.acmicpc.net/problem/2167
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
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < M; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] DP = new int[N+1][M+1];
        for (int i=1; i < N+1; i++) {
            for (int j=1; j < M+1; j++) {
                DP[i][j] = DP[i-1][j] + DP[i][j-1] - DP[i-1][j-1] + A[i-1][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int k=0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(DP[x][y] - DP[i-1][y] - DP[x][j-1] + DP[i-1][j-1]).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
