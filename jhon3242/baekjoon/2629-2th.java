package backjoon.n2629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*

2 3 3 3

1

dp[]
2개의 부분 집합으로 나누면 만들 수 있는 경우의 수가 나온다.


 */

public class Main2 {
    static int N;
    static int[] graph;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        dp = new boolean[N + 1][500 * 30 + 1];
        dfs(0, 0);
        int k = Integer.parseInt(br.readLine());
        int[] targets = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = Arrays.stream(graph).sum();
        StringBuilder sb = new StringBuilder();
        for (int cur: targets) {
            if (max < cur) {
                sb.append("N");
            } else if (isValid(cur)) {
                sb.append("Y");
            } else {
                sb.append("N");
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int dep, int cur) {
        if (dp[dep][cur]) return;
        dp[dep][cur] = true;
        if (dep == N) return;

        dfs(dep + 1, cur + graph[dep]);
        dfs(dep + 1, Math.abs(cur - graph[dep]));
        dfs(dep + 1, cur);
    }

    private static boolean isValid(int target) {
        for (int i = 0; i <= N; i++) {
            if (dp[i][target]) {
                return true;
            }
        }
        return false;
    }
}
