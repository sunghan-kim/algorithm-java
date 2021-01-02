package boj.greedyAlgorithm.ranking.sol1;

/*
 *   문제명 : 등수 매기기
 *
 *   - https://www.acmicpc.net/problem/2012
 *   - 틀림
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i=0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int result = 0;
        for (int i=1; i < n+1; i++) result += Math.abs(i - arr[i-1]);

        System.out.println(result);

        br.close();
    }
}
