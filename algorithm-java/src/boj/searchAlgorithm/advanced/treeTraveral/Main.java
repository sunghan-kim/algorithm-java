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

public class Main {
    public static class Node {
        String data;
        Node leftNode;
        Node rightNode;

        public Node(String data, Node leftNode, Node rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());



        br.close();
    }
}
