package boj.sortAlgorithm.basic.sortInside.sol2;

/*
 *   문제명 : 소트인사이드
 *      - https://www.acmicpc.net/problem/1427
 *      - 다른 사람 코드 참고 (https://www.acmicpc.net/source/6299997)
 *      - String.charAt() 사용하여 문자열의 특정 인덱스에 해당하는 글자 추출
 *      - Character.getNumericValue() 를 사용하여 특정 문자를 숫자로 변환 (Integer.parseInt() 와 동일한 기능)
 *      - 배열 내림차순 정렬을 직접 구현
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int size = str.length();
        int[] num = new int[size];
        int temp = 0;
        for (int i=0; i < size; i++) {
            num[i] = Character.getNumericValue(str.charAt(i));
        }

        for (int i=0; i < size; i++) {
            for (int j=i; j < size; j++) {
                if (num[i] < num[j]) {
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        for (int i : num) System.out.print(i);
        br.close();
    }
}
