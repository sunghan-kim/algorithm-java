package boj.backtracking.alphabet.sol4;

/*
 *   문제명 : 알파벳
 *
 *   - https://www.acmicpc.net/problem/1987
 *   - 다른 사람 풀이
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int ROW, COL;
    private static int[][] arr;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static boolean[] visited;
    private static int step = 1;
    private static int max_step = 1;

    private static void dfs(int x, int y) {
        int alpha = arr[x][y];
        visited[alpha] = true;

        for (int i=0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx < 0 || yy < 0 || xx >= ROW || yy >= COL) continue;

            int nextAlpha = arr[xx][yy];
            if (visited[nextAlpha]) continue;

            max_step = Math.max(max_step, ++step);

            dfs(xx, yy);
        }
        // 여기서 초기화 하지 않으면 다른 경로에 접근할 수 없다.
        step--;
        visited[alpha] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());
        arr = new int[ROW][COL];

        for (int i=0; i < ROW; i++) {
            String str = br.readLine();
            for (int j=0; j < COL; j++) {
                arr[i][j] = (int) str.charAt(j) - 65; // 알파벳 아스키 코드 인덱스
            }
        }

        visited = new boolean[26]; // 알파벳 방문 여부
        dfs(0, 0);

        System.out.println(max_step);

        br.close();
    }
}
