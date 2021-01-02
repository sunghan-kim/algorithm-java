package boj.graphSearchAlgorithm.advanced.almostShortestPath.sol4;

/*
 *   문제명 : 거의 최단 경로
 *
 *   - https://www.acmicpc.net/problem/5719
 *   - 복습
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Node implements Comparable<Node> {
        private int no, distance;

        private Node(int no, int distance) {
            this.no = no;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance > o.distance ? 1 : -1;
        }
    }
    private static int[][] graph;
    private static int[] distances;
    private static int n, m;
    private static int start, end;

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (distances[now.no] < now.distance) continue;
            for (int next=0; next < n; next++) {
                if (graph[now.no][next] == 0) continue;
                int newDistance = now.distance + graph[now.no][next];
                if (distances[next] > newDistance) {
                    distances[next] = newDistance;
                    pq.offer(new Node(next, newDistance));
                }
            }
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(end);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int prev=0; prev < n; prev++) {
                if (graph[prev][now] == 0) continue;
                if (distances[now] == distances[prev] + graph[prev][now]) {
                    graph[prev][now] = 0;
                    q.offer(prev);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            graph = new int[n][n];
            distances = new int[n];

            for (int i=0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                graph[u][v] = p;
            }

            Arrays.fill(distances, Integer.MAX_VALUE);
            dijkstra(); // 각 노드별 시작 정점으로 부터의 최단 거리 계산
            
            bfs(); // 최단 경로에 포함되는 간선 0으로 초기화

            Arrays.fill(distances, Integer.MAX_VALUE);
            dijkstra(); // 다시 각 노드별 시작 정점으로 부터의 최단 거리 계산

            System.out.println(distances[end] == Integer.MAX_VALUE ? -1 : distances[end]);
        }
        br.close();
    }
}
