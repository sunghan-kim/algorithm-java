package boj.dataType.nameChemistryTest.sol1;

/*
 *   문제명 : 이름궁합 테스트
 *
 *   - https://www.acmicpc.net/problem/17269
 *   - 로컬 : 성공
 *   - 제출 : 실패 (틀렸습니다)
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int[] strokes = {
                3, 2, 1, 2, 4,
                3, 1, 3, 1, 1,
                3, 1, 3, 2, 1,
                2, 2, 2, 1, 2,
                1, 1, 1, 2, 2, 1
        };

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int minLength = Math.min(N, M);

        sb = new StringBuilder();
        for (int i=0; i < minLength; i++) sb.append(A.charAt(i)).append(B.charAt(i));
        sb.append(A.substring(minLength)).append(B.substring(minLength));

        String AB = sb.toString();
        int[] array = new int[AB.length()];
        for (int i=0; i < array.length; i++) array[i] = strokes[(int) AB.charAt(i) - (int) 'A'];

        for (int i=0; i < N+M-2; i++) {
            for (int j=0; j < N+M-1-i; j++) {
                array[j] += array[j+1];
            }
        }

        System.out.println((array[0] % 10*10) + (array[1] % 10) + "%");

        br.close();
    }
}
