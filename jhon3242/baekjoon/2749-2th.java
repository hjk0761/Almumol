package backjoon.n2749;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
1000000000000000000
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 1000000;
        int pisano = (int) (15 * Math.pow(10, 5));
        long N = Long.parseLong(br.readLine()) % pisano;
        long[] dp = new long[pisano+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= pisano; i++) {
            dp[i] = dp[i - 2] % mod + dp[i - 1] % mod;
            dp[i] %= mod;
        }
        System.out.println(dp[(int)N]);
    }
}
