package boj.searchAlgorithm.actualPractice.Easy2048.sol2;

/*
 *   문제명 : 2048 (Easy)
 *
 *   - https://www.acmicpc.net/problem/12100
 *   - 다른 사람 풀이 (https://jellyinghead.tistory.com/53)
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, answer, map[][];

    private static void findMax() {
        for (int i=0; i < N; i++) {
            for (int j=0; j < N; j++) {
                answer = Math.max(answer, map[i][j]);
            }
        }
    }

    private static void move(int dir) {
        switch (dir) {
            case 0: // 위쪽으로 몰기
                for (int i=0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for (int j=0; j < N; j++) {
                        if (map[j][i] != 0) {
                            if (block == map[j][i]) {
                                map[index-1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            } else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 1: // 아래쪽으로 몰기
                for (int i=0; i < N; i++) {
                    int index = N-1;
                    int block = 0;
                    for (int j=N-1; j >= 0; j--) {
                        if (map[j][i] != 0) {
                            if (block == map[j][i]) {
                                map[index+1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            } else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            case 2: // 왼쪽으로 몰기
                for (int i=0; i < N; i++) {
                    int index = 0;
                    int block = 0;
                    for (int j=0; j < N; j++) {
                        if (map[i][j] != 0) {
                            if (block == map[i][j]) {
                                map[i][index-1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            } else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 3: // 오른쪽으로 몰기
                for (int i=0; i < N; i++) {
                    int index = N-1;
                    int block = 0;
                    for (int j=N-1; j >= 0; j--) {
                        if (map[i][j] != 0) {
                            if (block == map[i][j]) {
                                map[i][index+1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            } else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }

    private static void backTracking(int depth) {
        if (depth == 5) {
            findMax();
            return;
        }

        // Memoization
        int[][] copyMap = new int[N][N];
        for (int i=0; i < N; i++) copyMap[i] = map[i].clone();

        // DFS
        for (int i=0; i < 4; i++) {
            move(i);
            backTracking(depth+1);
            for (int a=0; a < N; a++) {
                map[a] = copyMap[a].clone();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = 0;
        map = new int[N][N];
        StringTokenizer st;

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0);

        System.out.println(answer);

        br.close();
    }
}
