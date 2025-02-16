package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2133 {

    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 2] * dp[2];
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] = dp[i] + (dp[j] * 2);
            }
        }

        if (N % 2 != 0) {
            System.out.println(0);
            return;
        }

        System.out.println(dp[N]);
    }
}
