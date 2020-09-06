package boj.dataStructure.advanced.friendNetwork.sol3;

/*
 *   문제명 : 친구 네트워크
 *      - https://www.acmicpc.net/problem/4195
 *      - 블로그 참고 : https://soobarkbar.tistory.com/180
 *      - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, Integer> list;
    static int[] parent, rank, relation;
    static int MAX = 100001;

    public static void swap(int n1, int n2) {
        int temp = n1;
        n1 = n2;
        n2 = temp;
    }

    public static int find(int u) {
        if (parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }

    public static void union(int u, int v) {
        int uR = find(u);
        int vR = find(v);

        if (uR == vR) return;

        if (rank[uR] > rank[vR]) swap(uR, vR);

        parent[uR] = vR;
        relation[vR] += relation[uR];

        if (rank[uR] == rank[vR]) rank[vR]++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i=0; i < testCase; i++) {
            int F = Integer.parseInt(br.readLine());
            int idx = 0;
            list = new HashMap<>();
            parent = new int[MAX];
            rank = new int[MAX];
            relation = new int[MAX];

            Arrays.fill(relation, 1);

            for (int j=0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if (!list.containsKey(name1)) {
                    list.put(name1, idx);
                    parent[idx] = idx++;
                }
                if (!list.containsKey(name2)) {
                    list.put(name2, idx);
                    parent[idx] = idx++;
                }

                union(list.get(name1), list.get(name2));
                sb.append(relation[find(list.get(name1))]).append("\n");
            }
        }
        br.close();
        System.out.println(sb.toString());
    }
}
