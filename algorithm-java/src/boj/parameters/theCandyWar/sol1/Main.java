package boj.parameters.theCandyWar.sol1;

/*
 *   문제명 : The candy war
 *
 *   - https://www.acmicpc.net/problem/9037
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] C;

    private static void makeEven() {
        for (int i=0; i < N; i++) if (C[i] % 2 == 1) C[i]++;
    }

    private static boolean check() {
        int firstVal = C[0];
        for (int i=1; i < N; i++) {
            if (C[i] != firstVal) return false;
        }
        return true;
    }

    private static void transfer() {
        int[] temp = new int[N];
        for (int i=0; i < N; i++) {
            temp[i] = C[i] / 2;
            C[i] /= 2;
        }
        C[0] += temp[N-1];
        for (int i=1; i < N; i++) C[i] += temp[i-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t=0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            C = new int[N];
            for (int i=0; i < N; i++) C[i] = Integer.parseInt(st.nextToken());
            makeEven();
            int cycle = 0;
            while (!check()) {
                transfer();
                makeEven();
                cycle++;
            }
            sb.append(cycle).append("\n");
        }
        System.out.println(sb.toString());

        br.close();
    }
}
