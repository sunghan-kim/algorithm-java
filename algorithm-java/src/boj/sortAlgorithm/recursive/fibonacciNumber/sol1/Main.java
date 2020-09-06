package boj.sortAlgorithm.recursive.fibonacciNumber.sol1;

/*
 *   문제명 : 피보나치 수
 *      - https://www.acmicpc.net/problem/2747
 *      - 실패 (시간 초과)
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = fibonacci(n);
        br.close();
        System.out.println(result);
    }
}
