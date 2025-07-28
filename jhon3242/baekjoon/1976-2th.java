package backjoon.n1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static int N;
    static int M;
    static int[][] graph;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        rank = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            rank[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            int[] array = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < N; j++) {
                graph[i][j + 1] = array[j];
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int[] road = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int pre = road[0];
        for (int i = 1; i < M; i++) {
            int cur = road[i];
            if (rank[pre] != rank[cur]) {
                System.out.println("NO");
                return;
            }
            pre = cur;
        }
        System.out.println("YES");
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            rank[b] = a;
        } else {
            rank[a] = b;
        }
    }

    private static int find(int x) {
        if (rank[x] != x) {
            rank[x] = find(rank[x]);
        }
        return rank[x];
    }
}
