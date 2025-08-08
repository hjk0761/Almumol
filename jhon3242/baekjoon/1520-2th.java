package backjoon.n1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static int N;
    static int M;
    static int[][] graph;
    static int[][] dp;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

//        for (int i = 0; i < N; i++) {
////            System.out.println(Arrays.toString(canGraph[i]));
//            System.out.println(Arrays.toString(visitedGraph[i]));
//        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int x, int y) {
        if (x == N - 1 && y == M - 1) {
            return 1;
        }
        if (dp[x][y] > 0) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int tx = dx[i] + x;
            int ty = dy[i] + y;
            if (tx < 0 || ty < 0 || tx >= N || ty >= M || graph[tx][ty] >= graph[x][y] || dp[tx][ty] == 0) {
                continue;
            }
            count += dfs(tx, ty);
        }
        dp[x][y] = count;
        return count;
    }
}
