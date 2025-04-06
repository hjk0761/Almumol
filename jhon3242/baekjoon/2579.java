package backjoon.n2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] graph = new int[N + 1];
        int[][] dp = new int[2][N + 1];
        for (int i = 0; i < N; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        if (N <= 2) {
            int result = 0;
            for (int i = 0; i < N; i++) {
                result += graph[i];
            }
            System.out.println(result);
            return;
        }

        dp[0][0] = graph[0];
        dp[1][0] = graph[0];
        dp[0][1] = graph[1] + graph[0];
        dp[1][1] = graph[1];

        for (int i = 2; i < N; i++) {
            int caseA = Math.max(dp[0][i - 2], dp[1][i - 2]) + graph[i];
            int caseB = dp[1][i - 1] + graph[i];

            dp[0][i] = caseB;
            dp[1][i] = caseA;
        }
        System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
    }
}
