package backjoon.n2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*

1 2 3 4 5

 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] graph = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            graph[i + 1] = Integer.parseInt(br.readLine());
        }
        dp[1] = graph[1];
        if (N >= 2) {
            dp[2] = graph[1] + graph[2];
        }
//        if (N >= 3) {
//            dp[3] = Math.max(graph[1], graph[2]) + graph[3];
//        }
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 3] + graph[i - 1], dp[i - 2]) + graph[i];
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}

