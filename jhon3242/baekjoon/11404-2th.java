package backjoon.n11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        int INF = 100_000 * 100;

        int[][] graph = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], INF);
        }
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[f][t] = Math.min(graph[f][t], c);
        }

        for (int i = 1; i <= N; i++) {
            graph[i][i] = 0;
        }

//        for (int z = 0; z < N; z++) {
//        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == INF) {
                    sb.append(0);
                } else {
                    sb.append(graph[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
