package backjoon.n1956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int E;
    static int[][] graph;
    static int INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        INF = 400 * 400 * 10_000;
        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], INF);
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[f][t] = c;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    graph[i][k] = (int) Math.min(graph[i][k], (long) graph[i][j] + graph[j][k]);
                }
            }
        }
        System.out.println(getResult());
    }

    private static int getResult() {
        long result = INF;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                result = Math.min(result, (long)graph[i][j] + graph[j][i]);
            }
        }
        if (result >= INF) {
            return -1;
        }
        return (int) result;
    }
}
