package boj.graphSearchAlgorithm.basic.hideAndSeek.sol1;

/*
 *   문제명 : 숨바꼭질
 *
 *   - https://www.acmicpc.net/problem/1697
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, k;
    private static int MAX = 100001;
    private static int[] arr = new int[MAX];

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            int now_pos = queue.poll();
            if (now_pos == k) return arr[now_pos];
            int[] next_pos_list = {now_pos-1, now_pos+1, now_pos*2};
            for (int next_pos : next_pos_list) {
                if (next_pos >= 0 && next_pos < MAX && arr[next_pos] == 0) {
                    arr[next_pos] = arr[now_pos] + 1;
                    queue.offer(next_pos);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int result = bfs();
        System.out.println(result);

        br.close();
    }
}
