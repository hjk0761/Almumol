package backjoon.n14496;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] cost = new int[N + 1];
        int INF = N + 1;
        Arrays.fill(cost, INF);

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{from, 0});
        while (!deque.isEmpty()) {
            int[] polled = deque.pollFirst();
            int curTo = polled[0];
            int curCost = polled[1];

            if (cost[curTo] != INF) {
                continue;
            }
            cost[curTo] = curCost;
            if (curTo == to) {
                break;
            }
            for (int next : graph[curTo]) {
                if (cost[next] > curCost + 1) {
                    deque.add(new int[]{next, curCost + 1});
                }
            }
        }
        if (cost[to] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(cost[to]);
        }
    }
}
