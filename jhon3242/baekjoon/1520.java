package backjoon.n1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] graph;
    static int[][] dp;
    static int result;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        dp = new int[N][M];
        result = 0;
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = -1;
            }
        }

        result = dfs(0, 0);
        System.out.println(result);
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }

    private static int dfs(int cx, int cy) {
//        System.out.print(" cx = " + cx);
//        System.out.print(" cy = " + cy);
//        System.out.println();
        if (dp[cx][cy] > 0) {
            return dp[cx][cy];
        }
        if (cx == N - 1 && cy == M - 1) {
            return 1;
        }

        dp[cx][cy] = 0;
        for (int i = 0; i < 4; i++) {
            int tx = dx[i] + cx;
            int ty = dy[i] + cy;
            if (tx < 0 || ty < 0 || tx >= N || ty >= M || dp[tx][ty] == 0 || graph[cx][cy] <= graph[tx][ty]) {
                continue;
            }
            dp[cx][cy] += dfs(tx, ty);
        }
        return dp[cx][cy];
    }
}
