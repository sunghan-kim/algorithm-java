package boj.searchAlgorithm.basic.bestseller;

/*
 *   문제명 : 베스트셀러
 *
 *   - https://www.acmicpc.net/problem/1302
 *   - 성공
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> books = new HashMap<>();

        for (int i=0; i < n; i++) {
            String book = br.readLine();
            
            /* - 아래 로직으로 대체 가능
            if (books.get(book) == null) {
                books.put(book, 1);
            } else {
                books.put(book, books.get(book)+1);
            }
            */
            books.merge(book, 1, Integer::sum);
        }

        int maxCount = Collections.max(books.values());

        List<String> target = new ArrayList<>();
        for (String key : books.keySet()) {
            if (books.get(key) == maxCount) {
                target.add(key);
            }
        }

        Collections.sort(target);

        System.out.println(target.get(0));

        br.close();
    }
}
