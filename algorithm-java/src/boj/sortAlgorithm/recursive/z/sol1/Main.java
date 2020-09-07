package boj.sortAlgorithm.recursive.z.sol1;

/*
 *   문제명 : Z
 *      - https://www.acmicpc.net/problem/1074
 *      - 실패
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int X, Y;
    public static int result = 0;

    public static void solve(int n, int x, int y) {
        if (n == 2) {
            if (x == X && y == Y) return;
            result++;
            if (x == X && y + 1 == Y) return;
            result++;
            if (x + 1 == X && y == Y) return;
            result++;
            if (x + 1 == X && y + 1 == Y) return;
            return;
        }

        int halfN = n/2;

        // solve(크기, 시작점 행 인덱스, 시작점 열 인덱스)
        // 1. 왼쪽 위
        solve(halfN, x, y);
        // 2. 오른쪽 위
        solve(halfN, x, y + halfN);
        // 3. 왼쪽 아래
        solve(halfN, x + halfN, y);
        // 4. 오른쪽 아래
        solve(halfN, x + halfN, y + halfN);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        solve((int) Math.pow(2, N), 0, 0);
        System.out.println(result);
        br.close();
    }
}
