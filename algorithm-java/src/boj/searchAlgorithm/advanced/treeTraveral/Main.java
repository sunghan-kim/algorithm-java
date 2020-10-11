package boj.searchAlgorithm.advanced.treeTraveral;

/*
 *   문제명 : 트리 순회
 *
 *   - https://www.acmicpc.net/problem/1991
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static Map<String, Node> tree;

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
        System.out.print(node.data);
        if (node.leftNode != ".") {
            preOrder(tree.get(node.leftNode));
        }
        if (node.rightNode != ".") {
            preOrder(tree.get(node.rightNode));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String data = st.nextToken();
            String leftNode = st.nextToken();
            String rightNode = st.nextToken();

            System.out.println(data + " : " + leftNode + " : " + rightNode);

            tree.put(data, new Node(data, leftNode, rightNode));
        }

        System.out.println(tree);

        preOrder(tree.get("A"));
        System.out.println();


        br.close();
    }
}
