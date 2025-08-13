import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int N, K;
	private static int coin;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K + 1];

		dp[0] = 1;

		for (int i = 0; i < N; i++) {
			coin = Integer.parseInt(br.readLine());
			for (int j = 1; j < K + 1; j++) {
				if (j >= coin) {
					dp[j] = dp[j] + dp[j - coin];
				}
			}
		}
		System.out.println(dp[K]);
	}
}
