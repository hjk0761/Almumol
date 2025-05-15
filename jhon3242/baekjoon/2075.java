package backjoon.n2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue[] pqs = new PriorityQueue[N];
        for (int i = 0; i < N; i++) {
            pqs[i] = new PriorityQueue<Node>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Node node = new Node(Integer.parseInt(st.nextToken()));
                pqs[j].add(node);
            }
        }

        for (int i = 1; i <= N; i++) {
            int maxIdx = -1;
            int maxValue = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
                PriorityQueue<Node> pq = pqs[j];
                if (!pq.isEmpty() && pq.peek().value > maxValue) {
                    maxIdx = j;
                    maxValue = pq.peek().value;
                }
            }
//            System.out.println(maxIdx + " " + maxValue);
            PriorityQueue<Node> pq = pqs[maxIdx];
            int value = pq.poll().value;
            if (i == N) {
                System.out.println(value);
            }
        }
    }

    static class Node implements Comparable<Node> {
        int value;

        public Node(int value) {
            this.value = value;
        }

        public int compareTo(Node o) {
            return o.value - value;
        }
    }
}
