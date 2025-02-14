package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2293 {

    static int N,K;
    static int[] coin;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coin = new int[N];
        dp = new int[N];

        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j >= coin[i]) {
                    dp[j] += dp[j - coin[i]];
                }
            }
        }

        System.out.println(dp[K]);
    }
}
