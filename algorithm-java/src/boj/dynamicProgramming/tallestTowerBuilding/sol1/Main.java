package boj.dynamicProgramming.tallestTowerBuilding.sol1;

/*
 *   문제명 : 가장 높은 탑 쌓기
 *
 *   - https://www.acmicpc.net/problem/2655
 *   - 성공
 *   - dp를 배열 대신 list로 구현해보기
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Block implements Comparable<Block> {
        private final int index;
        private final int width;
        private final int height;
        private final int weight;

        private Block(int index, int width, int height, int weight) {
            this.index = index;
            this.width = width;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Block block) {
            if (this.weight > block.weight) return 1; // 자리 바꿈
            return -1;
        }

        @Override
        public String toString() {
            return this.index + ", " + this.width + ", " + this.height + ", " + this.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(0, 0, 0, 0));

        for (int i=1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Block block = new Block(i, width, height, weight);
            blocks.add(block);
        }

        Collections.sort(blocks);

        int[] dp = new int[N+1];

        for (int i=1; i < N+1; i++) {
            for (int j=0; j < i; j++) {
                if (blocks.get(i).width > blocks.get(j).width) {
                    dp[i] = Math.max(dp[i], dp[j] + blocks.get(i).height);
                }
            }
        }

        int maxValue = dp[0];
        for (int i=1; i < dp.length; i++) if (maxValue < dp[i]) maxValue = dp[i];
        int idx = N;
        List<Integer> result = new ArrayList<>();

        while (idx != 0) {
            if (maxValue == dp[idx]) {
                result.add(blocks.get(idx).index);
                maxValue -= blocks.get(idx).height;
            }
            idx--;
        }

        Collections.reverse(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (int r : result) {
            sb.append(r).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
