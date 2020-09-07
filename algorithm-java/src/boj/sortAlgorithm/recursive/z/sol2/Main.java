package boj.sortAlgorithm.recursive.z.sol2;

/*
 *   문제명 : Z
 *      - https://www.acmicpc.net/problem/1074
 *      - 블로그 참고 (https://dundung.tistory.com/48)
 *      - 성공
 *      - 이해가 잘 안됨..
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int ans = 0;
        int x = (int) Math.pow(2, n) / 2;
        int y = (int) Math.pow(2, n) / 2;

        while (n --> 0) {
            System.out.println("n : " + n);
            int temp = (int) Math.pow(2, n) / 2;
            int skip = (int) Math.pow(4, n);

            if (r < y && c < x) { // 왼쪽 위
                x -= temp;
                y -= temp;
            } else if (r < y && c >= x) { // 오른쪽 위
                x += temp;
                y -= temp;
                ans += skip;
            } else if (r >= y && c < x) { // 왼쪽 아래
                x -= temp;
                y +=  temp;
                ans += skip*2;
            } else { // 오른쪽 아래
                x += temp;
                y += temp;
                ans += skip*3;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
