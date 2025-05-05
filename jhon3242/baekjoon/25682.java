import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int K;
    static char[][] graph;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        dp = new int[N][M][2];

        initDp();

        int result = Integer.MAX_VALUE;
        boolean isDiff = K % 2 == 1;
        for (int i = K - 1; i < N; i++) {
            for (int j = K - 1; j < M; j++) {

                if (i == K - 1 && j == K - 1) {
                    result = Math.min(dp[i][j][0], dp[i][j][1]);
                    continue;
                }
                int tmp = Integer.MAX_VALUE;
                if (i == K - 1) {
                    if (isDiff) {
                        tmp = Math.min(dp[i][j][0] - dp[i][j - K][1], dp[i][j][1] - dp[i][j - K][0]);
                    } else {
                        tmp = Math.min(dp[i][j][0] - dp[i][j - K][0], dp[i][j][1] - dp[i][j - K][1]);
                    }
                    result = Math.min(tmp, result);
                    continue;
                }

                if (j == K - 1) {
                    if (isDiff) {
                        tmp = Math.min(dp[i][j][0] - dp[i - K][j][1], dp[i][j][1] - dp[i - K][j][0]);
                    } else {
                        tmp = Math.min(dp[i][j][0] - dp[i - K][j][0], dp[i][j][1] - dp[i - K][j][1]);
                    }
                    result = Math.min(tmp, result);
                    continue;
                }

                if (isDiff) {
                    tmp = Math.min(dp[i][j][0] - dp[i - K][j][1] - dp[i][j - K][1] + dp[i - K][j - K][0]
                            , dp[i][j][1] - dp[i - K][j][0] - dp[i][j - K][0] + dp[i - K][j - K][1]);
                } else {
                    tmp = Math.min(dp[i][j][0] - dp[i - K][j][0] - dp[i][j - K][0] + dp[i - K][j - K][0]
                            , dp[i][j][1] - dp[i - K][j][1] - dp[i][j - K][1] + dp[i - K][j - K][1]);
                }
                result = Math.min(tmp, result);

            }
        }
        System.out.println(result);

//        boolean isWhite = true;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (isWhite) {
//                    System.out.print(dp[i][j][1] + " ");
//                } else {
//                    System.out.print(dp[i][j][0] + " ");
//                }
//                isWhite = !isWhite;
//            }
//            System.out.println();
//        }
    }

    private static void initDp() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                boolean isWhite = isWhite(i, j);
                if (i == 0 && j == 0) {
                    if (isWhite) {
                        dp[i][j][0]++;
                    } else {
                        dp[i][j][1]++;
                    }
                    continue;
                }
                if (i == 0) {
                    dp[i][j][1] = dp[i][j - 1][0];
                    dp[i][j][0] = dp[i][j - 1][1];
                    if (isWhite) {
                        dp[i][j][0]++;
                    } else {
                        dp[i][j][1]++;
                    }
                    continue;
                }
                if (j == 0) {
                    dp[i][j][1] = dp[i - 1][j][0];
                    dp[i][j][0] = dp[i - 1][j][1];
                    if (isWhite) {
                        dp[i][j][0]++;
                    } else {
                        dp[i][j][1]++;
                    }
                    continue;
                }

                dp[i][j][1] = dp[i - 1][j][0] + dp[i][j - 1][0] - dp[i - 1][j - 1][1];
                dp[i][j][0] = dp[i - 1][j][1] + dp[i][j - 1][1] - dp[i - 1][j - 1][0];
                if (isWhite) {
                    dp[i][j][0]++;
                } else {
                    dp[i][j][1]++;
                }
            }
        }
    }

    private static boolean isWhite(int x, int y) {
        return graph[x][y] == 'W';
    }
}
