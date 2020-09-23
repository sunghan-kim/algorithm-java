package boj.searchAlgorithm.basic.bird;

/*
 *   문제명 : 새
 *
 *   - https://www.acmicpc.net/problem/1568
 *   - 성공
 * */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int birdCnt = sc.nextInt();
        int n = 0;
        int time = 0;
        while (birdCnt > 0) {
            n++;
            if (n <= birdCnt) {
                time++;
                birdCnt -= n;
            } else {
                n = 0;
            }
        }
        System.out.println(time);
    }
}
