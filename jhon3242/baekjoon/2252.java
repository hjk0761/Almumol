package backjoon.n2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] graph;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        indegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            indegree[to]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                deque.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            int polled = deque.poll();
            sb.append(polled).append(" ");
            for (int next : graph[polled]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    deque.add(next);
                }
            }
        }
        System.out.println(sb);
    }
}
