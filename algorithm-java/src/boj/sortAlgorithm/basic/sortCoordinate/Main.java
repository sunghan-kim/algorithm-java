package boj.sortAlgorithm.basic.sortCoordinate;

/*
 *   문제명 : 좌표 정렬하기
 *      - https://www.acmicpc.net/problem/11650
 *      - 성공
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point p) {
        if (this.x > p.x) {
            return 1;
        } else if (this.x == p.x) {
            if (this.y > p.y) {
                return 1;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();

        for (int i=0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Point p : list) {
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }
        br.close();

        System.out.println(sb.toString());
    }
}
