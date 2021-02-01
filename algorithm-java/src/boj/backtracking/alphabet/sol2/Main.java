package boj.backtracking.alphabet.sol2;

/*
 *   문제명 : 알파벳
 *
 *   - https://www.acmicpc.net/problem/1987
 *   - 다른 사람 풀이 (https://geehye.github.io/baekjoon-1987/)
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, max = 0;
    static char[][] arr;
    static boolean[] visited; // 각 알파벳을 방문했는 지의 여부

    private static void dfs(int x, int y, int d) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // arr[x][y] - 'A' : 각 알파벳의 아스키코드에서 'A'의 아스키 코드를 뺀 값 (A=0, B=1, C=2, ...)
        visited[arr[x][y] - 'A'] = true;
        for (int i=0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx > 0 && yy > 0 && xx <= r && yy <= c) {
                if (!visited[arr[xx][yy] - 'A']) dfs(xx, yy, d+1);
            }
        }

        visited[arr[x][y] - 'A'] = false;
        max = Math.max(max, d);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r+1][c+1];
        visited = new boolean[26]; // 알파벳 갯수

        for (int i=1; i <= r; i++) {
            String str = br.readLine();
            for (int j=1; j <= c; j++) arr[i][j] = str.charAt(j-1);
        }

        dfs(1, 1, 1);

        System.out.println(max);

        br.close();
    }
}
