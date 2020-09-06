package boj.sortAlgorithm.basic.sortInside.sol1;

/*
 *   문제명 : 소트인사이드
 *      - https://www.acmicpc.net/problem/1427
 *      - 성공
 *      - 리스트 객체 내림차순 정렬 기법 학습
 *          - Collections.sort(list, Collections.reverseOrder());
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
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split("");
        List<Integer> list = new ArrayList<>();
        for (String a : arr) {
            list.add(Integer.parseInt(a));
        }

        list.sort(Collections.reverseOrder()); // == Collections.sort(list, Collections.reverseOrder());

        for (int l : list) {
            sb.append(l);
        }

        br.close();
        System.out.println(sb.toString());
    }
}
