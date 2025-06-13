package backjoon.n1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int E;
    static int start;
    static List<Road>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[u].add(new Road(v, cost));
        }

        getResult();
    }

    private static void getResult() {
        int[] cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.add(new Road(start, 0));

        while (!pq.isEmpty()) {
            Road polled = pq.poll();
            // ??
            if (cost[polled.to] < polled.cost) {
                continue;
            }
            cost[polled.to] = polled.cost;
            for (Road road : graph[polled.to]) {
                if (cost[road.to] > cost[polled.to] + road.cost) {
                    pq.add(new Road(road.to, cost[polled.to] + road.cost));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (cost[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(cost[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    static class Road implements Comparable<Road> {
        int to;
        int cost;

        public Road(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Road o) {
            return cost - o.cost;
        }
    }
}
