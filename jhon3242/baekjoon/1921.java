import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

10 -4 3 1  5   6 -35 12 21 -1
10  6 9 10 15 16 -19 12 23 22

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[N];
        dp[0] = array[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
        }

        int maxValue = -1000;
        for (int i = 0; i < N; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(maxValue);
    }
}
