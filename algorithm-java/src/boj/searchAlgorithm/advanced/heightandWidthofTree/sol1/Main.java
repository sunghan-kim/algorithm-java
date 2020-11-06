package boj.searchAlgorithm.advanced.heightandWidthofTree.sol1;

/*
 *   문제명 : 트리의 높이와 너비
 *
 *   - https://www.acmicpc.net/problem/2250
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        TREE = new HashMap<>();
        ROOT = -1;
        LEVEL_MIN = new int[n+1];
        LEVEL_MAX = new int[n+1];
        LEVEL_MIN[0] = n;
        LEVEL_MAX[0] = 0;

        for (int i=1; i < n+1; i++) {
            TREE.put(i, new Node(i, -1, -1));
            LEVEL_MIN[i] = n;
            LEVEL_MAX[i] = 0;
        }

        br.close();
    }
}
