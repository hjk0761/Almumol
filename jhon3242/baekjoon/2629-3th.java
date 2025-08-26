package backjoon.n2629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
    static int N;
    static int[] weights;
    static boolean[][] visited;
    static int MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        MAX = 500 * N;
        visited = new boolean[N+1][MAX + 1];
        weights = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        dfs(0, 0);

//        for (int i = 0; i < 10; i++) {
//            System.out.print(visited[i] + " ");
//        }
//        System.out.println();
        int m = Integer.parseInt(br.readLine());
        int[] tArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        StringBuilder sb = new StringBuilder();
        for (int t : tArr) {
            if (isValid(t)) {
                sb.append("Y");
            } else {
                sb.append("N");
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }

    private static boolean isValid(int target) {
        if (target > MAX) {
            return false;
        }
        for (int i = 0; i <= N; i++) {
            if (visited[i][target]) {
                return true;
            }
        }
        return false;
    }

    private static void dfs(int dep, int weight) {
        if (visited[dep][weight]) {
            return;
        }
        visited[dep][weight] = true;
        if (dep >= N) {
            return;
        }
        dfs(dep + 1, weight + weights[dep]);
        dfs(dep + 1, Math.abs(weight - weights[dep]));
        dfs(dep + 1, weight);
    }
}
