package boj.parameters.girlGroupMasterJunseok.sol1;

/*
 *   문제명 : 걸그룹 마스터 준석이
 *
 *   - https://www.acmicpc.net/problem/16165
 *   - 성공
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, List<String>> groupMember = new HashMap<>(); // key: 그룹명, value: 맴버이름리스트
        Map<String, String> memberGroup = new HashMap<>(); // key: 맴버이름, value: 그룹명

        for (int i=0; i < N; i++) {
            String gName = br.readLine();
            List<String> memberList = new ArrayList<>();
            int mCnt = Integer.parseInt(br.readLine());
            for (int j=0; j < mCnt; j++) {
                String mName = br.readLine();
                memberList.add(mName);
                memberGroup.put(mName, gName);
            }
            Collections.sort(memberList);
            groupMember.put(gName, memberList);
        }

        StringBuilder result = new StringBuilder();
        for (int i=0; i < M; i++) {
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if (type == 0) {
                sb = new StringBuilder();
                for (String mName : groupMember.get(name)) sb.append(mName).append("\n");
                result.append(sb.toString());
            } else {
                result.append(memberGroup.get(name)).append("\n");
            }
        }

        System.out.println(result.toString());

        br.close();
    }
}
