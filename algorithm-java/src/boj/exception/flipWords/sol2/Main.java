package boj.exception.flipWords.sol2;

/*
 *   문제명 : 단어 뒤집기 2
 *
 *   - https://www.acmicpc.net/problem/17413
 *   - 복습
 *   - 성공
 *
 * */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();

        StringBuilder temp = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        boolean check = false;

        for (int i=0; i < S.length(); i++) {
            char str = S.charAt(i);
            if (str == ' ') {
                if (check) {
                    answer.append(str);
                } else {
                    answer.append(temp.reverse().toString()).append(str);
                    temp = new StringBuilder();
                }
            } else if (str == '<') {
                check = true;
                answer.append(temp.reverse().toString()).append(str);
                temp = new StringBuilder();
            } else if (str == '>') {
                check = false;
                answer.append(str);
            } else {
                if (check) {
                    answer.append(str);
                } else {
                    temp.append(str);
                }
            }
        }

        answer.append(temp.reverse().toString());

        System.out.println(answer.toString());

        sc.close();
    }
}
