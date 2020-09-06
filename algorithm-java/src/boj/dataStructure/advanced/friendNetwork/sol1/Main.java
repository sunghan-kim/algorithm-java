package boj.dataStructure.advanced.friendNetwork.sol1;

/*
 *   문제명 : 친구 네트워크
 *      - https://www.acmicpc.net/problem/4195
 *      - 실패 (2번째 샘플 데이터에서 실패)
 *
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static HashMap<String, String> parent;
    public static HashMap<String, Integer> number;

    /**
     * 입력된 사람의 최상위 부모 사람을 찾아서 반환
     *
     * @param x
     * @return
     */
    public static String find(String x) {
        if (x.equals(parent.get(x))) {
            return x;
        } else {
            String p_tmp = find(parent.get(x));
            parent.put(x, p_tmp);
            return parent.get(x);
        }
    }

    /**
     *
     * @param x
     * @param y
     */
    public static void union(String x, String y) {
        x = find(x);
        y = find(y);

        if (!x.equals(y)) { // 두 사람의 최상위 부모가 다른 경우 (네트워크가 연결되어 있지 않은 경우)
            parent.put(y, x);
            number.put(x, number.get(x)+1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int f;
        String[] persons;
        String x;
        String y;

        for (int i=0; i < testCase; i++) {
            parent = new HashMap<>();
            number = new HashMap<>();
            f = Integer.parseInt(br.readLine());

            for (int j=0; j < f; j++) {
                persons = br.readLine().split(" ");
                x = persons[0];
                y = persons[1];

                if (parent.get(x) == null) {
                    parent.put(x, x);
                    number.put(x, 1);
                }
                if (parent.get(y) == null) {
                    parent.put(y, y);
                    number.put(y, 1);
                }

                union(x, y);
                System.out.println(number.toString());
                System.out.println(number.get(find(x)));
            }
        }
    }
}
