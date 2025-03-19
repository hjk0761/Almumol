import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int maxLength = 1;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        int[] A = new int[n];
        String[] nums = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(nums[i]);
        }
        int result = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
