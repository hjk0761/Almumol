package backjoon.n12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
4 7
6 13
4 8
3 6
5 12
 */
public class Main4 {
    static int N;
    static int K;
    static int[] wArr;
    static int[] vArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        wArr = new int[N + 1];
        vArr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            wArr[i] = Integer.parseInt(st.nextToken());
            vArr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int weight = 1; weight <= K; weight++) {
            int maxValue = 0;
            for (int j = 1; j <= N; j++) {

                dp[j][weight] = dp[j - 1][weight];

                if (wArr[j] <= weight) {
                    int curValue = vArr[j];
                    if (weight - wArr[j] > 0) {
                        curValue += dp[j - 1][weight - wArr[j]];
                    }
                    maxValue = Math.max(curValue, maxValue);
                    maxValue = Math.max(dp[j - 1][weight], maxValue);
                    dp[j][weight] = Math.max(dp[j][weight], maxValue);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
