import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

/*

2 -> 1
3 -> 1
4 -> 2 -> 1
5 -> 4 -> 3 -> 1
6 -> 3 -> 1


 */

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        dp[1] = 0;

        if (N >= 2) {
            dp[2] = 1;
        }

        if (N >= 3) {
            dp[3] = 1;
        }

        for (int i = 4; i <= N; i++) {
            int minValue = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                minValue = Math.min(minValue, dp[i / 2]);
            }
            if (i % 3 == 0) {
                minValue = Math.min(minValue, dp[i / 3]);
            }
            minValue = Math.min(minValue, dp[i - 1]);
            dp[i] = minValue + 1;
        }

        System.out.println(dp[N]);
    }
}
