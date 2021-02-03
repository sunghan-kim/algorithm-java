package boj.backtracking.makePassword.sol2;

/*
 *   문제명 : 암호 만들기
 *
 *   - https://www.acmicpc.net/problem/1759
 *   - 다른 사람 풀이 (https://zoonvivor.tistory.com/110)
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[] arr;
    static int[] result;
    static int N;
    static int M;

    // start: 시작점, depth: 선택된 문자갯수, ja: 자음갯수, mo: 모음갯수
    private static void DFS(int start, int depth, int ja, int mo) {
        for (int i=start; i < M; i++) {
            result[i] = 1; // 선택된 문자 확인용
            // 자음과 모음 갯수를 파악해서 다음으로 넘겨준다.
            DFS(i+1, depth+1, ja + (!check(arr[i]) ? 1 : 0), mo + (!check(arr[i]) ? 0 : 1));
            result[i] = 0; // 0이면 선택 안됨
        }
        // 문자 갯수가 N개이며, 자음과 모음의 갯수가 규칙에 맞을때만 출력
        if (depth == N && ja >= 2 && mo >= 1) print();
    }

    // 자음 모음 파악 함수
    public static boolean check(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') return true;
        else return false;
    }

    private static void print() {
        for (int i=0; i < M; i++) {
            // result가 0 이라면 선택되지 않았기 때문에 넘긴다.
            if (result[i] == 1) System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[M];
        result = new int[M];;

        String[] str = br.readLine().split(" ");
        for (int i=0; i < M; i++) {
            arr[i] = str[i].charAt(0);
        }

        Arrays.sort(arr);

        DFS(0, 0, 0, 0);


        br.close();
    }
}
