package boj.parameters.mixingMilk.sol1;

/*
 *   문제명 : Mixing Milk
 *
 *   - https://www.acmicpc.net/problem/16769
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] C = new int[3];
        int[] M = new int[3];

        StringTokenizer st;
        for (int i=0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            C[i] = Integer.parseInt(st.nextToken());
            M[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i < 100; i++) {
            int idx = i % 3;
            int nxt = (i+1) % 3;
            int moveAmt = Math.min(M[idx], C[nxt] - M[nxt]);
            M[idx] -= moveAmt;
            M[nxt] += moveAmt;
        }

        for (int m : M) System.out.println(m);

        br.close();
    }
}
