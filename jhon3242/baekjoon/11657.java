package backjoon.n11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int E;
    static List<Node> graph;
    static long[] distance;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        distance = new long[N + 1];
        Arrays.fill(distance, INF);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new Node(from, to, cost));
        }

        if (bell(1)) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(distance[i]);
                }
            }
        }
    }

    private static boolean bell(int start) {
        int t = N;
        distance[start] = 0;
        while (t-- > 0) {
            for (Node next : graph) {
                if (distance[next.form] == INF) {
                    continue;
                }
                if (distance[next.to] > distance[next.form] + next.cost) {
                    distance[next.to] = distance[next.form] + next.cost;
                    if (t == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static class Node implements Comparable<Node> {
        int form;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.form = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
