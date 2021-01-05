package boj.greedyAlgorithm.ship.sol1;

/*
 *   문제명 : 배
 *
 *   - https://www.acmicpc.net/problem/1092
 *   - 실패 -> 성공
 *
 *   - Collections.reverse()는 내림차순 정렬이 아닌 순서를 바꿔주는 것이므로
 *     내림차순 정렬을 위해서는 Collections.sort() 수행 후 reverse()를 수행하던 지,
 *     Collections.sort(Object, Collections.reverseOrder()) 를 사용해야 한다.
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
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer> cranes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++) cranes.add(Integer.parseInt(st.nextToken()));

        int m = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < m; i++) boxes.add(Integer.parseInt(st.nextToken()));

        int result;
        if (Collections.max(cranes) < Collections.max(boxes)) {
            result = -1;
        } else {
            /*
            Collections.sort(cranes);
            Collections.sort(boxes);
            Collections.reverse(cranes);
            Collections.reverse(boxes);
            */
            Collections.sort(cranes, Collections.reverseOrder());
            Collections.sort(boxes, Collections.reverseOrder());

            int[] positions = new int[n];
            boolean[] checked = new boolean[m];

            int times = 0;
            int count = 0;
            while (true) {
                if (count == boxes.size()) break;

                for (int i=0; i < n; i++) {
                    while (positions[i] < boxes.size()) {
                        if (!checked[positions[i]] && cranes.get(i) >= boxes.get(positions[i])) {
                            checked[positions[i]] = true;
                            positions[i]++;
                            count++;
                            break;
                        }
                        positions[i]++;
                    }
                }

                times++;
            }

            result = times;
        }

        System.out.println(result);

        br.close();
    }
}
