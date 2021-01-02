package boj.greedyAlgorithm.flip.sol1;

/*
 *   문제명 : 뒤집기
 *
 *   - https://www.acmicpc.net/problem/1439
 *   - 실패
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int flip0 = 0;
        int flip1 = 0;

        if (str.substring(0,1) == "1") {
            flip0++;
        } else {
            flip1++;
        }

        for (int i=0; i < str.length()-1; i++) {
            String a = str.substring(i, i+1);
            String b = str.substring(i+1, i+2);
            if (!a.equals(b)) {
                if (b.equals("1")) {
                    flip0++;
                } else {
                    flip1++;
                }
            }
        }

        System.out.println(Math.min(flip0, flip1));

        br.close();
    }
}
