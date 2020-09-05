package boj.dataStructure.basic.printerQueue.sol3;

/*
 *   문제명 : 프린터 큐
 *      - https://www.acmicpc.net/problem/1966
 *      - sol2 + StringTokenizer 학습
 *      - 성공
 *      - BufferedReader 사용 후 close() 해줘야 한다.
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Document {
    int id, importance;

    public Document(int id, int importance) {
        this.id = id;
        this.importance = importance;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i=0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            Queue<Document> queue = new LinkedList<>();
            for (int j=0; j < N; j++) {
                queue.offer(new Document(j, Integer.parseInt(st2.nextToken())));
            }

            int count = 1;
            while (!queue.isEmpty()) {
                Document curDoc = queue.poll();
                boolean isMax = true;
                for (Document doc : queue) {
                    if (curDoc.importance < doc.importance) {
                        isMax = false;
                        break;
                    }
                }
                if (!isMax) {
                    queue.offer(curDoc);
                } else {
                    if (curDoc.id == M) {
                        System.out.println(count);
                    } else {
                        count++;
                    }
                }
            }
        }
        br.close();
    }
}
