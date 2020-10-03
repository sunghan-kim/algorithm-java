package boj.searchAlgorithm.basic.installingRouter.sol1;

/*
 *   문제명 : 공유기 설치
 *
 *   - https://www.acmicpc.net/problem/2110
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        List<Integer> coordinate = new ArrayList<>();

        for (int i=0; i < N; i++) {
            coordinate.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(coordinate);

        int start = coordinate.get(1) - coordinate.get(0); // 공유기 사이의 최대 거리 (Max Gap)
        int end = coordinate.get(coordinate.size()-1) - coordinate.get(0); // 공유기 사이의 최소 거리 (Min Gap)
        int result = 0;

        while (start <= end) {
            int mid = Math.floorDiv(start + end, 2); // 공유기 사이의 거리 중간값
            int value = coordinate.get(0); // 첫 번째 집 좌표
            int count = 1; // 설치된 공유기 갯수

            for (int i=1; i < coordinate.size(); i++) {
                if (coordinate.get(i) - value >= mid) {
                    /*
                        앞서 공유기가 설치된 집의 좌표와 공유기를 설치하려는 집의 좌표 사이의 값이
                        설정한 Gap(mid)보다 큰 경우, 해당 집에 공유기를 설치할 수 있으므로
                        공유기가 설치된 집을 변경하고 설치된 공유기의 개수를 1 증가시킨다.
                    */
                    value = coordinate.get(i);
                    count++;
                }
            }

            if (count >= C) { // C개 이상의 공유기를 설치할 수 있는 경우
                start = mid + 1;
                result = mid;
            } else { // C개 이상의 공유기를 설치할 수 없는 경우
                end = mid - 1;
            }
        }

        System.out.println(result);

        br.close();
    }
}
