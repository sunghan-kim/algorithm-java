package boj.graphSearchAlgorithm.advanced.communionWithTheUniverseGod.sol4;

/*
 *   문제명 : 우주신과의 교감
 *
 *   - https://www.acmicpc.net/problem/1774
 *   - 다른 사람 풀이 참고하여 개선
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Point {
        private int x, y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Edge implements Comparable<Edge> {
        private int x, y;
        private double distance;

        private Edge(int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.distance, o.distance);
        }

        @Override
        public String toString() {
            return this.x + " / " + this.y + " / " + this.distance;
        }
    }

    private static int[] parent;

    private static double getDistance(Point p1, Point p2) {
        double x = Math.pow(p2.x - p1.x, 2);
        double y = Math.pow(p2.y - p1.y, 2);
        return Math.sqrt(x+y);
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);

        // 사이클 테이블, 즉 parent의 값은 어느 쪽을 넣어주든 상관 없다.
        if (root1 != root2) {
            parent[root2] = root1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Point[] locations = new Point[n+1];
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            locations[i+1] = new Point(x, y);
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i=0; i < n-1; i++) {
            for (int j=i; j < n; j++) {
                edges.offer(new Edge(i+1, j+1, getDistance(locations[i+1], locations[j+1])));
            }
        }
        
        parent = new int[n+1];
        for (int i=1; i < n+1; i++) {
            parent[i] = i;
        }

        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        double result = 0;
        for (int i=0; i < edges.size(); i++) {
            Edge edge = edges.poll();
            if (find(edge.x) != find(edge.y)) { // 사이클 발생 여부 확인
                union(edge.x, edge.y);
                result += edge.distance;
            }
        }

        System.out.println(String.format("%.2f", result));
    }
}
