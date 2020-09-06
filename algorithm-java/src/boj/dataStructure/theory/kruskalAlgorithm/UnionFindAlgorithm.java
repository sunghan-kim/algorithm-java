package boj.dataStructure.theory.kruskalAlgorithm;

/**
 * Union-Find 알고리즘
 *
 *  - 참고 블로그 : https://brenden.tistory.com/33
 */

public class UnionFindAlgorithm {
    public static int[] parent = new int[1000001];

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        // 같은 부모를 갖고 있지 않을 때
        if (x != y) {
            // y가 x보다 크다는 것이 확실하다고 가정한다면 아래와 같이 표현
            /*
            parent[y] = x;
            */
            // 더 작은 값으로 넣어줄 때 다음과 같이 포현
            if (x < y) parent[y] = x;
            else parent[x] = y;
        }
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return true;
        else return false;
    }

    public static void main(String[] args) {
        for (int i=1; i <= 8; i++) {
            parent[i] = i;
        }
        union(1,2);
        union(2, 3);
        union(4,5);
        System.out.println("1과 3은 연결되어 있는가? " + isSameParent(1, 3));
        System.out.println("1과 4은 연결되어 있는가? " + isSameParent(1, 4));
    }
}
