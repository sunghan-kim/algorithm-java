package boj.graphSearchAlgorithm.advanced.hacking.sol2;

/*
 *   문제명 : 해킹
 *
 *   - https://www.acmicpc.net/problem/10282
 *   - 복습
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
    private static class Computer implements Comparable<Computer> {
        private int id;
        private int time;

        private Computer(int id, int time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(Computer c) {
            return (this.time > c.time) ? 1 : -1;
        }
    }

    private static int testCaseCnt;
    private static StringTokenizer st;
    private static int n, d, c;
    private static List<List<Computer>> graph;
    private static int a, b, s;
    private static int[] times;
    private static int hackedComputerCnt, maxTime;
    private static StringBuilder sb;

    private static void dijkstra(int startComputer) {
        PriorityQueue<Computer> queue = new PriorityQueue<>();
        queue.offer(new Computer(startComputer, 0));
        times[startComputer] = 0;

        while (!queue.isEmpty()) {
            Computer thisComputer = queue.poll();
            if (times[thisComputer.id] < thisComputer.time) continue;
            for (Computer computer : graph.get(thisComputer.id)) {
                int newTime = thisComputer.time + computer.time;
                if (times[computer.id] > newTime) {
                    times[computer.id] = newTime;
                    queue.offer(new Computer(computer.id, newTime));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCaseCnt = Integer.parseInt(br.readLine());

        for (int t=0; t < testCaseCnt; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i=0; i < n+1; i++) graph.add(new ArrayList<>());

            for (int i=0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());

                graph.get(b).add(new Computer(a, s));
            }

            times = new int[n+1];
            for (int i=0; i < n+1; i++) times[i] = Integer.MAX_VALUE;

            dijkstra(c);

            hackedComputerCnt = 0;
            maxTime = 0;

            for (int time : times) {
                if (time != Integer.MAX_VALUE) {
                    hackedComputerCnt++;
                    if (time > maxTime) maxTime = time;
                }
            }

            sb = new StringBuilder();
            sb.append(hackedComputerCnt).append(" ").append(maxTime);

            System.out.println(sb.toString());
        }

        br.close();
    }
}
