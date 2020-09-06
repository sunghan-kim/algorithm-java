package boj.sortAlgorithm.theory.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Member2 implements Comparable<Member2> {
    int age;
    String name;

    public Member2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int compareTo(Member2 o) {
        if (this.age < o.age) { // 내림차순
            return 1; // 순서 바꿈
        }
        return -1;
    }
}

public class Descending {
    public static void main(String[] args) {
        List<Member2> list = new ArrayList<>();
        list.add(new Member2(10, "Kim"));
        list.add(new Member2(15, "Park"));
        list.add(new Member2(21, "Lee"));
        list.add(new Member2(17, "Choi"));

        Collections.sort(list); // 나이순으로 정렬됨

        for (Member2 m : list) {
            System.out.println(m.age + " : " + m.name);
        }

        /*
            21 : Lee
            17 : Choi
            15 : Park
            10 : Kim
         */
    }
}
