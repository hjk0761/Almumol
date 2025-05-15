package week10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Boj11404 {

    static class Node {
        public int x;
        public int w;

        public Node(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }

    static int n, m;
    static List<List<Node>> graph = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine()); // 도시의 개수
        m = Integer.parseInt(br.readLine()); // 버스의 개수


        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, w));
        }

        for (int i = 1; i <= n; i++) {
            cost(i);
        }
        bw.flush();
    }

    public static void cost(int start) throws IOException {

        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.w, n2.w));
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if (dist[curNode.x] < curNode.w) {
                continue;
            }

            for (Node adjNode : graph.get(curNode.x)) {
                if (adjNode.w + dist[curNode.x] < dist[adjNode.x]) {
                    dist[adjNode.x] = adjNode.w + dist[curNode.x];
                    queue.add(new Node(adjNode.x, dist[adjNode.x]));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                bw.write("0 ");
            } else {
                bw.write(dist[i] + " ");
            }
        }
        bw.write("\n");
    }
}
