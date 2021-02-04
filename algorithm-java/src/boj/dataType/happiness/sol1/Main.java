package boj.dataType.happiness.sol1;

/*
 *   문제명 : 행복
 *
 *   - https://www.acmicpc.net/problem/15969
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> scores = new ArrayList<>();
        for (int i=0; i < N; i++) scores.add(Integer.parseInt(st.nextToken()));

        System.out.println(Collections.max(scores) - Collections.min(scores));

        br.close();
    }
}
