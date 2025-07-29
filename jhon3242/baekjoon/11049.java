package backjoon.n11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
1 ~ N
5 3
3 2
2 6
6 4
[5 2] [2 4]

dp[0][1] = 5 * 3 * 2
dp[1][2] = 3 * 2 * 6
dp[0][2] = dp[0][0] + dp[1][2] = [5 * 3 * 뒷자리] + [3 * 2 * 6]] = (5 * 3 * 뒷자리) + (3 * 2 * 6)
dp[0][2] = dp[0][1] + dp[2][2] = (5 * 3 * 2) + (앞자리 * 2 * 6)
dp[0][3] = dp[0][0] + dp[1][3] = dp[0][0] + dp[1][1] + dp[2][3] =
dp[0][3] = dp[0][1] + dp[2][3] = (5 * 3 * 2) + (2 * 6 * 4) + (앞자리 * 뒷자리)
dp[0][3] = dp[0][1] + dp[2][3] = (5 * 3 * 2) + (2 * 6 * 4) + (5 * 2 * 4)
dp[0][3] = dp[0][1] + dp[2][3] = 30 + 48 + 20 = 98



 */
public class Main {
    static int N;
    static int[][] graph;
    static int result;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][2];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        dp = new int[N][N];
        
        for (int bindCount = 1; bindCount < N; bindCount++) {
            for (int start = 0; start + bindCount < N; start++) {
                int end = start + bindCount;
                dp[start][end] = Integer.MAX_VALUE;

                for (int k = start; k + 1 <= end; k++) {
                    dp[start][end] = Math.min(dp[start][end],
                            dp[start][k] + dp[k + 1][end] + graph[start][0] * graph[k][1] * graph[end][1]
                    );
                }
            }
        }

        System.out.println(dp[0][N - 1]);
    }
}
