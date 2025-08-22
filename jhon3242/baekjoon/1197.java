package backjoon.n1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
//    static List<Road> graph;
    static List<Road>[] graph;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
//        graph = new List[N + 1];
//        for (int i = 0; i <= N; i++) {
//            graph[i] = new ArrayList<>();
//        }
//        graph = new ArrayList<>();
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
        int result = 0;
        PriorityQueue<Road> pq = new PriorityQueue<>();
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Road(from, to, cost));

        }

        while (!pq.isEmpty()) {
            Road polled = pq.poll();
            if (find(polled.from) != find(polled.to)) {
                union(polled.from, polled.to);
                result += polled.cost;
            }
        }
        System.out.println(result);
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    private static int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    static class Road implements Comparable<Road>{
        int from;
        int to;
        int cost;

        public Road(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return cost - o.cost;
        }
    }
}
