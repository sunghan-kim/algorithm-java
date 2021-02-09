package boj.parameters.APC.sol1;

/*
 *   문제명 : APC는 왜 서브태스크 대회가 되었을까?
 *
 *   - https://www.acmicpc.net/problem/17224
 *   - 성공(140점)
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int easy = 0;
        int hard = 0;
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sub1 = Integer.parseInt(st.nextToken());
            int sub2 = Integer.parseInt(st.nextToken());
            if (sub2 <= L) hard++;
            else if (sub1 <= L) easy++;
        }

        int scores = 0;
        // hard
        scores += Math.min(hard, K) * 140;
        // easy
        if (hard < K) scores += Math.min(K-hard, easy) * 100;

        System.out.println(scores);

        br.close();
    }
}
