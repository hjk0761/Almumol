import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int[] NUMS;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        NUMS = new int[N+1];
        dp = new int[N+1];
        String[] nums = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) {
            NUMS[i] = Integer.parseInt(nums[i-1]);
        }
        dp[0] = 0;
        for(int i = 1; i <= N; i++) {
            dp[i] = dp[i-1] + NUMS[i];
        }

        while(M-- > 0) {
            String[] range = br.readLine().split(" ");
            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);
            System.out.println(dp[end] - dp[start-1]);
        }
    }
}
