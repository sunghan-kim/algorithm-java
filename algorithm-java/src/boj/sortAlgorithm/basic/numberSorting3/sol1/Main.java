package boj.sortAlgorithm.basic.numberSorting3.sol1;

/*
 *   문제명 : 수 정렬하기 3
 *      - https://www.acmicpc.net/problem/10989
 *      - 성공
 *      - 계수 정렬 활용 연습 필요
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i=0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a).append("\n");
        }
        br.close();
        System.out.println(sb.toString());
    }
}
