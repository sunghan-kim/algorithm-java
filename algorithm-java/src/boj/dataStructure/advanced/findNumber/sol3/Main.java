package boj.dataStructure.advanced.findNumber.sol3;

/*
 *   문제명 : 수 찾기
 *      - https://www.acmicpc.net/problem/1920
 *      - 정수 형변환 로직 제걱 및 객체 재활용을 통해 메모리 및 시간 줄여보기
 *      - 성공
 *          - 메모리는 많이 감소
 *          - 시간은 좀 더 감소 필요
 *
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i < n; i++) {
            set.add(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i=0; i < m; i++) {
            if (set.contains(st.nextToken())) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
