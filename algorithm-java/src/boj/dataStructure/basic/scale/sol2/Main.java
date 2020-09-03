package boj.dataStructure.basic.scale.sol2;

import java.util.Scanner;

/*
    - 문제명 : 음계
    - 링크 : https://www.acmicpc.net/problem/2920
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] scales = new int[8];
        for (int i=0; i < scales.length; i++) {
            scales[i] = sc.nextInt();
        }
        sc.close();

        boolean ascending = false;
        boolean descending = false;

        for (int i=0; i < scales.length-1; i++) {
            if ((scales[i+1] - scales[i]) > 0) {
                ascending = true;
            } else {
                descending = true;
            }
        }

        if (ascending && descending) {
            System.out.println("mixed");
        } else if (ascending) {
            System.out.println("ascending");
        } else {
            System.out.println("descending");
        }
    }
}
