package backjoon.n1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

dp[n][1] = Math.min(dp[n - 1][0], dp[n - 1][2]) + graph[n][1];

 */

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N + 1][3];
        int[][] dp = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                int left = j - 1;
                int right = j + 1;
                if (left < 0) {
                    left = 2;
                }
                if (right > 2) {
                    right = 0;
                }
                dp[i][j] = Math.min(dp[i - 1][left], dp[i - 1][right]) + graph[i][j];
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            result = Math.min(dp[N][i], result);
        }
        System.out.println(result);
    }
}
