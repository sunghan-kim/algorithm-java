package boj.searchAlgorithm.basic.trophyDisplay.sol2;

/*
 *   문제명 : 트로피 진열
 *
 *   - https://www.acmicpc.net/problem/1668
 *   - 파이썬 코드 참고
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static int isAscending(List<Integer> list) {
        int now = list.get(0);
        int result = 1;
        for (int i=1; i < list.size(); i++) {
            if (now < list.get(i)) {
                result++;
                now = list.get(i);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> heights = new ArrayList<>();
        for (int i=0; i < n; i++) {
            int height = Integer.parseInt(br.readLine());
            heights.add(height);
        }

        System.out.println(isAscending(heights));
        Collections.reverse(heights);
        System.out.println(isAscending(heights));

        br.close();
    }
}
