package boj.greedyAlgorithm.sensor.sol1;

/*
 *   문제명 : 센서
 *
 *   - https://www.acmicpc.net/problem/2212
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
        int k = sc.nextInt();

        if (k >= n) {
            System.out.println(0);
            return;
        }

        List<Integer> sensors = new ArrayList<>();
        for (int i=0; i < n; i++) sensors.add(sc.nextInt());
        Collections.sort(sensors);

        List<Integer> distances = new ArrayList<>();
        for (int i=1; i < n; i++) distances.add(sensors.get(i) - sensors.get(i-1));
        Collections.sort(distances, Collections.reverseOrder());

        for (int i=0; i < k-1; i++) distances.set(i, 0);

        int result = 0;
        for (int distance : distances) result += distance;

        System.out.println(result);
    }
}
