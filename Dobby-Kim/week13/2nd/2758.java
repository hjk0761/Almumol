import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int answer;
    private static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] NM = br.readLine().split(" ");
            N = Integer.parseInt(NM[0]);
            M = Integer.parseInt(NM[1]);
            memo = new int[N+ 1][M + 1];
            // Base case: 첫 번째 숫자는 1부터 m까지 아무거나 선택 가능.
            System.out.println(bottomUpDp());
        }
    }

    private static long bottomUpDp() {
        for (int j = 1; j <= m; j++) {
            memo[1][j] = 1;
        }
        // memo 계산
        for (int i = 2; i <= n; i++) {
            // memo[i-1]의 prefix 합을 계산 (1-indexed)
            long[] prefix = new long[m+1];
            prefix[0] = 0;
            for (int j = 1; j <= m; j++) {
                prefix[j] = prefix[j-1] + memo[i-1][j];
            }
            // i번째 숫자 j를 선택할 때, 이전 숫자는 최대 floor(j/2)
            for (int j = 1; j <= m; j++) {
                int maxPrev = j / 2;
                if(maxPrev >= 1) {
                    memo[i][j] = prefix[maxPrev];
                }
            }
        }

        // 모든 j에 대해 memo[n][j]의 합이 최종 경우의 수.
        long result = 0;
        for (int j = 1; j <= m; j++) {
            result += memo[n][j];
        }
        return result;
    }
}
