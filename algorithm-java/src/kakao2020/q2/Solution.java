package kakao2020.q2;

/**
 *  문제 2 : 괄호 변환
 *
 *  '(' 와 ')' 로만 이루어진 문자열이 있을 경우, '(' 의 개수와 ')' 의 개수가 같다면 이를 균형잡힌 괄호 문자열이라고 부릅니다.
 *  그리고 여기에 '('와 ')'의 괄호의 짝도 모두 맞을 경우에는 이를 올바른 괄호 문자열이라고 부릅니다.
 *  예를 들어, "(()))("와 같은 문자열은 균형잡힌 괄호 문자열 이지만 올바른 괄호 문자열은 아닙니다.
 *  반면에 "(())()"와 같은 문자열은 균형잡힌 괄호 문자열 이면서 동시에 올바른 괄호 문자열 입니다.
 *
 *  '(' 와 ')' 로만 이루어진 문자열 w가 균형잡힌 괄호 문자열 이라면 다음과 같은 과정을 통해 올바른 괄호 문자열로 변환할 수 있습니다.
 *
 *  1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
 *  2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
 *  3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
 *    3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
 *  4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
 *    4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
 *    4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
 *    4-3. ')'를 다시 붙입니다.
 *    4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
 *    4-5. 생성된 문자열을 반환합니다.
 *
 *  균형잡힌 괄호 문자열 p가 매개변수로 주어질 때, 주어진 알고리즘을 수행해 올바른 괄호 문자열로 변환한 결과를 return 하도록 solution 함수를 완성해 주세요.
 */

/**
 *  블로그 참고 (https://keepgoing0328.tistory.com/entry/2020%EC%B9%B4%EC%B9%B4%EC%98%A4-%EA%B3%B5%EC%B1%84-%EA%B4%84%ED%98%B8-%EB%B3%80%ED%99%98-%EC%9E%90%EB%B0%94)
 */

public class Solution {

    static String solution(String p) {
        return makeCorrect(p);
    }

    static String makeCorrect(String w) {
        if ("".equals(w)) {
            return w;
        }

        int cut = divide(w);
        String u = w.substring(0, cut);
        String v = w.substring(cut);

        if (isCorrect(u)) {
            return u + makeCorrect(v);
        } else {
            String temp = '(' + makeCorrect(v) + ')';
            u = u.substring(1, u.length()-1);
            u = reverse(u);
            return temp + u;
        }
    }

    static int divide(String w) {
        int open = 0;
        int close = 0;
        int i;
        for (i=0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                return i+1;
            }
        }
        return i;
    }

    static boolean isCorrect(String w) {
        int count = 0;
        for (int i=0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    static String reverse(String u) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] examples = {
             "(()())()",    // (()())()
             ")(",          // )(
             "()))((()"     // ()(())()
        };

        for (String ex : examples) {
            System.out.println(solution(ex));
        }

    }
}
