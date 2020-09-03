package boj.dataStructure.basic.stackSequence.sol2;

/*
 *   스택 수열
 *      - https://www.acmicpc.net/problem/1874
 *
 *   -> 성공
 * */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] arr = new int [n];
        for (int i=0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int num = 1;
        Stack<Integer> stack = new Stack<>();
        int [] arr2 = new int [n];
        Queue<String> result = new LinkedList<>();

        for (int i=0; i < arr.length; i++) {
            int data = arr[i];

            while (num <= data) {
                stack.push(num);
                num++;
                result.offer("+");
            }
            if (data == stack.peek()) {
                arr2[i] = stack.pop();
                result.offer("-");
            }
        }

        if (Arrays.equals(arr, arr2)) {
            while (result.size() > 0) {
                System.out.println(result.poll());
            }
        } else {
            System.out.println("NO");
        }
    }
}
