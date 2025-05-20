package backjoon.n1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Main {

    static int N;
    static int K;
    static List<Node> nodes;
    static int[] bags;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nodes = new ArrayList<>();
        bags = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            nodes.add(new Node(weight, value));
        }
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Collections.sort(nodes, (a, b) -> {
            if (a.weight == b.weight) {
                return b.value - a.value;
            }
            return a.weight - b.weight;
        });
        Arrays.sort(bags);

        long result = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int j = 0;
        for (int i = 0; i < K; i++) {
            int bag = bags[i];

            while (j < N) {
                Node cur = nodes.get(j);
                if (cur.weight <= bag) {
                    pq.add(cur);
                    j++;
                    continue;
                }
                break;
            }

            if (pq.isEmpty()) {
                continue;
            }
            result += pq.poll().value;
        }
        System.out.println(result);
    }

    static class Node implements Comparable<Node> {
        int weight;
        int value;

        public Node(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int compareTo(Node o) {
            return o.value - value;
        }
    }
}
