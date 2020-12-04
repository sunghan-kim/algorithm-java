package boj.dynamicProgramming.tallestTowerBuilding.sol2;

/*
 *   문제명 : 가장 높은 탑 쌓기
 *
 *   - https://www.acmicpc.net/problem/2655
 *   - dp를 배열 대신 list로 구현
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

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
        public int compareTo(Block o) {
            if (this.weight > o.weight) return 1;
            return -1;
        }

        @Override
        public String toString() {
            return this.index+", "+this.width+", "+this.height+", "+this.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int maxValue;
        int idx = n;
        List<Block> blocks = new ArrayList<>();
        List<Integer> dp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        blocks.add(new Block(0,0,0,0));
        dp.add(0);

        for (int i=1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            blocks.add(new Block(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            dp.add(0);
        }

        Collections.sort(blocks);

        for (int i=1; i < n+1; i++) {
            for (int j=0; j < i; j++) {
                if (blocks.get(i).width > blocks.get(j).width) {
                    dp.set(i, Math.max(dp.get(i), dp.get(j)+blocks.get(i).height));
                }
            }
        }

        maxValue = Collections.max(dp);
        while (idx != 0) {
            if (maxValue == dp.get(idx)) {
                result.add(blocks.get(idx).index);
                maxValue -= blocks.get(idx).height;
            }
            idx--;
        }

        Collections.reverse(result);

        sb.append(result.size()).append("\n");
        for (int value : result) {
            sb.append(value).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
