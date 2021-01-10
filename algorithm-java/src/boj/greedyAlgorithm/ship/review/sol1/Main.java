package boj.greedyAlgorithm.ship.review.sol1;

/*
 *   문제명 : 배
 *
 *   - https://www.acmicpc.net/problem/1092
 *
 * */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> cranes = new ArrayList<>();
        for (int i=0; i < n; i++) cranes.add(sc.nextInt());

        int m = sc.nextInt();
        List<Integer> boxes = new ArrayList<>();
        for (int i=0; i < m; i++) boxes.add(sc.nextInt());

        if (Collections.max(cranes) < Collections.max(boxes)) {
            System.out.println(-1);
            return;
        }

        int[] positions = new int[n];
        boolean[] checked = new boolean[m];

        Collections.sort(cranes, Collections.reverseOrder());
        Collections.sort(boxes, Collections.reverseOrder());

        int result = 0;
        int count = 0;

        while (true) {
            if (count == m) break;
            for (int i=0; i < n; i++) {
                while (positions[i] < m) {
                    if (!checked[positions[i]] && cranes.get(i) >= boxes.get(positions[i])) {
                        checked[positions[i]] = true;
                        positions[i]++;
                        count++;
                        break;
                    }
                    positions[i]++;
                }
            }
            result++;
        }

        System.out.println(result);
    }
}
