import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static String[] patterns;
    static boolean[] compatible;
    static int[] memo;
    static final int INF = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        patterns = new String[N];
        for (int i = 0; i < N; i++) {
            patterns[i] = br.readLine().trim();
        }

        int total = 1 << N;
        compatible = new boolean[total];
        for (int mask = 0; mask < total; mask++) {
            compatible[mask] = isCompatible(mask);
        }

        memo = new int[total];
        Arrays.fill(memo, -1);

        int ans = dp(total - 1);
        System.out.println(ans);
    }

    static int dp(int mask) {
        if(mask == 0) return 0;
        if(memo[mask] != -1) return memo[mask];
        if(compatible[mask]) {
            memo[mask] = 1;
            return 1;
        }

        int ans = INF;
        for (int submask = mask; submask > 0; submask = (submask - 1) & mask) {
            if(compatible[submask]) {
                int remaining = mask & ~submask;
                ans = Math.min(ans, 1 + dp(remaining));
            }
        }
        memo[mask] = ans;
        return ans;
    }

    static boolean isCompatible(int mask) {
        for (int pos = 0; pos < M; pos++) {
            char fixed = 0;
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    char c = patterns[i].charAt(pos);
                    if(c == '.') continue;
                    if(fixed == 0) {
                        fixed = c;
                    } else if(fixed != c) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
