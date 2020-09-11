package kakao2020.q3;

import java.util.Arrays;

/**
 *  문제 3 : 자물쇠와 열쇠
 *
 *
 */

public class Solution {

    static boolean isOk = false;

    static boolean solution(int[][] key, int[][] lock) {
        int len = lock.length;

        // 3배 확장 후 중앙으로 옮기기
        int[][] copyLock = new int[len*3][len*3];

        for (int i=0; i < len; i++) {
            for (int j=0; j < len; j++) {
                copyLock[i+len][j+len] = lock[i][j];
            }
        }

        dfs(key, copyLock, 0);
        return isOk;
    }

    static void dfs(int[][] key, int[][] lock, int cnt) {
        check(key, lock, 0, 0);
    }

    static void check(int[][] key, int[][] lock, int x, int y) {

    }

    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(solution(key, lock));
    }
}
