package boj.graphSearchAlgorithm.advanced.hacking.sol3;

/*
 *   문제명 : 해킹
 *
 *   - https://www.acmicpc.net/problem/10282
 *   - 복습
 *   - 성공
 *
 *   - 다익스트라 알고리즘 수행 시 distances에 저장되는 값은 시작 정점에서 해당 정점까지의 최단 거리이다.
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Computer implements Comparable<Computer> {
        private int no, distance;

        private Computer(int no, int second) {
            this.no = no;
            this.distance = second;
        }

        @Override
        public int compareTo(Computer o) {
            return this.distance > o.distance ? 1 : -1;
        }
    }

    private static List<List<Computer>> graph;
    private static int[] distances;

    private static void dijkstra(int start) {
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        pq.offer(new Computer(start, 0));
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Computer now = pq.poll();
            if (distances[now.no] < now.distance) continue;
            for (Computer next : graph.get(now.no)) {
                int newDistance = now.distance + next.distance;
                if (distances[next.no] > newDistance) {
                    distances[next.no] = newDistance;
                    pq.offer(new Computer(next.no, newDistance));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for (int t=0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

            graph = new ArrayList<>();
            for (int i=0; i < n+1; i++) graph.add(new ArrayList<>());

            for (int i=0; i < d; i++)  {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph.get(b).add(new Computer(a, s));
            }

            distances = new int[n+1];
            Arrays.fill(distances, Integer.MAX_VALUE);

            dijkstra(c);

            int count = 0;
            int maxDistance = 0;
            for (int distance : distances) {
                if (distance != Integer.MAX_VALUE) {
                    count++;
                    if (maxDistance < distance) maxDistance = distance;
                }
            }

            System.out.println(count + " " + maxDistance);
        }

        br.close();
    }
}
