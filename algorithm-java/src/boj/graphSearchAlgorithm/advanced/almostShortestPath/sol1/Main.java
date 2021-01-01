package boj.graphSearchAlgorithm.advanced.almostShortestPath.sol1;

/*
 *   문제명 : 거의 최단 경로
 *
 *   - https://www.acmicpc.net/problem/5719
 *   - 로컬에선 성공
 *   - 제출 시에는 메모리 초과
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Node implements Comparable<Node>{
        private int no;
        private int dist;

        private Node(int no, int dist) {
            this.no = no;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            return (this.dist > n.dist) ? 1 : -1;
        }
    }

    private static StringTokenizer st;
    private static int n, m, start, end;
    private static List<List<Node>> graph, reversedGraph;
    private static boolean[][] dropped;
    private static int[] distances;

    private static void dijkstra() {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.offer(new Node(start, 0));
        distances[start] = 0;

        while (!heap.isEmpty()) {
            Node now = heap.poll();
            if (distances[now.no] < now.dist) continue;
            for (Node next : graph.get(now.no)) {
                int newDist = now.dist + next.dist;
                if (distances[next.no] > newDist && !dropped[now.no][next.no]) {
                    distances[next.no] = newDist;
                    heap.offer(new Node(next.no, newDist));
                }
            }
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(end);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == start) continue;
            for (Node prev : reversedGraph.get(now)) {
                if (distances[now] == distances[prev.no] + prev.dist) {
                    dropped[prev.no][now] = true;
                    queue.offer(prev.no);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            reversedGraph = new ArrayList<>();
            for (int i=0; i < n+1; i++) {
                graph.add(new ArrayList<>());
                reversedGraph.add(new ArrayList<>());
            }

            for (int i=0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Node(b, dist));
                reversedGraph.get(b).add(new Node(a, dist));
            }

            dropped = new boolean[n+1][n+1];

            distances = new int[n+1];
            for (int i=0; i < n+1; i++) distances[i] = Integer.MAX_VALUE;
            dijkstra();

            bfs();

            distances = new int[n+1];
            for (int i=0; i < n+1; i++) distances[i] = Integer.MAX_VALUE;
            dijkstra();

            int result = (distances[end] != Integer.MAX_VALUE) ? distances[end] : -1;
            System.out.println(result);
        }

        br.close();
    }
}
