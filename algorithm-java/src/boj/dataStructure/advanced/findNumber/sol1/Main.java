package boj.dataStructure.advanced.findNumber.sol1;

/*
 *   문제명 : 수 찾기
 *      - https://www.acmicpc.net/problem/1920
 *      - 실패 (시간초과)
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st_n = new StringTokenizer(br.readLine());
        List<Integer> A = new ArrayList<>();

        while (st_n.hasMoreTokens()) {
            A.add(Integer.parseInt(st_n.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st_m = new StringTokenizer(br.readLine());

        while (st_m.hasMoreTokens()) {
            if (A.contains(Integer.parseInt(st_m.nextToken()))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        br.close();
    }
}
