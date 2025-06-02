package backjoon.n3665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] oldRank;
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            N = Integer.parseInt(br.readLine());
            oldRank = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                oldRank[i] = Integer.parseInt(st.nextToken());
            }

            graph = new boolean[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                int cur = oldRank[i];
                for (int j = i + 1; j <= N; j++) {
                    graph[cur][oldRank[j]] = true;
                }
            }

            M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (graph[a][b]) {
                    graph[a][b] = false;
                    graph[b][a] = true;
                } else {
                    graph[a][b] = true;
                    graph[b][a] = false;
                }
            }
            topologicalSort();
        }
    }

    private static void topologicalSort() {
        StringBuilder sb = new StringBuilder();
        int[] indegree = new int[N + 1];
        for (int u = 1; u <= N; u++) {
            for (int v = 1; v <= N; v++) {
                if (graph[u][v]) {
                    indegree[v]++;
                }
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                deque.add(i);
            }
        }

        for (int step = 0; step < N; step++) {
            if (deque.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            if (deque.size() > 1) {
                System.out.println("?");
                return;
            }
            int polled = deque.poll();
            sb.append(polled).append(" ");
            for (int i = 1; i <= N; i++) {
                if (graph[polled][i]) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        deque.add(i);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
