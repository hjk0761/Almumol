import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static List<Integer>[] NUMS;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        NUMS = new ArrayList[N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split(" ");
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                row.add(Integer.parseInt(nums[j]));
            }
            NUMS[i] = row;
        }

        for(int i = 0; i < N; i++) {
            dp[N-1][i] = NUMS[N-1].get(i);
        }

        for (int i = N - 2; i >= 0; i--) {
            for(int j = 0; j < NUMS[i].size(); j++) {
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + NUMS[i].get(j);
            }
        }

        System.out.println(dp[0][0]);
    }
}
