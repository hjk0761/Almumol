import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

30 19 5
64 77 64
15 19 97
4 71 57
90 86 84
93 32 91

5 64 97 57 84 91
19 77 19 71 86 32
30 64 15 4 90 93

dp
5  83 97+69
19 83 19+69
30 69 15+83



 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[3][N];
        int[][] dp = new int[3][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            int c =Integer.parseInt(st.nextToken());

            arr[0][i] = a;
            arr[1][i] = b;
            arr[2][i] = c;
        }

        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[2][0] = arr[2][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int minDp = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k == j) continue;
                    minDp = Math.min(dp[k][i - 1], minDp);
                }
                dp[j][i] = minDp + arr[j][i];
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            result = Math.min(result, dp[i][N - 1]);
        }
        System.out.println(result);
    }
}
