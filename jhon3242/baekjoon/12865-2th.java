package backjoon.n12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

  1 2 3 4 5  6  7
3 0 0 6 6 6  6  6
4 0 0 6 8 8  8  14
5 0 0 6 8 12 12
6 0 0 6 8 12 12



- 현재 배낭보다 무게가 크면 이전 값을 그대로 가져온다
- 현재 가방을 넣고 남은 무게에 해당하는 dp값을 추가한다

6 13
4 8
3 6
5 12


 */

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N + 1][2];
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[i] = new int[]{w, v};
        }

        Arrays.sort(graph, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 1; i <= K; i++) {
            int curWeight = i;
            for (int j = 1; j <= N; j++) {
                int weight = graph[j][0];
                int value = graph[j][1];

                if (curWeight < weight) {
                    dp[curWeight][j] = dp[curWeight][j - 1];
                    continue;
                }
                dp[curWeight][j] = Math.max(dp[curWeight - weight][j - 1] + value, dp[curWeight][j - 1]);
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dp[K][i]);
        }
        System.out.println(result);
    }
}
