package boj.dataStructure.advanced.findNumber.sol4;

/*
 *   문제명 : 수 찾기
 *      - https://www.acmicpc.net/problem/1920
 *      - 결과를 StringBuilder에 담아서 시간  감소시켜보기
 *      - 성공
 *          - 반복문안에서 출력하는 것보다 StringBuilder에 결과를 담는 게 더 빠르다.
 *
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i < n; i++) {
            set.add(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i < m; i++) {
            if (set.contains(st.nextToken())) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.println(sb.toString());
    }
}
