package boj.exception.flipWords.sol1;

/*
 *   문제명 : 단어 뒤집기 2
 *
 *   - https://www.acmicpc.net/problem/17413
 *   - 성공
 *
 * */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        boolean chk = false;
        StringBuilder tmp = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for (int i=0; i < str.length(); i++) {
            char s = str.charAt(i);
            if (s == ' ') {
                if (chk) {
                    ans.append(s);
                } else {
                    ans.append(tmp.reverse().toString()).append(s);
                    tmp = new StringBuilder();
                }
            } else if (s == '<') {
                chk = true;
                ans.append(tmp.reverse().toString()).append(s);
                tmp = new StringBuilder();
            } else if (s == '>') {
                chk = false;
                ans.append(s);
            } else {
                if (chk) {
                    ans.append(s);
                } else {
                    tmp.append(s);
                }
            }
        }
        ans.append(tmp.reverse().toString());

        System.out.println(ans.toString());

        sc.close();
    }
}
