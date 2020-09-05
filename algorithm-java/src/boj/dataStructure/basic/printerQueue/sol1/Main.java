package boj.dataStructure.basic.printerQueue.sol1;

/*
 *   문제명 : 프린터 큐
 *      - https://www.acmicpc.net/problem/1966
 *      - 성공
 *      - Element 클래스 위치 조정 필요
 *      - StringTokenizer 학습 필요
 *      - iterator() 학습 필요 -> iterator() 보다 개선된 for문 활용
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i=0; i < testCase; i++) {
            String [] arr = br.readLine().split(" ");
            int N = Integer.parseInt(arr[0]);
            int M = Integer.parseInt(arr[1]);

            String[] arr2 = br.readLine().split(" ");
            Queue<Element> queue = new LinkedList<>();

            for (int j=0; j < N; j++) {
                queue.offer(new Element(j, Integer.parseInt(arr2[j])));
            }

            int count = 1;
            while (!queue.isEmpty()) {
                Element nowValue = queue.poll();
                boolean isMax = true;

                Iterator it = queue.iterator();
                while (it.hasNext()) {
                    Element value = (Element) it.next();
                    if (nowValue.importance < value.importance) {
                        isMax = false;
                        break;
                    }
                }

                if (!isMax) {
                    queue.offer(nowValue);
                } else {
                    if (nowValue.idx == M) {
                        System.out.println(count);
                    } else {
                        count++;
                    }
                }
            }
        }
    }

    static class Element {
        int idx, importance;

        Element(int idx, int importance) {
            this.idx = idx;
            this.importance = importance;
        }
    }
}
