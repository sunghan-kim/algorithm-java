package boj.dataStructure.advanced.findNumber.sol2;

/*
 *   문제명 : 수 찾기
 *      - https://www.acmicpc.net/problem/1920
 *      - HashSet 활용
 *      - 성공
 *          - HashSet 을 이용하여 중복을 제거했다.
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st_n = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        while (st_n.hasMoreTokens()) {
            set.add(Integer.parseInt(st_n.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st_m = new StringTokenizer(br.readLine());
        while (st_m.hasMoreTokens()) {
            if (set.contains(Integer.parseInt(st_m.nextToken()))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}
