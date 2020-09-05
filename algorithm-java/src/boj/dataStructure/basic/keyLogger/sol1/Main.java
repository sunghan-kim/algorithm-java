package boj.dataStructure.basic.keyLogger.sol1;

/*
 *   문제명 : 키로거
 *      - https://www.acmicpc.net/problem/5397
 *      - 성공
 *          - Deque 자료 구조 활용
 *      - 자료구조 (Queue, Stack, Deque) 정리 필요
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i=0; i < testCase; i++) {
            String[] words = br.readLine().split("");
            Deque<String> st1 = new ArrayDeque<>();
            Stack<String> st2 = new Stack<>();

            for (String word : words) {
                if ("<".equals(word)) {
                    if (!st1.isEmpty()) {
                        st2.push(st1.pollLast());
                    }
                } else if (">".equals(word)) {
                    if (!st2.empty()) {
                        st1.offerLast(st2.pop());
                    }
                } else if ("-".equals(word)) {
                    if (!st1.isEmpty()) {
                        st1.pollLast();
                    }
                } else {
                    st1.addLast(word);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!st1.isEmpty()) {
                sb.append(st1.pollFirst());
            }
            while (!st2.empty()) {
                sb.append(st2.pop());
            }
            System.out.println(sb.toString());
        }
        br.close();
    }
}
