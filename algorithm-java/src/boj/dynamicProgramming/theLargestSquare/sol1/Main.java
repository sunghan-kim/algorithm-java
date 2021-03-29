package boj.dynamicProgramming.theLargestSquare.sol1;

/*
 *   문제명 : 가장 큰 정사각형
 *
 *   - https://www.acmicpc.net/problem/1915
 *   - 성공
 *   - char to int : Character.getNumericValue(char);
 *   - Math.pow() result to int : (int) Math.pow(4,2);
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] A = new int[n+1][m+1];

        // DP[i][j] : (i,j) 까지 왔을 때 가장 큰 정사각형의 한 변의 길이
        // DP[i][j] = Math.min(왼쪽의 DP, 대각선의 DP, 위쪽의 DP) + 1;
        int[][] DP = new int[n+1][m+1];

        for (int i=0; i < n; i++) {
            String row = br.readLine();
            for (int j=0; j < m; j++) {
                A[i+1][j+1] = Character.getNumericValue(row.charAt(j));
            }
        }

        for (int i=1; i < n+1; i++) {
            for (int j=1; j < m+1; j++) {
                if (A[i][j] == 1) DP[i][j] = Math.min(Math.min(DP[i-1][j], DP[i-1][j-1]), DP[i][j-1]) + 1;
            }
        }

        int result = 0;
        for (int i=0; i < n+1; i++) {
            for (int j=0; j < m+1; j++) {
                result = Math.max(result, DP[i][j]);
            }
        }

        System.out.println((int) Math.pow(result, 2));

        br.close();
    }
}
