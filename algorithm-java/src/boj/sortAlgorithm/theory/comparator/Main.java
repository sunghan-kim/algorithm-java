package boj.sortAlgorithm.theory.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
