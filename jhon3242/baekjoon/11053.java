import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[N + 5];

        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    max = Integer.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
