package boj.sortAlgorithm.recursive.z.sol3;

/*
 *   문제명 : Z
 *      - https://www.acmicpc.net/problem/1074
 *      - 블로그 참고 (https://titanyang.tistory.com/entry/JAVA-%EC%88%9C%ED%99%98-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-1074%EB%B2%88-Z%ED%83%90%EC%83%89%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98)
 *      - 시간 초과
 *          - 재귀용법 사용
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Z {
    int n;
    int w;
    int findX, findY;
    int cnt = -1;
    boolean flag = false;

    public Z(int n, int y, int x) {
        this.n = n;
        this.w = (int) Math.pow(2,n);
        this.findY = y;
        this.findX = x;
    }

    public void find(int x, int y, int width) {
        if (width == 1) {
            cnt++;
            if (x == findX && y == findY) {
                System.out.println(cnt);
                flag = true;
            }
            return;
        }
        if (flag) {
            return;
        }
        find(x, y, width/2);
        find(x + width/2, y, width/2);
        find(x, y + width/2, width/2);
        find(x + width/2, y + width/2, width/2);
        return;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Z z = new Z(n, r, c);
        z.find(0, 0, z.w);

        br.close();
    }
}
