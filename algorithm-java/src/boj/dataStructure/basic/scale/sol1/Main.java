package boj.dataStructure.basic.scale.sol1;

/*
    - 문제명 : 음계
    - 링크 : https://www.acmicpc.net/problem/2920
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] scales = sc.nextLine().split(" ");
        sc.close();
        boolean ascending = false;
        boolean descending = false;

        for (int i=0; i < scales.length-1; i++) {
            int gap = Integer.parseInt(scales[i+1]) - Integer.parseInt(scales[i]);
            if (gap > 0) {
                ascending = true;
            } else if (gap < 0) {
                descending = true;
            }
        }

        if (ascending & descending) {
            System.out.println("mixed");
        } else if (ascending) {
            System.out.println("ascending");
        } else {
            System.out.println("descending");
        }
    }
}
