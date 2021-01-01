package boj.graphSearchAlgorithm.advanced.almostShortestPath.sol2;

/*
 *   문제명 : 거의 최단 경로
 *
 *   - https://www.acmicpc.net/problem/5719
 *   - 다른 사람 풀이 (https://rlaguswhd-organize.tistory.com/15)
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, s, d, ans;
    static int[] distance;
    static int[][] list;
    static PriorityQueue<Point> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            distance = new int[n];
            list = new int[n][n];

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            int now, next, cost;
            for (int i=0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                now = Integer.parseInt(st.nextToken());
                next = Integer.parseInt(st.nextToken());
                cost = Integer.parseInt(st.nextToken());
                list[now][next] = cost;
            }

            // (참고) 초기값 세팅 시 Arrays.fill() 또는 Collections.fill() 사용 가능
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[s] = 0;
            dijkstra();

            deleteNode();

            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[s] = 0;
            dijkstra();

            System.out.println(distance[d] == Integer.MAX_VALUE ? -1 : distance[d]);
        }

        br.close();
    }

    static void deleteNode() {
        Queue<Integer> q = new LinkedList<>();
        q.add(d);

        //ArrayList<Integer> temp;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i=0; i < n; i++) {
                if (list[i][now] == 0) continue;
                if (distance[now] == distance[i] + list[i][now]) {
                    list[i][now] = 0;
                    q.add(i);
                }
            }
        }
    }

    static void dijkstra() {
        pq = new PriorityQueue<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return p1.cost - p2.cost;
            }
        });

        pq.add(new Point(s, 0));
        //ArrayList<Integer> temp;

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            if (now.cost > distance[now.next]) continue;
            for (int i=0; i < n; i++) {
                if (list[now.next][i] == 0) continue;
                if (distance[now.next] + list[now.next][i] < distance[i]) {
                    distance[i] = distance[now.next] + list[now.next][i];
                    pq.add(new Point(i, distance[i]));
                }
            }
        }
    }

    static class Point {
        int next, cost;

        public Point(int next, int cost) {
            super();
            this.next = next;
            this.cost = cost;
        }
    }
}
