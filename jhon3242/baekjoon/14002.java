package backjoon.n14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[N];
        int[] prev = new int[N];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        dp[0] = 1;
        int bestLen = 1, bestIdx = 0;
        for (int i = 1; i < N; i++) {
            int cur = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] < cur && dp[j] + 1 > dp[i]) {
                    prev[i] = j;
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > bestLen) {
                bestLen = dp[i];
                bestIdx = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bestLen).append("\n");

        int[] result = new int[bestLen];
        int cur = bestIdx;
        for (int i = bestLen - 1; i >= 0; i--) {
            result[i] = array[cur];
            cur = prev[cur];
        }
        for (int c : result) {
            sb.append(c).append(" ");
        }
        System.out.println(sb);
    }
}
