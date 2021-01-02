package boj.greedyAlgorithm.change.sol1;

/*
 *   문제명 : 거스름돈
 *
 *   - https://www.acmicpc.net/problem/5585
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int changes = 1000 - Integer.parseInt(br.readLine());
        int[] coinList = {500, 100, 50, 10, 5, 1};
        int coinCnt = 0;
        for (int coin : coinList) {
            int share = changes / coin;
            coinCnt += share;
            changes -= share * coin;
        }

        System.out.println(coinCnt);

        br.close();
    }
}
