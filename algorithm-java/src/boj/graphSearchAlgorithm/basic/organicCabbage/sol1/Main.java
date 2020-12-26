package boj.graphSearchAlgorithm.basic.organicCabbage.sol1;

/*
 *   문제명 : 유기농 배추
 *
 *   - https://www.acmicpc.net/problem/1012
 *   - DFS 사용
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int testCase, m, n, k;
    private static StringTokenizer st;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int result;
    private static Point[] directions = {new Point(-1, 0), new Point(1, 0), new Point(0, -1), new Point(0, 1)};

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (Point p : directions) {
            int nx = x + p.x;
            int ny = y + p.y;
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (graph[nx][ny] == 1 && !visited[nx][ny]) dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());

        for (int t=0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            graph = new int[m][n];
            visited = new boolean[m][n];

            for (int i=0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = 1;
            }

            result = 0;

            for (int i=0; i < m; i++) {
                for (int j=0; j < n; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }

        br.close();
    }
}
