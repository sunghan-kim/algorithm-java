package boj.sortAlgorithm.advanced.sortNumber2.sol1;

/*
 *   문제명 : 수 정렬하기 2
 *      - https://www.acmicpc.net/problem/2751
 *      - 병합 정렬 사용해보기
 *      - 실패
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] arr;
    public static int[] sortedArr;

    public static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start+end) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && arr[p] < arr[q])) {
                    sortedArr[idx++] = arr[p++];
                } else {
                    sortedArr[idx++] = arr[q++];
                }
            }

            for (int i=start; i <= end; i++) {
                arr[i] = sortedArr[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sortedArr = new int[n];
        for (int i=0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0, arr.length-1);

        StringBuilder sb = new StringBuilder();
        for (int a : sortedArr) {
            sb.append(a).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
