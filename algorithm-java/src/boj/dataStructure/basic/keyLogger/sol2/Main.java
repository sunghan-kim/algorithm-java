package boj.dataStructure.basic.keyLogger.sol2;

/*
 *   문제명 : 키로거
 *      - https://www.acmicpc.net/problem/5397
 *      - 스택 활용 (elementAt())
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i=0; i < testCase; i++) {
            String[] words = br.readLine().split("");
            Stack<String> st1 = new Stack<>();
            Stack<String> st2 = new Stack<>();

            for (String word : words) {
                if (">".equals(word)) {
                    if (!st2.empty()) {
                        st1.push(st2.pop());
                    }
                } else if ("<".equals(word)) {
                    if (!st1.empty()) {
                        st2.push(st1.pop());
                    }
                } else if ("-".equals(word)) {
                    if (!st1.empty()) {
                        st1.pop();
                    }
                } else {
                    st1.push(word);
                }
            }

            while (!st2.empty()) {
                st1.push(st2.pop());
            }

            StringBuilder sb = new StringBuilder();
            for (int j=0; j < st1.size(); j++) {
                sb.append(st1.elementAt(j));
            }
            System.out.println(sb.toString());
        }
        br.close();
    }
}
