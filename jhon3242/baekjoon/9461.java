package backjoon.n9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int j = 0; j < T; j++) {

            int N = Integer.parseInt(br.readLine());

            long[] dp = new long[N + 10];

            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;
            dp[5] = 2;

            for (int i = 6; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 5];
            }

            System.out.println(dp[N]);
        }
    }
}
