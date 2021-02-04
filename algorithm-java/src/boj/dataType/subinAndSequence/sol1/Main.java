package boj.dataType.subinAndSequence.sol1;

/*
 *   문제명 : 수빈이와 수열
 *
 *   - https://www.acmicpc.net/problem/10539
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int sum(int[] array) {
        int result = 0;
        for (int a : array) {
            if (a > 0) result += a;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] B = new int[N];
        for (int i=0; i < N; i++) B[i] = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        A[0] = B[0];

        for (int i=1; i < N; i++) A[i] = B[i] * (i+1) - sum(A);

        StringBuilder sb = new StringBuilder();
        for (int a : A) sb.append(a).append(" ");

        System.out.println(sb.toString());

        br.close();
    }
}
