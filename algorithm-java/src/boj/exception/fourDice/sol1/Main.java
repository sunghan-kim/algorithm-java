package boj.exception.fourDice.sol1;

/*
 *   문제명 : 주사위 네개
 *
 *   - https://www.acmicpc.net/problem/2844
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
        StringTokenizer st;
        ArrayList<Integer> list;
        Set<Integer> set;

        int n = Integer.parseInt(br.readLine());

        int max_price = 0;
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
            for (int j=0; j < 4; j++) list.add(Integer.parseInt(st.nextToken()));
            Collections.sort(list);
            set = new HashSet<>(list);

            int price = 0;
            if (set.size() == 1) {
                price = 50000 + list.get(0) * 5000;
            } else if (set.size() == 2) {
                if (list.get(1) == list.get(2)) {
                    price = 10000 + list.get(1) * 1000;
                } else {
                    price = 2000 + (list.get(1) + list.get(2)) * 500;
                }
            } else if (set.size() == 3) {
                for (int j=0; j < 3; j++) {
                    if (list.get(j) == list.get(j+1)) {
                        price = 1000 + list.get(j) * 100;
                        break;
                    }
                }
            } else {
                price = Collections.max(list) * 100;
            }
            max_price = Math.max(price, max_price);
        }
        System.out.println(max_price);

        br.close();
    }
}
