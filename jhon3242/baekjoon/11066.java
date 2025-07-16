package backjoon.n11066;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            int N = Integer.parseInt(br.readLine());
            int[] array = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] sumArr = new int[N + 1];
            for (int i = 0; i < N; i++) {
                if (i != 0) {
                    sumArr[i + 1] = sumArr[i];
                }
                sumArr[i + 1] += array[i];
            }

            int[][] dp = new int[N + 1][N + 1];

            for (int bindCount = 1; bindCount < N; bindCount++) {
                for (int start = 1; start + bindCount <= N; start++) {
                    int end = start + bindCount;
                    dp[start][end] = Integer.MAX_VALUE;
                    for (int mid = start; mid < end; mid++) {
                        dp[start][end] = Integer.min(dp[start][end],
                            dp[start][mid] + dp[mid + 1][end] + sumArr[end] - sumArr[start - 1]);
                    }
                }
            }
            System.out.println(dp[1][N]);
        }
    }
}
/*
3
6 + 16 = 22

1 5 10

12, 10

22 + 22 = 44

 */
