package boj.graphSearchAlgorithm.advanced.hacking.sol1;

/*
 *   문제명 : 해킹
 *
 *   - https://www.acmicpc.net/problem/10282
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        private int node;
        private int distance;

        Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n) {
            return (this.distance > n.distance) ? 1 : -1; // 거리 오름차순 ('1' 리턴 시 순서 변경)
        }
    }

    private static int test_case;
    private static StringTokenizer st;
    private static int n, d, c;
    private static List<List<Node>> graph;
    private static int a, b, s;
    private static int[] distances;
    private static int count, maxDistance;
    private static StringBuilder sb;

    private static void dijkstra(int startNode) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(startNode, 0));
        distances[startNode] = 0;

        while (!queue.isEmpty()) {
            Node nextNode = queue.poll();
            if (distances[nextNode.node] < nextNode.distance) continue;
            for (Node newNode : graph.get(nextNode.node)) {
                int newDistance = nextNode.distance + newNode.distance;
                if (distances[newNode.node] > newDistance) {
                    distances[newNode.node] = newDistance;
                    queue.offer(new Node(newNode.node, newDistance));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        test_case = Integer.parseInt(br.readLine());

        for (int t=0; t < test_case; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // n : 노드의 개수 (=컴퓨터의 개수)
            d = Integer.parseInt(st.nextToken()); // d : 간선의 개수 (=의존성 개수)
            c = Integer.parseInt(st.nextToken()); // c : 시작 노드 (=해킹된 컴퓨터)

            graph = new ArrayList<>();
            for (int i=0; i < (n+1); i++) graph.add(new ArrayList<>());

            for (int i=0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken()); // 의존하는 컴퓨터
                b = Integer.parseInt(st.nextToken()); // 의존받는 컴퓨터
                s = Integer.parseInt(st.nextToken()); // 거리

                graph.get(b).add(new Node(a, s));
            }

            distances = new int[n+1];
            for (int i=0; i < n+1; i++) distances[i] = Integer.MAX_VALUE;

            dijkstra(c);

            count = 0;
            maxDistance = 0;

            for (int distance : distances) {
                if (distance != Integer.MAX_VALUE) {
                    count++;
                    if (distance > maxDistance) {
                        maxDistance = distance;
                    }
                }
            }

            sb = new StringBuilder();
            sb.append(count).append(" ").append(maxDistance);
            System.out.println(sb.toString());
        }
        br.close();
    }
}
