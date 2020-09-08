package kakao2020.q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int solution(String s) {
        int sLength = s.length();
        int groupLength = s.length() / 2;
        int minLength = 1000;

        if (s.length() == 1) {
            return 1;
        }

        for (int i=1; i <= groupLength; i++) {
            String compareStr1 = "";
            String result = "";
            int cnt = 1;

            for (int j=0; j < sLength/i; j++) {
                String compareStr2 = s.substring((i*j), (i*j)+i);

                if (compareStr1.equals(compareStr2)) {
                    cnt++;
                    continue;
                }
                if (cnt > 1) {
                    result += cnt + compareStr1;
                } else {
                    result += compareStr1;
                }
                compareStr1 = compareStr2;
                cnt = 1;
            }

            if (cnt > 1) {
                result += cnt + compareStr1;
            } else {
                result += compareStr1;
            }

            if (s.length() % i != 0) {
                result += s.substring(s.length() - (s.length() % i), s.length());
            }
            minLength = Math.min(result.length(), minLength);
        }
        return minLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i=0; i < testCase; i++) {
            String s = br.readLine();
            int answer = solution(s);
            System.out.println(answer);
        }
        br.close();
    }
}
