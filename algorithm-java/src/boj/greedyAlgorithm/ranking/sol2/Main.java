package boj.greedyAlgorithm.ranking.sol2;

/*
 *   문제명 : 등수 매기기
 *
 *   - https://www.acmicpc.net/problem/2012
 *   - 해설 코드
 *   - 성공
 *
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> data = new ArrayList<>();

        for (int i=0; i < n; i++) {
            data.add(sc.nextInt());
        }

        Collections.sort(data);

        long result = 0;
        for (int i=1; i <= n; i++) {
            result += Math.abs(i - data.get(i-1));
        }

        System.out.println(result);
    }
}
