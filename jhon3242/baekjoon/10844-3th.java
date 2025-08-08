package backjoon.n10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*

N : 1,000,000,000

1자리
1 ~ 9

2자리 : 1,9를 제외한 숫자로 시작하는 수는 2개
12
21
23
10

3자리: 1,9를 제외한 숫자로 시작하는 수는

212
234
232

321
323
343
345

n자리: dp[n - 1][k]
 */
public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[101][11];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= 100; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                dp[i][j] %= 1_000_000_000;
            }
        }
//        for (int i = 1; i <= 4; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
            result %= 1_000_000_000;
        }
        System.out.println(result);
    }
}
