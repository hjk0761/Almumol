import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
7

13 8 6 12
6  4 3 5

6 8 12 13
3 4 5  6

4 7
1 5
1 2
1 7
3 15



 */

public class Main {
    static int N;
    static int K;
    static int[] wArr;
    static int[] vArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        wArr = new int[N];
        vArr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            wArr[i] = w;
            vArr[i] = v;
        }

        int[][] dp = new int[N][K + 1];
        for (int i = 0; i < N; i++) {
            int curW = wArr[i];
            int curV = vArr[i];
            for (int j = 1; j <= K; j++) {
                if (j < curW) {
                    if (i == 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = curV;
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j - curW] + curV, dp[i - 1][j]);
            }
        }

        System.out.println(dp[N - 1][K]);
    }
}
