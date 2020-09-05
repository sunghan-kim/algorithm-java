package boj.dataStructure.theory;

import java.util.*;

public class QueueStackDeque {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        Stack<String> s = new Stack<>();
        Deque<String> d = new ArrayDeque<>();

        String[] datas = {"a", "b", "c", "d"};

        for (String data : datas) {
            q.offer(data);
            s.push(data);
            d.offerLast(data);
        }

        System.out.println(q.toString());
        System.out.println(s.toString());
        System.out.println(d.toString());

        System.out.println("-------------------");
        System.out.println("--------remove-------");
        System.out.println("queue : " + q.poll());
        System.out.println("stack : " + s.pop());
        System.out.println("deque first : " + d.pollFirst());
        System.out.println("deque last : " + d.pollLast());

        System.out.println("-------------------");
        System.out.println("--------examine-------");
        System.out.println("queue : " + q.peek());
        System.out.println("stack : " + s.peek());
        System.out.println("deque first : " + d.peekFirst());
        System.out.println("deque last : " + d.peekLast());

        System.out.println("-------------------");
        System.out.println("--------examine-------");
        System.out.println("queue : " + q.isEmpty());
        System.out.println("stack : " + s.empty());
        System.out.println("deque : " + d.isEmpty());
    }
}
