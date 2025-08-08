package backjoon.n1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[1_000_001];
        int N = Integer.parseInt(br.readLine());

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(N, 0));
        while (!pq.isEmpty()) {
            Node polled = pq.poll();
            if (dp[polled.idx] < polled.cost) {
                continue;
            }
            if (polled.idx == 1) {
                System.out.println(polled.cost);
                return;
            }
            dp[polled.idx] = polled.cost;
            pq.add(new Node(polled.idx - 1, polled.cost + 1));
            if (polled.idx % 3 == 0) {
                pq.add(new Node(polled.idx / 3, polled.cost + 1));
            }
            if (polled.idx % 2 == 0) {
                pq.add(new Node(polled.idx / 2, polled.cost + 1));
            }
        }
    }

    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
