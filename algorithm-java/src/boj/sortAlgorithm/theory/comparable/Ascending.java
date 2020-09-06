package boj.sortAlgorithm.theory.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Member implements Comparable<Member> {
    int age;
    String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int compareTo(Member o) {
        if (this.age > o.age) { // 오름차순
            return 1; // 순서 바꿈
        }
        return -1;
    }
}

public class Ascending {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        list.add(new Member(10, "Kim"));
        list.add(new Member(15, "Park"));
        list.add(new Member(21, "Lee"));
        list.add(new Member(17, "Choi"));

        Collections.sort(list); // 나이순으로 정렬됨

        for (Member m : list) {
            System.out.println(m.age + " : " + m.name);
        }

        /*
            10 : Kim
            15 : Park
            17 : Choi
            21 : Lee
         */
    }
}
