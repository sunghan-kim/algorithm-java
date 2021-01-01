package boj.graphSearchAlgorithm.advanced.communionWithTheUniverseGod.sol1;

/*
 *   문제명 : 우주신과의 교감
 *
 *   - https://www.acmicpc.net/problem/1774
 *   - 로컬에선 성공
 *   - 제출 시 런타임 에러 발생
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        private double cost;

        private Edge(int x, int y, double cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost > e.cost ? 1 : -1;
        }

        @Override
        public String toString() { // 확인용
            return this.x + " / " + this.y + " / " + this.cost;
        }
    }

    private static StringTokenizer st;
    private static int n, m;
    private static List<Point> locations;
    private static List<Edge> edges;
    private static HashMap<Integer, Integer> parent;
    private static double result;

    private static double getDistance(Point p1, Point p2) {
        int x = p1.x - p2.x;
        int y = p1.y - p2.y;
        return Math.sqrt((x*x) + (y*y));
    }

    private static int getParent(int n) {
        if (parent.get(n) == n) {
            return n;
        }
        return getParent(parent.get(n));
    }

    private static void unionParent(int a, int b) {
        int pa = getParent(a);
        int pb = getParent(b);

        if (pa > pb) parent.put(pb, pa);
        else if (pa < pb) parent.put(pa, pb);
    }

    private static boolean findParent(int a, int b) {
        /*
        int pa = getParent(a);
        int pb = getParent(b);
        return pa == pb;
        */
        return getParent(a) == getParent(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        locations = new ArrayList<>();
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            locations.add(new Point(x, y));
        }

        edges = new ArrayList<>();
        for (int i=0; i < locations.size()-1; i++) {
            for (int j=i; j < locations.size(); j++) {
                edges.add(new Edge(i+1, j+1, getDistance(locations.get(i), locations.get(j))));
            }
        }

        /*
        for (Edge e : edges) {
            System.out.println(e.toString());
        }
        */

        parent = new HashMap<>();
        for (int i=1; i < n+1; i++) parent.put(i, i);

        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            unionParent(a, b);
        }

        Collections.sort(edges);

        /*
        for (Edge e : edges) {
            System.out.println(e.toString());
        }
        */

        result = 0D;
        for (Edge edge : edges) {
            if (!findParent(edge.x, edge.y)) {
                unionParent(edge.x, edge.y);
                result += edge.cost;
            }
        }

        System.out.println(String.format("%.2f", result));

        br.close();
    }
}
