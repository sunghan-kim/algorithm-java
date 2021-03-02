package boj.search.organicCabbage.sol1;

/*
 *   문제명 : 유기농 배추
 *
 *   - https://www.acmicpc.net/problem/1012
 *   - DFS 활용
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br;
    private static StringTokenizer st;
    private static int M, N, K;
    private static int[][] field;
    private static boolean[][] visited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static StringBuilder result = new StringBuilder();

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i=0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if (field[nx][ny] == 0 || visited[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    private static void process() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로 (열)
        N = Integer.parseInt(st.nextToken()); // 세로 (행)
        K = Integer.parseInt(st.nextToken());

        field = new int[N+2][M+2];
        visited = new boolean[N+2][M+2];

        for (int i=0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 열 인덱스
            int n = Integer.parseInt(st.nextToken()); // 행 인덱스
            field[n+1][m+1] = 1;
        }
        int bugCnt = 0;
        for (int x=1; x < N+1; x++) {
            for (int y=1; y < M+1; y++) {
                if (field[x][y] != 0 && !visited[x][y]) {
                    dfs(x, y);
                    bugCnt++;
                }
            }
        }

        result.append(bugCnt).append("\n");

    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i=0; i < T; i++) process();

        System.out.println(result.toString());

        br.close();
    }
}
