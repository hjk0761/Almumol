package backjoon.n9370;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Main {
    static int N;
    static int M;
    static int T;
    static int start;
    static int[] road;
    static List<Integer> candidate;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(br.readLine());
        while (tCase-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            graph = new List[N + 1];
            road = new int[2];
            candidate = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<Node>();
            }

            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            road[0] = Integer.parseInt(st.nextToken());
            road[1] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int f = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph[f].add(new Node(t, cost));
                graph[t].add(new Node(f, cost));
            }

            for (int i = 0; i < T; i++) {
                candidate.add(Integer.parseInt(br.readLine()));
            }

            int[] startCost = dijkstra(start);

            int[] roadACost = dijkstra(road[0]);
            int[] roadBCost = dijkstra(road[1]);

            int[] candiCost = new int[candidate.size()];
            for (int i = 0; i < candidate.size(); i++) {
                int candi = candidate.get(i);
                candiCost[i] = Math.min(startCost[road[0]] + roadACost[road[1]] + roadBCost[candi],
                        startCost[road[1]] + roadBCost[road[0]] + roadACost[candi]);
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < candidate.size(); i++) {
                int cur = candidate.get(i);
                if (candiCost[i] == startCost[cur]) {
                    result.add(cur);
                }
            }
            Collections.sort(result);
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static int[] dijkstra(int start) {
        int[] cost = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(cost, Integer.MAX_VALUE);

        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node polled = pq.poll();
            if (cost[polled.to] != Integer.MAX_VALUE) {
                continue;
            }
            cost[polled.to] = polled.cost;
            for (Node next : graph[polled.to]) {
                if (cost[next.to] > cost[polled.to] + next.cost) {
                    pq.add(new Node(next.to, cost[polled.to] + next.cost));
                }
            }
        }
        return cost;
    }

    static class Node implements Comparable<Node> {
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
