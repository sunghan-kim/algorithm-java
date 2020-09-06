package boj.sortAlgorithm.basic.numberSorting3.sol2;

/*
 *   문제명 : 수 정렬하기 3
 *      - https://www.acmicpc.net/problem/10989
 *      - 계수 정렬(Counting Sort) 기법 사용
 *      - 성공
 *      - sol1에 비해 메모리, 시간 모두 감소함
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        for (int i=0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i < arr.length; i++) {
            if (arr[i] != 0) {
                for (int j=0; j < arr[i]; j++) {
                    sb.append(i).append("\n");
                }
            }
        }
        br.close();
        System.out.println(sb.toString());
    }
}
