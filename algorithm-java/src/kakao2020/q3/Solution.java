package kakao2020.q3;

import java.util.Arrays;

/**
 *  문제 3 : 자물쇠와 열쇠
 *
 *  블로그 참고 (https://dundung.tistory.com/138)
 */

public class Solution {

    static boolean isOk = false;

    public static boolean solution(int[][] key, int[][] lock) {
        int len = lock.length;

        // 3배 확장 후 중앙으로 옮기기
        int[][] copyLock = new int[len*3][len*3];

        for (int i=0; i < len; i++) {
            for (int j=0; j < len; j++) {
                copyLock[i][j] = key[len-j-1][i];
            }
        }

        dfs(key, copyLock, 0);
        return isOk;
    }

    public static void dfs(int[][] key, int[][] lock, int cnt) {
        check(key, lock, 0, 0);
        if (isOk) return;
        if (cnt >= 4) return;
        int[][] temp = rotate(key);
        dfs(temp, lock, cnt+1);
    }

    public static void check(int[][] key, int[][] lock, int x, int y) {
        if (isOk) return;

        // key를 오른쪽 방향으로 진행, 맨 오른쪾 도달 시 다음 아래 줄 맨 왼쪽으로 이동
        if (y + key.length > lock.length) {
            y = 0;
            x++;
        }

        if (x + key.length > lock.length) return;

        int[][] copyLock = new int[lock.length][lock.length];

        for (int i=0; i < lock.length; i++) {
            copyLock[i] = lock[i].clone();
        }

        boolean isFail = false;
        loop:
            for (int i=0; i < key.length; i++) {
                for (int j=0; j < key.length; j++) {
                    if (key[i][j] == 1) {
                        if (copyLock[i+x][j+y] == 1) {
                            isFail = true;
                            break loop;
                        }
                        copyLock[i+x][j+y] = key[i][j];
                    }
                }
            }

            if (!isFail) {
                loop:
                    for (int i=0; i < lock.length/3; i++) {

                    }
            }
    }

    public static int[][] rotate(int[][] key) {
        int len = key.length;
        int[][] temp = new int[len][len];
        for (int i=0; i < len; i++) {
            for (int j=0; j < len; j++) {
                temp[i][j] = key[len-j-1][i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(solution(key, lock));
    }
}
