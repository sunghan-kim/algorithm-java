package boj.exception.threeDice.sol1;

/*
 *   문제명 : 주사위 세개
 *
 *   - https://www.acmicpc.net/problem/2840
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i < 3; i++) list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);

        Set<Integer> set = new HashSet<>(list);

        int result = (set.size() == 1) ? 10000 + list.get(0) * 1000 : (set.size() == 2) ? 1000 + list.get(1) * 100 : Collections.max(list) * 100;
        System.out.println(result);

        br.close();
    }
}
