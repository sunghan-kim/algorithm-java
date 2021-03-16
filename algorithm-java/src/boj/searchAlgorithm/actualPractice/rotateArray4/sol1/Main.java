package boj.searchAlgorithm.actualPractice.rotateArray4.sol1;

/*
 *   문제명 : 배열 돌리기 4
 *
 *   - https://www.acmicpc.net/problem/17406
 *   - 성공
 *   - 이중배열 깊은 복사
 *   - DFS
 *   - 백트래킹
 *   - 방향벡터
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, K;
    private static Qry[] Q;
    private static int[] visited;
    private static int[] dr = {1, 0, -1, 0};
    private static int[] dc = {0, -1, 0, 1};
    private static int result;

    private static int[][] deepCopy(int[][] arr) {
        int[][] copied = new int[N][M];
        for (int i=0; i < N; i++) {
            for (int j=0; j < M; j++) {
                copied[i][j] = arr[i][j];
            }
        }
        return copied;
    }

    private static int getArrMin(int[][] arr) {
        int result = 10000;
        for (int i=0; i < N; i++) {
            int rowSum = 0;
            for (int j=0; j < M; j++) {
                rowSum += arr[i][j];
            }
            result = Math.min(result, rowSum);
        }
        return result;
    }

    private static int[][] convert(int[][] arr, Qry q) {
        int r = q.r-1;
        int c = q.c-1;
        int[][] newArr = deepCopy(arr);
        for (int i=1; i < q.s+1; i++) {
            int rr = r-i;
            int cc = c+i;
            for (int w=0; w < 4; w++) {
                for (int d=0; d < i*2; d++) {
                    int rrr = rr + dr[w];
                    int ccc = cc + dc[w];
                    newArr[rrr][ccc] = arr[rr][cc];
                    rr = rrr;
                    cc = ccc;
                }
            }
        }
        return newArr;
    }

    private static void dfs(int[][] arr) {
        if (Arrays.stream(visited).sum() == K) {
            result = Math.min(result, getArrMin(arr));
            return;
        }
        for (int i=0; i < K; i++) {
            if (visited[i] == 1) continue;
            int[][] newArr = convert(arr, Q[i]);
            visited[i] = 1;
            dfs(newArr);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        Q = new Qry[K];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < M; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            Q[i] = new Qry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        result = 10000;
        visited = new int[K];
        dfs(A);

        System.out.println(result);

        br.close();
    }

    private static class Qry {
        private int r;
        private int c;
        private int s;

        private Qry(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
}
