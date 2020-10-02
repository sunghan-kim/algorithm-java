package boj.searchAlgorithm.basic.defendingCastle;
/*
 *   문제명 : 성 지키기
 *
 *   - https://www.acmicpc.net/problem/1236
 *   - 성공
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] status = new String[n];

        for (int i=0; i < n; i++) {
            status[i] = br.readLine();
        }

        int[] row = new int[n];
        int[] col = new int[m];

        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (status[i].charAt(j) == 'X') {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        int rowCnt = 0;
        for (int r : row) {
            if (r == 0) rowCnt++;
        }

        int colCnt = 0;
        for (int c : col) {
            if (c == 0) colCnt++;
        }

        System.out.println(Math.max(rowCnt, colCnt));

        br.close();
    }
}
