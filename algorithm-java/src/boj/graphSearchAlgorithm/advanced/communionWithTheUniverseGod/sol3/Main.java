package boj.graphSearchAlgorithm.advanced.communionWithTheUniverseGod.sol3;

/*
 *   문제명 : 우주신과의 교감
 *
 *   - https://www.acmicpc.net/problem/1774
 *   - 다른 사람 풀이
 *   - 성공
 *
 *   - 특징 (1)
 *     - 크루스칼 알고리즘 구현 시 간선들을 길이가 짧은 순으로 정렬해야 함
 *     - 이 간선들을 우선순위큐(PriorityQueue)에 넣음으로서 별도의 정렬 로직을 수행할 필요가 없어짐
 *
 *   - 특징 (2)
 *     - parent를 HashMap 대신 배열로 간단히 구현
 *
 *   - 특징 (3)
 *     - 유클리드 거리 계산 시 Math.pow() 함수를 이용해 제곱 수행
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Point {
        private int num, x, y;

        public Point(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    public static class Node implements Comparable<Node> {
        private int start, dest;
        private double distance;

        public Node(int start, int dest, double distance) {
            this.start = start;
            this.dest = dest;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.distance, o.distance);
        }

        @Override
        public String toString() {
            return this.start + " / " + this.dest + " / " + this.distance;
        }
    }

    static int parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken()); // 우주신들의 갯수
        int k = Integer.parseInt(st.nextToken()); // 이미 연결된 길의 갯수

        parent = new int[N+1];
        for (int i=1; i <= N; i++) parent[i] = i;

        Point input[] = new Point[N+1];
        for (int i=1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            input[i] = new Point(i, x, y);
        }

        for (int i=1; i <= N; i++) {
            for (int j=i+1; j <= N; j++) {
                pq.offer(new Node(input[i].num, input[j].num, distance(input[i], input[j])));
            }
        }

        double result = 0;
        for (int i=1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }

        for (int i=0; i < pq.size(); i++) {
            Node nd = pq.poll();
            int start = nd.start;
            int end = nd.dest;

            if (find(start) == find(end)) continue;
            union(start, end);
            result += nd.distance;
        }

        System.out.println(String.format("%.2f", result));

        br.close();
    }

    private static int find(int start) {
        if (parent[start] == start) {
            return start;
        }
        return parent[start] = find(parent[start]);
    }

    private static void union(int num, int num2) {
        int x = find(num);
        int y = find(num2);

        if (x == y) return;
        parent[x] = num2;
    }

    private static double distance(Point point, Point point2) {
        double a = Math.pow(point2.x - point.x, 2);
        double b = Math.pow(point2.y - point.y, 2);
        return Math.sqrt(a + b);
    }
}
