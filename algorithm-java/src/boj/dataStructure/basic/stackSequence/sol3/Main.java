package boj.dataStructure.basic.stackSequence.sol3;

/*
 *   스택 수열
 *      - https://www.acmicpc.net/problem/1874
 *
 *      - 블로그 참고 (https://pangsblog.tistory.com/51)
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static int N;
    private static int num = 1;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        Stack<Integer> stack = new Stack<>();
        boolean isAble = true;
        StringBuilder sb = new StringBuilder();

        for (int i=0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (isAble) {
                while (num <= arr[i]) {
                    stack.push(num++); // num을 push 한 후 값 증가 시킴
                    sb.append("+ \n");
                }
                if (stack.isEmpty()) isAble = false;
                else {
                    while (stack.peek() >= arr[i]) {
                        stack.pop();
                        sb.append("- \n");
                        if (stack.isEmpty()) break;
                    }
                }
            }
        }

        if (isAble) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}
