package boj.dynamicProgramming.LIS.sol1;

/*
 *   문제명 : 가장 긴 증가하는 부분 수열(LIS)
 *
 *   - https://www.acmicpc.net/problem/11053
 *   - 성공
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

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i=0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i=1; i < n; i++) {
            for (int j=0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        Arrays.sort(dp);

        System.out.println(dp[n-1]);

        br.close();
    }
}
