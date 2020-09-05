package boj.dataStructure.advanced.sha256.sol1;

/*
 *   문제명 : SHA-256
 *      - https://www.acmicpc.net/problem/10930
 *      - 성공
 *
 * */

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.security.MessageDigest;
        import java.security.NoSuchAlgorithmException;

public class Main {
    /**
     * 바이트를 헥스값으로 변환하는 메서드
     *
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    /**
     * 문자열을 SHA-256으로 해싱하는 메서드
     *
     * @param msg
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String sha256(String msg) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(msg.getBytes());
        return bytesToHex(md.digest());
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(sha256(str));
    }
}
