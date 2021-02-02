package boj.backtracking.alphabet.sol3;

/*
 *   문제명 : 알파벳
 *
 *   - https://www.acmicpc.net/problem/1987
 *   - 다른 사람 풀이
 *   - 성공
 *
 * */

import java.util.Scanner;

public class Main {
    private static int r, c;
    private static int[] check;
    private static int[][] a;
    private static int result = 0;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    private static void dfs(int x, int y, int count) {
        result = Math.max(result, count);
        for (int i=0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if (check[a[nx][ny]] == 0) { // 해당 알파벳을 아직 방문하지 않은 경우
                    check[a[nx][ny]]++;
                    dfs(nx, ny, count+1);
                    check[a[nx][ny]]--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();

        check = new int[26];
        a = new int[r][c];

        for (int i=0; i < r; i++) {
            String row = sc.next();
            char[] temp = row.toCharArray();
            for (int j=0; j < c; j++) {
                a[i][j] = temp[j] - 'A';
            }
        }

        check[a[0][0]] = 1; // 좌측 상단 지점 방문
        dfs(0, 0, 1);

        System.out.println(result);
    }
}
