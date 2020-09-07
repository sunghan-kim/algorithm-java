package boj.sortAlgorithm.recursive.makeZero.sol1;

/*
 *   문제명 : 0 만들기
 *      - https://www.acmicpc.net/problem/7490
 *      - 성공
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int target = 0;

    static void dfs(int sum, int sign, int num, int now, String c) {
        if (now == target) {
            sum += (num * sign);
            if (sum == 0) {
                System.out.println(c);
            }
            return;
        }
        dfs(sum, sign, num*10 + (now+1), now+1, c + " " + String.valueOf(now+1));
        dfs(sum + (sign*num), 1, now+1, now+1, c + "+" + String.valueOf(now+1));
        dfs(sum + (sign*num), -1, now+1, now+1, c + "-" + String.valueOf(now+1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            target = Integer.parseInt(br.readLine());
            String c = "1";
            dfs(0, 1, 1, 1, c); // sum, sign, num, next, str
            System.out.println(" ");
        }

        br.close();
    }
}
