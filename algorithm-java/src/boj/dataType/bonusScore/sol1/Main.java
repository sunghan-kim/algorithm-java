package boj.dataType.bonusScore.sol1;

/*
 *   문제명 : 보너스 점수
 *
 *   - https://www.acmicpc.net/problem/17389
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        int score = 0;
        int bonus = 0;

        for (int i=0; i < N; i++) {
            if (S[i] == 'O') score += (i+1) + bonus++;
            else bonus = 0;
        }

        System.out.println(score);

        br.close();
    }
}
