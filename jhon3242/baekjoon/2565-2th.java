import java.beans.IntrospectionException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        if (N >= 2) {
            dp[1] = arr[0] + arr[1];
        }
        if (N >= 3) {
            dp[2] = Math.max(Math.max(arr[0], arr[1]) + arr[2], dp[1]);
        }

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i], dp[i - 1]);
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
