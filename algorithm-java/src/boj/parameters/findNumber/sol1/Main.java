package boj.parameters.findNumber.sol1;

/*
 *   문제명 : 수 찾기
 *
 *   - https://www.acmicpc.net/problem/1920
 *   - 실패 (시간초과)
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) A.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (A.contains(num)) System.out.println(1);
            else System.out.println(0);
        }

        br.close();
    }
}
