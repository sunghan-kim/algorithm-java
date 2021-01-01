package boj.graphSearchAlgorithm.advanced.almostShortestPath.sol3;

/*
 *   문제명 : 거의 최단 경로
 *
 *   - https://www.acmicpc.net/problem/5719
 *   - 다른 사람 풀이 참고하여 sol1 개선
 *   - 성공
 *     - sol1과 달리 graph를 이중배열로 선언하여 간선의 거리 값을 저장
 *     - 그러다 보니 dijkstra() 또는 bfs()에서 현재 정점에 연결된 정점들을 탐색할 때
 *       모든 정점을 탐색하게 되는 데, 간선의 거리가 0인 정점은 연결이 되어 있지 않은 것이기 때문에
 *       탐색 대상에서 제외하는 로직이 반드시 필요하다.
 *     - 요약
 *       - graph로 List 사용 시 -> List 에 포함된 정점(연결된 정점)들만 탐색
 *       - graph로 이중 배열 사용 시 -> 모든 정점의 갯수 만큼 반복하고 간선의 거리가 0인 경우에는 탐색 제외(continue)
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Node implements Comparable<Node> {
        private int no, dist;

        private Node(int no, int dist) {
            this.no = no;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            return this.dist > n.dist ? 1 : -1;
        }
    }

    private static StringTokenizer st;
    private static int n, m, start, end;
    private static int[][] graph;
    private static int[] distance;

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (distance[now.no] < now.dist) continue;
            for (int next=0; next < n; next++) {
                if (graph[now.no][next] == 0) continue; // bfs()에서 최단 경로에 해당하는 간선의 거리를 0으로 만들어 주기 때문에 거리가 0인 경우 통과
                int newDist = now.dist + graph[now.no][next];
                if (distance[next] > newDist) {
                    distance[next] = newDist;
                    pq.offer(new Node(next, newDist));
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
                if (graph[prev][now] == 0) continue; // 간선의 거리가 0인 경우는 탐색 제외
                if (distance[now] == distance[prev] + graph[prev][now]) {
                    graph[prev][now] = 0;
                    q.offer(prev);
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

            graph = new int[n][n];
            distance = new int[n];

            for (int i=0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                graph[a][b] = dist;
            }

            Arrays.fill(distance, Integer.MAX_VALUE);
            dijkstra();

            bfs();

            Arrays.fill(distance, Integer.MAX_VALUE);
            dijkstra();

            System.out.println(distance[end] == Integer.MAX_VALUE ? -1 : distance[end]);
        }

        br.close();
    }
}
