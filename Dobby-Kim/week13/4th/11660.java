import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int[][] NUMS;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        NUMS = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String[] nums = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                NUMS[i][j] = Integer.parseInt(nums[j - 1]);
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + NUMS[i][j];
            }
        }

        while (M-- > 0) {
            String[] range = br.readLine().split(" ");
            int x1 = Integer.parseInt(range[0]);
            int y1 = Integer.parseInt(range[1]);
            int x2 = Integer.parseInt(range[2]);
            int y2 = Integer.parseInt(range[3]);
            System.out.println(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1 - 1][y1 - 1]);
        }
    }
}
