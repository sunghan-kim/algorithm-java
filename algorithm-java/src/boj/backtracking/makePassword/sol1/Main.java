package boj.backtracking.makePassword.sol1;

/*
 *   문제명 : 암호 만들기
 *
 *   - https://www.acmicpc.net/problem/1759
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<List<String>> result;
    private static Stack<String> string;
    private static Stack<Integer> visited;

    private static void combination(List<String> array, int length, int index) {
        if (length == string.size()) {
            result.add(new ArrayList<>(string)); // Stack -> List
            return;
        }
        for (int i=index; i < array.size(); i++) {
            if (visited.contains(i)) continue;
            string.push(array.get(i));
            visited.push(i);
            combination(array, length, i+1);
            string.pop();
            visited.pop();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<String> array = new ArrayList<>();
        for (int i=0; i < c; i++) {
            array.add(st.nextToken());
        }

        Collections.sort(array);

        result = new ArrayList<>();
        string = new Stack<>();
        visited = new Stack<>();

        combination(array, l, 0);

        String[] vowels = {"a", "e", "i", "o", "u"};
        StringBuilder answer = new StringBuilder();

        for (List<String> password : result) {
            int vowelCnt = 0;
            for (String p : password) {
                // 모음 갯수 카운트
                // 배열을 Arrays.asList() 를 통해 리스트로 만든 후 contains() 메서드 사용
                if (Arrays.asList(vowels).contains(p)) vowelCnt++;
            }

            // 모음이 1개 이상이고, 자음이 2개 이상인 경우
            if (vowelCnt >= 1 && (l - vowelCnt) >= 2) {
                for (String p : password) answer.append(p);
                answer.append("\n");
            }
        }

        System.out.println(answer.toString());

        br.close();
    }
}
