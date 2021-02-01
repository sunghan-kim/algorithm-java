package kakao2021.q1;

import java.util.regex.Pattern;

public class Solution {

    static String solution(String new_id) {

        // 1.
        new_id = new_id.toLowerCase();

        // 2.
        new_id = new_id.replaceAll("[^a-z\\.\\-\\_0-9]","");

        // 3.
        Pattern p = Pattern.compile("[..]+");
        new_id = p.matcher(new_id).replaceAll(".");
        //new_id = new_id.replaceAll("\\.{2}", ".");
        //new_id = new_id.replaceAll("\\.{2}", ".");

        // 4.
        if (new_id.length() <= 1) {
            if (new_id.equals(".")) {
                new_id = "";
            }
        } else if (new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        } else if (new_id.charAt(new_id.length()-1) == '.') {
            new_id = new_id.substring(0, new_id.length()-1);
        }

        // 5.
        if (new_id.equals("")) {
            new_id = "a";
        }

        // 6.
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(new_id.length()-1) == '.') {
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }

        // 7.
        if (new_id.length() <= 2) {
            char word = new_id.charAt(new_id.length()-1);
            for (int i=0; i < 4-new_id.length(); i++) {
                new_id += word;
            }
        }

        return new_id;
    }

    public static void main(String[] args) {
        String ex1 = "...!@BaT#*..y.abcdefghijklm";
        String ex2 = "z-+.^.";
        String ex3 = "=.=";
        String ex4 = "123_.def";
        String ex5 = "abcdefghijklmn.p";

        System.out.println(solution(ex1));
        System.out.println(solution(ex2));
        System.out.println(solution(ex3));
        System.out.println(solution(ex4));
        System.out.println(solution(ex5));
    }
}
