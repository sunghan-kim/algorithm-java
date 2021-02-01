package boj.backtracking.nQueen.sol1;

/*
 *   문제명 : N-Queen
 *
 *   - https://www.acmicpc.net/problem/9663
 *   - 성공
 *
 * */

import java.util.Scanner;

public class Main {
    public static int n;
    public static int[] row;
    public static int result;

    public static boolean check(int x) {
        for (int i=0; i < x; i++) {
            if (row[x] == row[i]) return false; // 수직 체크
            if (Math.abs(row[x] - row[i]) == x - i) return false; // 대각선 체크
        }
        return true;
    }

    public static void dfs(int x) {
        if (n == x) {
            result++;
        } else {
            for (int i=0; i < n; i++) {
                row[x] = i;
                if (check(x)) {
                    dfs(x+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        row = new int[n];

        result = 0;
        dfs(0);

        System.out.println(result);
    }
}
