package boj.graphSearchAlgorithm.advanced.communionWithTheUniverseGod.sol5;

/*
 *   문제명 : 우주신과의 교감
 *
 *   - https://www.acmicpc.net/problem/1774
 *   - 복습
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
        private int p1, p2;
        private double distance;

        private Edge(int p1, int p2, double distance) {
            this.p1 = p1;
            this.p2 = p2;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.distance, o.distance);
        }
    }

    private static PriorityQueue<Edge> edges;
    private static int[] parent;

    private static double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
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
        if (a != b) {
            parent[root2] = root1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Point[] locations = new Point[n+1];
        for (int i=1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            locations[i] = new Point(x, y);
        }

        edges = new PriorityQueue<>();
        for (int i=0; i < n-1; i++) {
            for (int j=i; j < n; j++) {
                edges.offer(new Edge(i+1, j+1, getDistance(locations[i+1], locations[j+1])));
            }
        }

        parent = new int[n+1];
        for (int i=1; i < n+1; i++) parent[i] = i;

        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        double result = 0;
        for (int i=0; i < edges.size(); i++) {
            Edge e = edges.poll();
            if (find(e.p1) != find(e.p2)) {
                union(e.p1, e.p2);
                result += e.distance;
            }
        }

        System.out.println(String.format("%.2f", result));

        br.close();
    }
}
