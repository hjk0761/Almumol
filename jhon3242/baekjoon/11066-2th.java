package backjoon.n11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.print.DocFlavor.STRING;

public class Main2 {
    static int N;
    static int[] graph;
    static int[] sumGraph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){

            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph = new int[N  + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[N + 1][N + 1];
            sumGraph = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                dp[i][i] = 0;
                sumGraph[i] = sumGraph[i - 1] + graph[i];
            }

            for (int bindCount = 1; bindCount <= N; bindCount++) {
                for (int start = 1; start + bindCount <= N; start++) {
                    int end = start + bindCount;
                    dp[start][end] = Integer.MAX_VALUE;
                    for (int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end],
                            dp[start][mid] + dp[mid + 1][end] + sumGraph[end] - sumGraph[start - 1]);
                    }
                }
            }

            System.out.println(dp[1][N]);
        }
    }
}
