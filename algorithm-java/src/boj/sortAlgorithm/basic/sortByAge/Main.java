package boj.sortAlgorithm.basic.sortByAge;

/*
 *   문제명 : 나이순 정렬
 *      - https://www.acmicpc.net/problem/10814
 *      - 성공
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Member implements Comparable<Member> {
    int order, age;
    String name;

    public Member(int order, int age, String name) {
        this.order = order;
        this.age = age;
        this.name = name;
    }

    public int compareTo(Member o) {
        if (this.age > o.age) { // 나이 오름차순
            return 1; // 자리 바꿈
        } else if (this.age == o.age) {
            if (this.order > o.order) { // 순서 오름차순
                return 1; // 자리 바꿈
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>();

        for (int i=0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Member(i, age, name));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Member m : list) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        br.close();

        System.out.println(sb.toString());
    }
}
