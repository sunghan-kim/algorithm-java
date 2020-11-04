package boj.searchAlgorithm.advanced.treeTraveral.sol2;

/*
 *   문제명 : 트리 순회
 *
 *   - https://www.acmicpc.net/problem/1991
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
        String data;
        String leftNode;
        String rightNode;

        public Node(String data, String leftNode, String rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    static Map<String, Node> tree;
    static StringBuilder sb1;
    static StringBuilder sb2;
    static StringBuilder sb3;

    public static void preOrder(Node node) {
        sb1.append(node.data);
        if (!".".equals(node.leftNode)) {
            preOrder(tree.get(node.leftNode));
        }
        if (!".".equals(node.rightNode)) {
            preOrder(tree.get(node.rightNode));
        }
    }
    public static void inOrder(Node node) {
        if (!".".equals(node.leftNode)) {
            inOrder(tree.get(node.leftNode));
        }
        sb2.append(node.data);
        if (!".".equals(node.rightNode)) {
            inOrder(tree.get(node.rightNode));
        }
    }
    public static void postOrder(Node node) {
        if (!".".equals(node.leftNode)) {
            postOrder(tree.get(node.leftNode));
        }
        if (!".".equals(node.rightNode)) {
            postOrder(tree.get(node.rightNode));
        }
        sb3.append(node.data);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tree = new HashMap<>();
        sb1 = new StringBuilder();
        sb2 = new StringBuilder();
        sb3 = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String data = st.nextToken();
            String leftNode = st.nextToken();
            String rightNode = st.nextToken();
            tree.put(data, new Node(data, leftNode, rightNode));
        }

        preOrder(tree.get("A"));
        inOrder(tree.get("A"));
        postOrder(tree.get("A"));

        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        System.out.println(sb3.toString());

        br.close();
    }
}
