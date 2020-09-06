package boj.dataStructure.advanced.friendNetwork.sol2;

/*
 *   문제명 : 친구 네트워크
 *      - https://www.acmicpc.net/problem/4195
 *      - 런타임 에러...
 *          - 결과를 StringBuilder에 담아도 런타임 에러 발생
 *      - 예제 코드는 성공함
 *
 *
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static HashMap<String, String> parent;
    public static HashMap<String, Integer> number;

    public static void union(String x, String y) {
        x = find(x);
        y = find(y);

        if (!x.equals(y)) {
            parent.put(y, x);
            number.put(x, number.get(x) + number.get(y));
        }
    }

    public static String find(String x) {
        if (x.equals(parent.get(x))) {
            return x;
        } else {
            return parent.put(x, find(parent.get(x)));
        }
    }

    public static void initPerson(String x) {
        if (parent.get(x) == null) {
            parent.put(x, x);
            number.put(x, 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i < testCase; i++) {
            parent = new HashMap<>();
            number = new HashMap<>();

            int f = Integer.parseInt(br.readLine());

            for (int j=0; j < f; j++) {
                String [] persons = br.readLine().split(" ");
                String x = persons[0];
                String y = persons[1];

                initPerson(x);
                initPerson(y);

                union(x, y);
                sb.append(number.get(find(x))).append("\n");
            }
        }
        br.close();
        System.out.println(sb.toString());
    }
}
