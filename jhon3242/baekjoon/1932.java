package backjoon.n1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        dp = new int[N][N];

        initGraph(N, br);
        initDp();

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[N - 1][i]);
        }
        System.out.println(result);
    }

    private static void initDp() {
        dp[0][0] = graph[0][0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + graph[i][0];
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + graph[i][j];
            }
        }
    }

    private static void initGraph(int N, BufferedReader br) throws IOException {
        for (int i = 0; i < N; i++) {
            int[] tmpArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < N; j++) {
                int value = 0;
                if (j < tmpArr.length) {
                    value = tmpArr[j];
                }
                graph[i][j] = value;
            }
        }
    }
}
