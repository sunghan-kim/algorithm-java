package boj.parameters.findNumber.sol3;

/*
 *   문제명 : 수 찾기
 *
 *   - https://www.acmicpc.net/problem/1920
 *   - ArrayList 대신 HashSet을 사용하여 중복 데이터 제거 시도
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> A = new HashSet<>();

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