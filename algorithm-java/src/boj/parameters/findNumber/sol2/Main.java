package boj.parameters.findNumber.sol2;

/*
 *   문제명 : 수 찾기
 *
 *   - https://www.acmicpc.net/problem/1920
 *   - 출력을 반복문 안에서 하지 않고 StringBuilder로 만들기 시도
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
        StringBuilder sb;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) A.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        for (int i=0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (A.contains(num)) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}