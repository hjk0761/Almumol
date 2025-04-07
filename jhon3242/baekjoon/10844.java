import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*


10  1
21  0
    2
32  1
    3
43  2
    4
54  3
    5
65  4
    6
76  7
    5
87  6
    8
98  7
    9
89  8
78  7
    9
67  8
    6
56  5
    7
45  4
    6
34  3
    5
23  2
    4
12  1
    3





 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 1_000_000_000;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {

                if (j == 0) {
                    dp[i][j] = dp[i - 1][1];
                    continue;
                }
                if (j == 9) {
                    dp[i][j] = dp[i - 1][8];
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                dp[i][j] %= mod;
            }
        }

        long result = 0L;

        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
            result %= mod;
        }
        System.out.println(result);
    }
}
