package boj.dataStructure.basic.blackjack;

/*
 *   문제명 : 블랙잭
 *     - https://www.acmicpc.net/problem/2798
 * */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] numbers = new int [n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        sc.close();

        int result = 0;

        for (int i = 0; i < numbers.length-2; i++) {
            for (int j = i+1; j < numbers.length - 1; j++) {
                for (int k = j+1; k < numbers.length; k++) {
                    int value = numbers[i] + numbers[j] + numbers[k];
                    if (value <= m) {
                        result = Math.max(result, value);
                    }
                }
            }
        }
        System.out.println(result);
    }
}
