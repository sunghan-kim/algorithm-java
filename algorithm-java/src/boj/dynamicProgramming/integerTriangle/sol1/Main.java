package boj.dynamicProgramming.integerTriangle.sol1;

/*
 *   문제명 : 정수 삼각형
 *
 *   - https://www.acmicpc.net/problem/1932
 *   - 성공
 *   - 키워드
 *    - 배열 최대값 (stream)
 *
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N+1][N+1];
        int[][] DP = new int[N+1][N+1];

        for (int i=1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j < i+1; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i < N+1; i++) {
            for (int j=1; j < i+1; j++) {
                DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + A[i][j];
            }
        }

        System.out.println(Arrays.stream(DP[N]).max().getAsInt());

        br.close();
    }
}
