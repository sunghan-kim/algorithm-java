package boj.sortAlgorithm.advanced.sortNumber2.sol2;

/*
 *   문제명 : 수 정렬하기 2
 *      - https://www.acmicpc.net/problem/2751
 *      - 시간 초과
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
        for (int i=0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
