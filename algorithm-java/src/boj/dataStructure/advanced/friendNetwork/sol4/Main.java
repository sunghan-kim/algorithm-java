package boj.dataStructure.advanced.friendNetwork.sol4;

/*
 *   문제명 : 친구 네트워크
 *      - https://www.acmicpc.net/problem/4195
 *      - sol3 코드 참고하여 sol2 코드 개선
 *      - 성공!!!
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<String, Integer> list;
    static int[] parent, number;
    static int MAX = 100001;

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
            number[x] += number[y];
        }
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
            number = new int[MAX];

            Arrays.fill(number, 1);

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
                sb.append(number[find(list.get(name1))]).append("\n");
            }
        }
        br.close();
        System.out.println(sb.toString());
    }
}
