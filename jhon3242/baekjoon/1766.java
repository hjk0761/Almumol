package backjoon.n1766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static List<Integer>[] graph;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        inDegree = new int[N  +1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            inDegree[b]++;
        }

        topologicalSort();
    }

    private static void topologicalSort() {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int polled = pq.poll();
            sb.append(polled).append(" ");
            for (int next : graph[polled]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    pq.add(next);
                }
            }
        }
        System.out.println(sb);
    }
}
