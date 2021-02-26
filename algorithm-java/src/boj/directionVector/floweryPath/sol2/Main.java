package boj.directionVector.floweryPath.sol2;

/*
 *   문제명 : 꽃길
 *
 *   - https://www.acmicpc.net/problem/14620
 *   - 다른 사람 풀이
 *   - 성공
 *   - 재귀함수를 사용하여 조합(Combinations) 구현 (nC3)
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] map;
    private static int answer = Integer.MAX_VALUE;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 0, 1, -1};
    private static int[] dy = {0, 1, -1, 0, 0};

    private static void solved(int count, int cost, int y) { // count: 심은 꽃의 갯수,
        if (count >= 3) {
            answer = Math.min(answer, cost);
            return;
        }

        for (int i=y; i < n-1; i++) { // x좌표 (x=0 일때와 x=n-1 일 때의 위치에서는 상하좌우에 위치할 수 없으므로 제외)
            for (int j=1; j < n-1; j++) { // y좌표 (y=0 일때와 y=n-1 일 때의 위치에서는 상하좌우에 위치할 수 없으므로 제외)
                boolean check = true;
                for (int k=0; k < 5; k++) {
                    int ii = i + dx[k];
                    int jj = j + dy[k];
                    if (visited[ii][jj]) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    int newCost = 0;
                    for (int k=0; k < 5; k++) {
                        visited[i+dx[k]][j+dy[k]] = true;
                        newCost += map[i+dx[k]][j+dy[k]];
                    }
                    solved(count+1, cost+newCost, i);
                    for (int k=0; k < 5; k++) {
                        visited[i+dx[k]][j+dy[k]] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        int test = 0;
        solved(0, 0, 1);
        System.out.println(answer);

    }
}
