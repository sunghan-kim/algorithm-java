package boj.dataStructure.basic.stackSequence.sol1;

/*
 *   스택 수열
 *      - https://www.acmicpc.net/problem/1874
 *
 *   -> 실패
 * */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        Stack<Integer> stack = new Stack<>();
        Queue<String> result = new LinkedList<>();
        boolean no = false;

        for (int i=0; i < n; i++) {
            int data = sc.nextInt();
            while (count <= data) {
                stack.push(count);
                count++;
                result.offer("+");
            }
            System.out.println("data : " + data + " / stack pop : " + stack.peek());
            if (data == stack.peek()) {
                stack.pop();
                result.offer("-");
            } else {
                no = true;
                break;
            }
        }
        sc.close();

        if (!no) {
            for (int i=0; i < result.size(); i++) {
                System.out.println(result.poll());
            }
        } else {
            System.out.println("NO");
        }
    }
}
