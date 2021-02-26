package boj.directionVector.floweryPath.sol1;

/*
 *   문제명 : 꽃길
 *
 *   - https://www.acmicpc.net/problem/14620
 *   - 실패
 *   - 해설코드 참고
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] G;
    private static int[] dx = {0, 0, 0, 1, -1};
    private static int[] dy = {0, 1, -1, 0, 0};

    private static int getCost(int[] flowers) {
        int cost = 0;
        List<Pos> list = new ArrayList<>();
        for (int flower : flowers) {
            int x = flower / N;
            int y = flower % N;
            if (x == 0 || x == N-1 || y == 0 || y == N-1) {
                return 10000;
            }
            for (int i=0; i < 5; i++) {
                list.add(new Pos(x+dx[i], y+dy[i]));
                cost += G[x+dx[i]][y+dy[i]];
            }
        }

        if (list.size() != 15) return 10000;

        return cost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        G = new int[N][N];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < N; j++) G[i][j] = Integer.parseInt(st.nextToken());
        }

        int minCost = 10000;
        for (int f1=0; f1 < N*N; f1++) {
            for (int f2=0; f2 < N*N; f2++) {
                for (int f3=0; f3 < N*N; f3++) {
                    minCost = Math.min(minCost, getCost(new int[]{f1, f2, f3}));
                }
            }
        }

        System.out.println(minCost);

        br.close();
    }

    private static class Pos {
        int x, y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
