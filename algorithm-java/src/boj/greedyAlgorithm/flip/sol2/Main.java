package boj.greedyAlgorithm.flip.sol2;

/*
 *   문제명 : 뒤집기
 *
 *   - https://www.acmicpc.net/problem/1439
 *   - 해설 코드
 *   - 성공
 *
 *   - 문자열의 특정 위치의 값 가져오기 : String.charAt()
 *
 * */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count0 = 0; // 전부 0으로 바꾸는 경우
        int count1 = 0; // 전부 1로 바꾸는 경우
        String data = sc.nextLine();

        if (data.charAt(0) == '1') count0++;
        else count1++;

        for (int i=0; i < data.length()-1; i++) {
            if (data.charAt(i) != data.charAt(i+1)) {
                if (data.charAt(i+1) == '1') count0++;
                else count1++;
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}
