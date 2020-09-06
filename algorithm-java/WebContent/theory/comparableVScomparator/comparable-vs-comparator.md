# 1. Java 객체 정렬하기

참고 블로그
- https://www.daleseo.com/java-comparable-comparator/
- https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html

<br>

## 1.1 `Comparable` 인터페이스

- `Comparable` 인터페이스의 `compareTo()` 메서드를 통해 인자로 넘어온 같은 타입의 다른 객체와 대소 비교 가능
- `compareTo()`는 다음과 같은 값들을 리턴해야 한다.
  - `메서드를 호출하는 객체 < 인자로 넘어온 객체` -> 음수(`-1`) 리턴
  - `메서드를 호출하는 객체 == 인자로 넘어온 객체` -> `0` 리턴
  - `메서드를 호출하는 객체 > 인자로 넘어온 객체` -> 양수(`1`) 리턴  
  

<br>

- 따라서, 오름차순으로 정렬하기 위해서는 다음과 같이 로직을 구성하면 된다.

```java
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

public class Main {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        list.add(new Member(10, "Kim"));
        list.add(new Member(15, "Park"));
        list.add(new Member(21, "Lee"));
        list.add(new Member(17, "Choi"));

        Collections.sort(list); // 나이순으로 정렬됨

        for (Member m : list) {
            System.out.println(m.age); 
        }

        // 10, 15, 17, 21
    }
}
```

<br>

- 내림차순으로 정렬하기 위해서는 다음과 같이 로직을 구성하면 된다.

```java
class Member implements Comparable<Member> {
    int age;
    String name;
    
    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int compareTo(Member o) {
        if (this.age < o.age) { // 내림차순
            return 1; // 순서 바꿈
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        list.add(new Member(10, "Kim"));
        list.add(new Member(15, "Park"));
        list.add(new Member(21, "Lee"));
        list.add(new Member(17, "Choi"));

        Collections.sort(list); // 나이순으로 정렬됨

        for (Member m : list) {
            System.out.println(m.age); 
        }

        // 21, 17, 15, 10
    }
}
```

<br>

## 1.2 `Comparator` 객체 사용

- 다음과 같은 경우에 `Comparable` 대신 `Comparator` 를 사용할 수 있다.
  - 정렬 대상 클래스의 코드를 직접 수정할 수 없을 경우
  - 정렬하고자 하는 객체에 이미 존재하고 있는 정렬 기준과 다른 정렬 기준으로 정렬을 하고 싶을 경우   
  
- `Comparator` 인터페이스의 구현체를 `Arrays.sort()` 나 `Collections.sort()` 와 같은 정렬 메서드의 추가 인자로 넘기면 정렬 기준을 누락된 클래스의 객체나 기존 정렬 기준을 무시하고 정렬 기준으로 객체를 정렬할 수 있다.

```java
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class MyComparator implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
        if (p1.x > p2.x) { // x 오름차순 정렬
            return 1;
        } else if (p1.x == p2.x) {
            if (p1.y < p2.y) { // y 내림차순 정렬
                return 1;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1, 4));
        pointList.add(new Point(4, 3));
        pointList.add(new Point(4, 5));
        pointList.add(new Point(3, 1));
        pointList.add(new Point(5, 8));

        MyComparator myComparator = new MyComparator();
        Collections.sort(pointList, myComparator); // === pointList.sort(myComparator);

        for (Point p : pointList) {
            System.out.println(p.x + " : " + p.y);
        }

        /*
            1 : 4
            3 : 1
            4 : 5
            4 : 3
            5 : 8
         */
    }
}
```
