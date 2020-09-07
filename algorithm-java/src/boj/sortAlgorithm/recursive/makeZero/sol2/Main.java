package boj.sortAlgorithm.recursive.makeZero.sol2;

/*
 *   문제명 : 0 만들기
 *      - https://www.acmicpc.net/problem/7490
 *      - 실패
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<List<String>> operatorList;

    static void recursive(List<String> array, int n) {
        if (n == array.size()) {
            operatorList.add(array);
            System.out.println(operatorList);
            return;
        }

        array.add(" ");
        recursive(array, n);
        array.remove(array.size()-1);

        array.add("+");
        recursive(array, n);
        array.remove(array.size()-1);

        array.add("-");
        recursive(array, n);
        array.remove(array.size()-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i=0; i < testCase; i++) {
            operatorList = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            System.out.println(n);
            recursive(new ArrayList<>(), n-1);
            System.out.println(operatorList.toString());
            int [] numbers = new int[n];
            for (int j=0; j < n; j++) {
                numbers[j] = j+1;
            }

            for (List<String> operators : operatorList) {
                String str = "";
                for (int k=0; k < n-1; k++) {
                    str += Integer.toString(numbers[k]) + operators.get(k);
                }
                str += numbers[n-1];

                System.out.println(str);
            }
        }

        br.close();
    }
}
