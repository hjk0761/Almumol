package backjoon.n2629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
추의 무게는 자연수이다. 그렇다면 무조건 같을 때 뿐만 아니라 크고 작음으로도 추의 수를 구할 수 있지 않을까?  -> 2번 케이스를 보니 아니다.
ex) 4 < k && k < 6 , 따라서 k =5 다.

2 3 3 3
1 4 5
^

즉, 하나씩 더해보면서 값이 같아지는 경우가 있는지 확인하면 될 것 같다.
추의 개수는 30개 이하. 확인할 구슬의 개수는 7개 이하, 따라서 n^3도 가능할 것 같다?

아니면 반대로 추로 나올 수 있는 경우의 수를 모두 구하면되지않을까?
DFS로 합의 경우의수를 구하고, 방문하지 않은 값들을 빼면 차의 경우의 수도 모두 구할 수 있을 것 같은데?

 */

public class Main {
    static int N;
    static int M;
    static int[] weights;
    static int[] targets;
    static boolean[][] dp;
    static int SUM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weights = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        M = Integer.parseInt(br.readLine());
        targets = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        SUM = Arrays.stream(weights).sum();
        dp = new boolean[N + 1][SUM + 1];
        dfs(0, 0);
//        for (int i = 0; i <= N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = targets[i];
            if (canMakeIt(target)) {
                sb.append("Y");
            } else {
                sb.append("N");
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int idx, int diff) {
        if (diff > SUM) return;
        if (diff < 0) return;
        if (dp[idx][diff]) return;
        dp[idx][diff] = true;
        if (idx >= N) return;

        int cur = weights[idx];
        dfs(idx + 1, diff);
        dfs(idx + 1, diff + cur);
        dfs(idx + 1, Math.abs(diff - cur));
    }

    private static boolean canMakeIt(int target) {
        for (int i = 0; i <= N; i++) {
            if (target <= SUM && dp[i][target]) {
                return true;
            }
        }
        return false;
    }
}
