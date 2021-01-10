package boj.greedyAlgorithm.sensor.review.sol1;

/*
 *   문제명 : 센서 (복습)
 *
 *   - https://www.acmicpc.net/problem/2212
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
        int k = sc.nextInt();

        if (k >= n) {
            System.out.println(0);
            return;
        }

        List<Integer> array = new ArrayList<>();
        for (int i=0; i < n; i++) array.add(sc.nextInt());
        Collections.sort(array);

         List<Integer> distances = new ArrayList<>();
         for (int i=0; i < n-1; i++) distances.add(array.get(i+1) - array.get(i));

         Collections.sort(distances, Collections.reverseOrder());

         for (int i=0; i < k-1; i++) distances.set(i, 0);

         int result = 0;
         for (int distance : distances) result += distance;

        System.out.println(result);

        sc.close();
    }
}
