package backjoon.n11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int S = 0;
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            if (commend.equals("all")) {
                S = (1<<21) -1;
            } else if (commend.equals("empty")) {
                S = 0;
            } else {
                int target = Integer.parseInt(st.nextToken());
                if (commend.equals("add")) {
                    S |= (1<<target);
                } else if (commend.equals("check")) {
                    if ((S & (1<<target)) != 0) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                    sb.append("\n");
                } else if (commend.equals("toggle")) {
                    S ^= (1<<target);
                } else {
                    S &= ~(1 << target);
                }
            }

        }
        System.out.println(sb);
    }
}
