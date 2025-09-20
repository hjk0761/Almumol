package backjoon.n12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] weighs = new int[N+1];
        int[] values = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weighs[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int bag = 1; bag <= K; bag++) {
            for (int i = 1; i <= N; i++) {
                dp[i][bag] = dp[i - 1][bag];
                if (bag < weighs[i]) {
                    continue;
                }
                if (bag - weighs[i] >= 0) {
                    dp[i][bag] = Math.max(values[i] + dp[i-1][bag - weighs[i]],
                            dp[i][bag]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
