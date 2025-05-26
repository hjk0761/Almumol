package backjoon.n12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*

4 7
        1 2 3 4 5 6 7
6 13        0 0     13
4 8         0 8     13
3 6         6 8     14
5 12        6 8




 */
public class Main5 {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] wArr = new int[N+1];
        int[] vArr = new int[N+1];
        int[][] dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            wArr[i] = Integer.parseInt(st.nextToken());
            vArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int weight = 1; weight <= K; weight++) {
            for (int i = 1; i <= N; i++) {
                int curWeight = wArr[i];
                if (curWeight > weight) {
                    dp[i][weight] = dp[i-1][weight];
                    continue;
                }
                int curValue = vArr[i];
                if (weight - curWeight >= 0) {
                    curValue += dp[i - 1][weight - curWeight];
                }
                dp[i][weight] = Math.max(curValue, dp[i-1][weight]);
            }
        }
        System.out.println(dp[N][K]);
    }
}
