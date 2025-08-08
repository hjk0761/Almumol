package backjoon.n1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[N];
        dp[0] = array[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            result = Math.max(dp[i], result);
        }
        System.out.println(result);
    }
}
