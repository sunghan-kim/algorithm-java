package boj.searchAlgorithm.advanced.treeTraveral.sol1;

/*
 *   문제명 : 트리 순회
 *
 *   - https://www.acmicpc.net/problem/1991
 *   - 실패 -> 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static Map<String, Node> tree;
    public static StringBuffer preResult;
    public static StringBuffer inResult;
    public static StringBuffer postResult;

    public static class Node {
        String data;
        String leftNode;
        String rightNode;

        public Node(String data, String leftNode, String rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    public static void preOrder(Node node) {
        preResult.append(node.data);
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
        inResult.append(node.data);
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
        postResult.append(node.data);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree = new HashMap<>();
        preResult = new StringBuffer();
        inResult = new StringBuffer();
        postResult = new StringBuffer();

        for (int i=0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String data = st.nextToken();
            String leftNode = st.nextToken();
            String rightNode = st.nextToken();

            tree.put(data, new Node(data, leftNode, rightNode));
        }

        preOrder(tree.get("A"));
        System.out.println(preResult.toString());
        inOrder(tree.get("A"));
        System.out.println(inResult.toString());
        postOrder(tree.get("A"));
        System.out.println(postResult.toString());

        br.close();
    }
}
