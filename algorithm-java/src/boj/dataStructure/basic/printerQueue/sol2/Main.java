package boj.dataStructure.basic.printerQueue.sol2;

/*
 *   문제명 : 프린터 큐
 *      - https://www.acmicpc.net/problem/1966
 *      - sol1 -> Element 클래스 위치 조정
 *      -> 성공 (클래스를 위에 선언해도 상관없음)
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Document {
    int docId, importance;

    public Document(int docId, int importance) {
        this.docId = docId;
        this.importance = importance;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i=0; i < testCase; i++) {
            String[] line1 = br.readLine().split(" ");
            int N = Integer.parseInt(line1[0]);
            int M = Integer.parseInt(line1[1]);

            String[] line2 = br.readLine().split(" ");
            Queue<Document> queue = new LinkedList<>();

            for (int j=0; j < N; j++) {
                queue.offer(new Document(j, Integer.parseInt(line2[j])));
            }

            int result = 1;
            while (!queue.isEmpty()) {
                Document currentDoc = queue.poll();
                boolean isMax = true;
                for (Document doc : queue) {
                    if (currentDoc.importance < doc.importance) {
                        isMax = false;
                        break;
                    }
                }
                if (!isMax) {
                    queue.offer(currentDoc);
                } else {
                    if (currentDoc.docId == M) {
                        System.out.println(result);
                        break;
                    } else {
                        result++;
                    }
                }
            }
        }
    }
}
