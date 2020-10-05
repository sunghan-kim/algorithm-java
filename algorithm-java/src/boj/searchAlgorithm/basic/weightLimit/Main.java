package boj.searchAlgorithm.basic.weightLimit;

/*
 *   문제명 : 중량 제한
 *
 *   - https://www.acmicpc.net/problem/1939
 *   - 실패 (메모리 초과)
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N;
    public static int M;
    public static int START_NODE;
    public static int END_NODE;
    public static Map<Integer, List<Map<Integer, Integer>>> ADJ;

    public static void insertADJ(int key, Map<Integer, Integer> map) {
        List<Map<Integer, Integer>> list = new ArrayList<>();
        if (ADJ.get(key) != null) list.addAll(ADJ.get(key));
        list.add(map);
        ADJ.put(key, list);
    }

    public static boolean bfs(int C) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(START_NODE);
        boolean[] visited = new boolean[N + 1];
        visited[START_NODE] = true;

        while (queue.size() > 0) {
            int x = queue.pollFirst();
            for (Map<Integer, Integer> map : ADJ.get(x)) {
                int y = 0;
                int weight = 0;
                for (Map.Entry<Integer, Integer> elem : map.entrySet()) {
                    y = elem.getKey();
                    weight = elem.getValue();
                }
                if (!visited[y] && weight >= C) {
                    visited[y] = true;
                    queue.offer(y);
                }
            }
        }

        return visited[END_NODE];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ADJ = new HashMap<>();
        Map<Integer, Integer> map1;
        Map<Integer, Integer> map2;
        int start = 1000000000;
        int end = 1;

        for (int i=0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map1 = new HashMap<>();
            map1.put(y, weight);
            map2 = new HashMap<>();
            map2.put(x, weight);

            insertADJ(x, map1);
            insertADJ(y, map2);

            start = Math.min(start, weight);
            end = Math.max(end, weight);
        }

        st = new StringTokenizer(br.readLine());
        START_NODE = Integer.parseInt(st.nextToken());
        END_NODE = Integer.parseInt(st.nextToken());

        int result = start;

        while (start <= end) {
            int mid = Math.floorDiv(start + end, 2);
            if (bfs(mid)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);

        br.close();
    }
}
