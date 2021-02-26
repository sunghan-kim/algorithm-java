package boj.directionVector.wolfandsheep.sol1;

/*
 *   문제명 : 늑대와 양
 *
 *   - https://www.acmicpc.net/problem/16956
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        char[][] map = new char[R][C];

        for (int i=0; i < R; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j=0; j < C; j++) {
                map[i][j] = row[j];
            }
        }

        boolean check = false;
        for (int i=0; i < R; i++) {
            for (int j=0; j < C; j++) {
                if (map[i][j] == 'W') {
                    for (int k=0; k < 4; k++) {
                        int ii = i + dx[k];
                        int jj = j + dy[k];
                        if (ii < 0 || ii == R || jj < 0 || jj == C) continue;
                        if (map[ii][jj] == 'S') {
                            check = true;
                            break;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (check) {
            sb.append(0);
        } else {
            sb.append(1).append("\n");
            for (int i=0; i < R; i++) {
                for (int j=0; j < C; j++) {
                    if (map[i][j] == '.') sb.append('D');
                    else sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}
