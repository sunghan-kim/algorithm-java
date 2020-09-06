package boj.sortAlgorithm.recursive.fibonacciNumber.sol2;

/*
 *   문제명 : 피보나치 수
 *      - https://www.acmicpc.net/problem/2747
 *      - 성공
 *          - 피보나치 수를 재귀 용법을 사용하여 구현하게 되면 시간 복잡도는 O(2^n)이 된다.
 *          - 이 문제는 다이나믹 프로그래밍을 통해 해결할 수 있다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 1;

        while (n > 0) {
            int tmp = a;
            a = b;
            b = tmp + b;
            n--;
        }

        System.out.println(a);
        br.close();
    }
}
