package boj.searchAlgorithm.basic.trophyDisplay.sol1;

/*
 *   문제명 : 트로피 진열
 *
 *   - https://www.acmicpc.net/problem/1668
 *   - 실패
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> heights = new ArrayList<>();
        List<Integer> reversedHeights = new ArrayList<>();
        for (int i=0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            heights.add(height);
            reversedHeights.add(height);
        }

        Collections.reverse(reversedHeights);

        int cnt_f = 1, cnt_b = 1;
        int now_f, now_b;

        for (int i=0; i < heights.size()-1; i++) {
            now_f = heights.get(i);
            if (now_f < heights.get(i+1)) {
                now_f = heights.get(i+1);
                cnt_f++;
            }

            now_b = reversedHeights.get(i);
            if (now_b < reversedHeights.get(i+1)) {
                now_b = reversedHeights.get(i+1);
                cnt_b++;
            }
        }

        System.out.println(cnt_f);
        System.out.println(cnt_b);

        br.close();
    }
}
