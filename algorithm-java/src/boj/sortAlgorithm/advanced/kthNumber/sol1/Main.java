package boj.sortAlgorithm.advanced.kthNumber.sol1;

/*
 *   문제명 : K 번째 수
 *      - https://www.acmicpc.net/problem/11004
 *      - 성공
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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> a = new ArrayList<>();

        while (st.hasMoreTokens()) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(a);

        System.out.println(a.get(k-1));

        br.close();
    }
}
