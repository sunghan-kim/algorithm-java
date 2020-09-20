package boj.searchAlgorithm.basic.documentSearch;

/*
 *   문제명 : 문서 찾기
 *
 *   - https://www.acmicpc.net/problem/1543
 *   - 성공
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();
        int wordLen = word.length();
        int docLen = document.length();
        int result = 0;
        int idx = 0;

        while (idx < docLen) {
            int lastIdx = Math.min(idx + wordLen, docLen);
            if (word.equals(document.substring(idx, lastIdx))) {
                result++;
                idx += wordLen;
            } else {
                idx++;
            }
        }

        System.out.println(result);

        br.close();
    }
}
