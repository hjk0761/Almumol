import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

6 10 13 9  8 1
^ ^     ^  ^

6 16 23


 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] graph = new int[N + 5];
        int[] dp = new int[N + 5];

        for (int i = 0; i < N; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = graph[0];
        dp[1] = graph[1] + graph[0];
        dp[2] = Math.max(Math.max(graph[0], graph[1]) + graph[2], dp[1]);

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(Math.max(dp[i - 2], dp[i - 3] + graph[i - 1]) + graph[i], dp[i - 1]);
        }

        int result = 0;
        for (int i = 0; i <= N; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
