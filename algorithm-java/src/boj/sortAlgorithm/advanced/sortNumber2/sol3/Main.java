package boj.sortAlgorithm.advanced.sortNumber2.sol3;

/*
 *   문제명 : 수 정렬하기 2
 *      - https://www.acmicpc.net/problem/2751
 *      - 성공
 *
 *      - Collections.sort() 를 사용해서 성공한 이유 (참고 : https://st-lab.tistory.com/106)
 *          - Arrays.sort() 는 dual-pivot QuickSort 알고리즘을 사용한다.
 *          - 평균 시간복잡도는 O(nlogn)으로 좋지만 최악의 경우 시간 복잡도는 O(n^2) 이다.
 *
 *          - Collections.sort() 는 Timsort 이다.
 *          - Timsort 의 경우 반복 합병 및 삽입정렬 알고리즘을 사용한다.
 *          - 이 두 가지가 섞여 있는 정렬 알고리즘을 "hybrid stable sorting algorithm" 이라고 한다.
 *          - 합병 정렬(Merge Sort)의 경우, 최선, 최악 모두 O(nlogn) 을 보장한다.
 *          - 삽입 정렬(Insert Sort)의 경우, 최선은 O(n), 최악은 O(n^2) 이다.
 *          - 이 둘을 합친 Timsort는 시간 복잡도 O(n) ~ O(nlogn) 을 보장한다.
 */

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
        List<Integer> list = new ArrayList<>();
        for (int i=0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int a : list) {
            sb.append(a).append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
}
