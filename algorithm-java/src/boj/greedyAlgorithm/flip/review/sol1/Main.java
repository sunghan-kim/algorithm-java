package boj.greedyAlgorithm.flip.review.sol1;

/*
 *   문제명 : 뒤집기 (복습)
 *
 *   - https://www.acmicpc.net/problem/1439
 *   - 성공
 *
 * */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();

        int flip0 = 0;
        int flip1 = 0;

        if (data.charAt(0) == '1') flip0++;
        else flip1++;

        for (int i=0; i < data.length()-1; i++) {
            if (data.charAt(i) != data.charAt(i+1)) {
                if (data.charAt(i + 1) == '1') flip0++;
                else flip1++;
            }
        }

        System.out.println(Math.min(flip0, flip1));
    }
}
