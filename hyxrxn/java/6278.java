import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int p = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);

        long answer = 0;
        int virus;
        String[] line2 = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            answer *= p;
            virus = Integer.parseInt(line2[i]);
            answer += virus;
            answer %= 1000000007;
        }

        System.out.println(answer);
    }
}

// https://softeer.ai/practice/6278

// 단순 계산 문제. 숫자가 너무 커질 수 있으므로 중간중간 나눠준다.
// 그냥 스캐너 썼더니 시간초과 나서 버퍼드리더 써봤다...
