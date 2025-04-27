

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] steps = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            steps[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = steps[0];
        if (N >= 1) {
            dp[1] = steps[0] + steps[1];
        }
        if (N >= 2) {
            dp[2] = steps[2] + Math.max(steps[0], steps[1]);
        }

        for (int i = 3; i < N; i++) {
            dp[i] = steps[i] + Math.max(dp[i - 2], steps[i - 1] + dp[i - 3]);
        }

        System.out.println(dp[N - 1]);
    }
}
