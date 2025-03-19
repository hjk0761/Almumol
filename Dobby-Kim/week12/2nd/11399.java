import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        String[] times = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            dp[i] = Integer.parseInt(times[i]);
        }
        Arrays.sort(dp);
        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += (dp[i] * (n-i));
        }
        System.out.println(sum);
    }
}
