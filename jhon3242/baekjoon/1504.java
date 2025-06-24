package backjoon.n1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Main {
    static int N;
    static int E;
    static List<Node>[] graph;
    static int[] points;
    static int MAX = 200_000 * 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        points = new int[2];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[f].add(new Node(t, cost));
            graph[t].add(new Node(f, cost));
        }
        st = new StringTokenizer(br.readLine());
        points[0] = Integer.parseInt(st.nextToken());
        points[1] = Integer.parseInt(st.nextToken());

        int[] startArr = dijkstra(1);
        int[] aArr = dijkstra(points[0]);
        int[] bArr = dijkstra(points[1]);

        int a = startArr[points[0]] + aArr[points[1]] + bArr[N];
        int b = startArr[points[1]] + bArr[points[0]] + aArr[N];

        int result = Math.min(a, b);
        if (result >= MAX) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] result = new int[N + 1];
        Arrays.fill(result, MAX);
        result[start] = 0;

        for (Node o : graph[start]) {
            if (result[o.to] > o.cost) {
                result[o.to] = o.cost;
            }
            pq.add(o);
        }

        while (!pq.isEmpty()) {
            Node polled = pq.poll();
            for (Node o: graph[polled.to]) {
                if (result[o.to] > result[polled.to] + o.cost) {
                    result[o.to] = result[polled.to] + o.cost;
                    pq.add(new Node(o.to, result[polled.to] + o.cost));
                }
            }
        }
        return result;
    }

    static class Node implements Comparable<Node>{
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
