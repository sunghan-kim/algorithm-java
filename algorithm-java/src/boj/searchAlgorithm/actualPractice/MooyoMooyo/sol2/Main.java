package boj.searchAlgorithm.actualPractice.MooyoMooyo.sol2;

/*
 *   문제명 : Mooyo Mooyo
 *
 *   - https://www.acmicpc.net/problem/16768
 *   - down() 에서 Queue 사용
 *   - 성공
 *     - sol1 와 성능 유사하게 나옴
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, K;
    private static int[][] M;
    private static boolean[][] visited1;
    private static boolean[][] visited2;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    private static int dfs_find(int x, int y) {
        visited1[x][y] = true;
        int cnt = 1;
        for (int i=0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= 10) continue;
            if (visited1[nx][ny] || M[x][y] != M[nx][ny]) continue;
            cnt += dfs_find(nx, ny);
        }
        return cnt;
    }

    private static void dfs_delete(int x, int y, int val) {
        visited2[x][y] = true;
        M[x][y] = 0;
        for (int i=0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= 10) continue;
            if (visited2[nx][ny] || M[nx][ny] != val) continue;
            dfs_delete(nx, ny, val);
        }
    }

    private static void down() {
        for (int i = 0; i < 10; i++) {
            Queue<Integer> tmp = new LinkedList<>();
            for (int j = 0; j < N; j++) if (M[j][i] != 0) tmp.offer(M[j][i]); // 0이 아닌 값들 임시 리스트(list)에 저장
            for (int j = 0; j < N - tmp.size(); j++) M[j][i] = 0; // 0이 아닌 값들을 제외한 나머지 값들의 자리에 0으로 채움
            for (int j = N - tmp.size(); j < N; j++) M[j][i] = tmp.poll();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        M = new int[N][10];
        for (int i=0; i < N; i++) {
            String str = br.readLine();
            for (int j=0; j < 10; j++) {
                M[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        while (true) {
            boolean existed = false;
            visited1 = new boolean[N][10];
            visited2 = new boolean[N][10];

            for (int i=0; i < N; i++) {
                for (int j=0; j < 10; j++) {
                    if (M[i][j] == 0 || visited1[i][j]) continue;
                    int groupCnt = dfs_find(i, j); // 그룹 내 원소 갯수 카운트
                    if (groupCnt >= K) {
                        dfs_delete(i, j, M[i][j]); // 그룹 원소 삭제
                        existed = true;
                    }
                }
            }

            if (!existed) break;
            down(); // 나머지 원소 아래로 이동
        }

        for (int i=0; i < N; i++) {
            for (int j=0; j < 10; j++) System.out.print(M[i][j]);
            System.out.println();
        }

        br.close();
    }
}