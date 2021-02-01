package boj.backtracking.alphabet.sol1;

/*
 *   문제명 : 알파벳
 *
 *   - https://www.acmicpc.net/problem/1987
 *   - 시간 초과
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Obj {
        private int x;
        private int y;
        private String alphabet;

        private Obj(int x, int y, String alphabet) {
            this.x = x;
            this.y = y;
            this.alphabet = alphabet;
        }
    }

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int r;
    private static int c;
    private static String[][] board;
    private static int result;

    private static void bfs(int x, int y) {
        Queue<Obj> queue = new LinkedList<>();
        queue.offer(new Obj(x, y, board[x][y]));
        queue = new LinkedList<>(new HashSet<>(queue)); // 중복제거

        while (!queue.isEmpty()) {
            Obj obj = queue.poll();
            result = Math.max(result, obj.alphabet.length());

            for (int i=0; i < dx.length; i++) {
                int nx = obj.x + dx[i];
                int ny = obj.y + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c && !obj.alphabet.contains(board[nx][ny])) {
                    queue.offer(new Obj(nx, ny, obj.alphabet + board[nx][ny]));
                    queue = new LinkedList<>(new HashSet<>(queue)); // 중복제거
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new String[r][c];
        for (int i=0; i < r; i++) {
            String val = br.readLine();
            for (int j=0; j < c; j++) {
                board[i][j] = val.substring(j, j+1);
            }
        }

        result = 0;
        bfs(0, 0);

        System.out.println(result);

        br.close();
    }
}
