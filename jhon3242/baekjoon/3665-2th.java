package backjoon.n3665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/*

5
5 4 3 2 1
2
2 4
3 4

정확한 순위는 알 수 없는 경우가 있다? -> 위상 정렬
  1 2 3 4 5
1 F T T T T
2 F F T F T
3 F F F F T
4 F T T F T
5 F F F F F

5 3 2 4 1
 */
public class Main2 {
    static int N;
    static int M;
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            N = Integer.parseInt(br.readLine());
            graph = new boolean[N + 1][N + 1];

            int[] oldRank = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                oldRank[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                int cur = oldRank[i];
                for (int j = i + 1; j <= N; j++) {
                    int next = oldRank[j];
                    graph[cur][next] = true;
                }
            }

            M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if (graph[u][v]) {
                    graph[u][v] = false;
                    graph[v][u] = true;
                } else {
                    graph[u][v] = true;
                    graph[v][u] = false;
                }
            }
            topologicalSort();
        }
    }

    private static void topologicalSort() {
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int[] indegree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j]) {
                    indegree[j]++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        for (int i = 0; i < N; i++) {
            if (queue.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            if (queue.size() != 1) {
                System.out.println("?");
                return;
            }

            int polled = queue.poll();
            sb.append(polled).append(" ");

            for (int j = 1; j <= N; j++) {
                if (graph[polled][j]) {
                    indegree[j]--;
                    if (indegree[j] == 0) {
                        queue.add(j);
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
