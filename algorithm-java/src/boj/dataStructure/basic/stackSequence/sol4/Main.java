package boj.dataStructure.basic.stackSequence.sol4;

/*
 *   스택 수열
 *      - https://www.acmicpc.net/problem/1874
 *      - sol2 개선
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
        //Queue<String> result = new LinkedList<>();
        StringBuffer sb = new StringBuffer();

        for (int i=0; i < arr.length; i++) {
            int data = arr[i];

            while (num <= data) {
                stack.push(num);
                num++;
                //result.offer("+");
                sb.append("+\n");
            }
            if (data == stack.peek()) {
                arr2[i] = stack.pop();
                //result.offer("-");
                sb.append("-\n");
            }
        }

        if (Arrays.equals(arr, arr2)) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}
