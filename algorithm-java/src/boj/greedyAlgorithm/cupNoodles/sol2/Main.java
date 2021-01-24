package boj.greedyAlgorithm.cupNoodles.sol2;

/*
 *   문제명 : 컵라면
 *
 *   - https://www.acmicpc.net/problem/1781
 *   - 해설 코드
 *   - 성공
 *
 * */

import java.util.*;

class Node {
    public int x;
    public int y;

    Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 0;
        ArrayList<Node> data = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 문제 정보를 입력 받은 이후에, 데드라인을 기준으로 정렬
        for (int i=0; i < n; i++) {
            data.add(new Node(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(data, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if (a.x == b.x) {
                    return Integer.compare(a.y, b.y);
                }
                return Integer.compare(a.x, b.x);
            }
        });

        for (int i=0; i < n; i++) {
            int a = data.get(i).x;
            int b = data.get(i).y;
            pq.offer(b);
            // 데드라인을 초과하는 경우에는 최소 원소를 제거
            if (a < pq.size()) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);

    }
}
