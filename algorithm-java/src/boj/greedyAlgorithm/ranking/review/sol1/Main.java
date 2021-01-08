package boj.greedyAlgorithm.ranking.review.sol1;

/*
 *   문제명 : 등수 매기기 (복습)
 *
 *   - https://www.acmicpc.net/problem/2012
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
        List<Integer> array = new ArrayList<>();
        for (int i=0; i < n; i++) {
            array.add(sc.nextInt());
        }

        Collections.sort(array);

        int result = 0;
        for (int i=0; i < n; i++) {
            result += Math.abs(i+1 - array.get(i));
        }

        System.out.println(result);
    }
}
