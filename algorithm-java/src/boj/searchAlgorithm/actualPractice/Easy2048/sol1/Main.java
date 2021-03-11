package boj.searchAlgorithm.actualPractice.Easy2048.sol1;

/*
 *   문제명 : 2048 (Easy)
 *
 *   - https://www.acmicpc.net/problem/12100
 *   - 실패
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    private static int N;

    private static int getMaxValue(int[][] board) {
        int maxValue = 0;
        for (int i=0; i < N; i++) {
            for (int j=0; j < N; j++) {
                maxValue = Math.max(maxValue, board[i][j]);
            }
        }
        return maxValue;
    }

    private static int[][] move(int[][] board) {
        int[][] newBoard = new int[N][N];
        for (int i=0; i < N; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j=0; j < N; j++) if (board[i][j] > 0) row.add(board[i][j]);
            for (int j=0; j < row.size()-1; j++) {
                if (row.get(j) == row.get(j+1)) {
                    int value = row.get(j)*2;
                    row.set(j, value);
                    row.set(j+1, 0);
                }
            }
            for (int j=0; j < row.size(); j++) if (row.get(j) == 0) row.remove(j);
            for (int j=0; j < N - row.size(); j++) row.add(0);
            for (int j=0; j < row.size(); j++) newBoard[i][j] = row.get(j);
        }
        return newBoard;
    }

    private static int[][] rotate(int[][] board) {
        int[][] rotatedBoard = new int[N][N];
        for (int i=0; i < N; i++) {
            for (int j=0; j < N; j++) {
                rotatedBoard[N-1-j][i] = board[i][j];
            }
        }
        return rotatedBoard;
    }

    private static int dfs(int[][] board, int movingCnt) {
        int result = getMaxValue(board);
        if (movingCnt == 0) return result;
        for (int i=0; i < 4; i++) {
            int[][] newBoard = move(board);
            if (!Objects.deepEquals(board, newBoard)) result = Math.max(result, dfs(newBoard, movingCnt-1));
            board = rotate(board);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] board = new int[N][N];
        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < N; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        int result = dfs(board, 5);

        System.out.println(result);

        br.close();
    }
}
