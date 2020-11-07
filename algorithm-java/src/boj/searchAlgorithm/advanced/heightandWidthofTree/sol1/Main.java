package boj.searchAlgorithm.advanced.heightandWidthofTree.sol1;

/*
 *   문제명 : 트리의 높이와 너비
 *
 *   - https://www.acmicpc.net/problem/2250
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int parent;
        int data;
        int leftNode;
        int rightNode;

        public Node(int data, int leftNode, int rightNode) {
            this.parent = -1;
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    static Map<Integer, Node> TREE;
    static int ROOT;
    static int[] LEVEL_MIN;
    static int[] LEVEL_MAX;
    static int LEVEL_DEPTH;
    static int X;

    public static void in_order(Node node, int level) {
        LEVEL_DEPTH = Math.max(LEVEL_DEPTH, level);

        if (node.leftNode != -1) in_order(TREE.get(node.leftNode), level+1);

        LEVEL_MIN[level] = Math.min(LEVEL_MIN[level], X);
        LEVEL_MAX[level] = Math.max(LEVEL_MAX[level], X);
        X++;

        if (node.rightNode != -1) in_order(TREE.get(node.rightNode), level+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        TREE = new HashMap<>();
        ROOT = -1;
        LEVEL_MIN = new int[n+1];
        LEVEL_MAX = new int[n+1];
        LEVEL_MIN[0] = n;
        LEVEL_MAX[0] = 0;
        LEVEL_DEPTH = 1;
        X = 1;

        for (int i=1; i < n+1; i++) {
            TREE.put(i, new Node(i, -1, -1));
            LEVEL_MIN[i] = n;
            LEVEL_MAX[i] = 0;
        }

        for (int i=0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());
            int leftNode = Integer.parseInt(st.nextToken());
            int rightNode = Integer.parseInt(st.nextToken());
            TREE.get(data).leftNode = leftNode;
            TREE.get(data).rightNode = rightNode;
            if (leftNode != -1) TREE.get(leftNode).parent = data;
            if (rightNode != -1) TREE.get(rightNode).parent = data;
        }

        for (int i=1; i < n+1; i++) {
            if (TREE.get(i).parent == -1) ROOT = i;
        }

        in_order(TREE.get(ROOT), 1);

        int RESULT_LEVEL = 1;
        int RESULT_WIDTH = LEVEL_MAX[1] - LEVEL_MIN[1] + 1;

        for (int i=2; i <= LEVEL_DEPTH; i++) {
            int WIDTH = LEVEL_MAX[i] - LEVEL_MIN[i] + 1;
            if (RESULT_WIDTH < WIDTH) {
                RESULT_LEVEL = i;
                RESULT_WIDTH = WIDTH;
            }
        }

        System.out.println(RESULT_LEVEL + " " + RESULT_WIDTH);

        br.close();
    }
}
