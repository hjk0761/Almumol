package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2011 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();

        if (code.isEmpty() || code.startsWith("0")) {
            System.out.println(0);
            return;
        }

        int n = code.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            char c = code.charAt(i - 1);
            if (c != '0') {
                dp[i] = (dp[i] + dp[i - 1]) % 1000000;
            }

            int two = Integer.parseInt(code.substring(i - 2, i));
            if (two >= 10 && two <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000;
            }
        }

        System.out.println(dp[n] % 1000000);
    }
}
