package boj.dataType.nameChemistryTest.sol2;

/*
 *   문제명 : 이름궁합 테스트
 *
 *   - https://www.acmicpc.net/problem/17269
 *   - 다른 사람 풀이
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] strokes = {
                3, 2, 1, 2, 4,
                3, 1, 3, 1, 1,
                3, 1, 3, 2, 1,
                2, 2, 2, 1, 2,
                1, 1, 1, 2, 2, 1
        };

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] A = st.nextToken().toCharArray();
        char[] B = st.nextToken().toCharArray();

        List<Integer> answer = new ArrayList<>();

        for (int i=0; i < Math.min(N, M); i++) {
            answer.add(strokes[A[i] - 'A']);
            answer.add(strokes[B[i] - 'A']);
        }

        for (int i=Math.min(N, M); i < Math.max(N, M); i++) {
            if (N > M) answer.add(strokes[A[i] - 'A']);
            else answer.add(strokes[B[i] - 'A']);
        }

        while (answer.size() != 2) {
            for (int i=0; i < answer.size()-1; i++) {
                int temp = answer.get(i) + answer.get(i+1);
                if (temp >= 10) temp = temp % (10 * (temp/10));
                answer.set(i, temp);
            }
            answer.remove(answer.size()-1);
        }

        if (answer.get(0) != 0) System.out.print(answer.get(0));
        System.out.print(answer.get(1) + "%");

        br.close();
    }
}
