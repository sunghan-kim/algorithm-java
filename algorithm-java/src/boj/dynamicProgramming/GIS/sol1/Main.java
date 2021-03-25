package boj.dynamicProgramming.GIS.sol1;

/*
 *   문제명 : 가장 큰 증가 부분 수열 (GIS, Greatest Increasing Subsequence)
 *
 *   - https://www.acmicpc.net/problem/11055
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] copyArr(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i=0; i < newArr.length; i++) newArr[i] = arr[i];
        return newArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] DP = copyArr(A);

        for (int i=1; i < N; i++) {
            for (int j=0; j < i; j++) {
                if (A[j] < A[i]) DP[i] = Math.max(DP[j] + A[i], DP[i]);
            }
        }

        System.out.println(Arrays.stream(DP).max().getAsInt());

        br.close();
    }
}
