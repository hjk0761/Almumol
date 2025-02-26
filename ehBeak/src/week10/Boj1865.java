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


public class Boj1865 {

    static class Node {
        int x;
        int w;
        int cnt;
        List<Integer> nodes;

        public Node(int x, int w, int cnt, List<Integer> nodes) {
            this.x = x;
            this.w = w;
            this.cnt = cnt;
            this.nodes = nodes;
            if (nodes != null) {
                nodes.add(x);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, w, 0, null));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.w, n2.w));
        queue.add(new Node(start, 0, 1, new ArrayList<>()));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if (curNode.x == end) {
                bw.write(curNode.w+"\n"+curNode.cnt+"\n");
                for (int i = 0; i < curNode.nodes.size(); i++) {
                    bw.write(curNode.nodes.get(i) + " ");
                }
                break;
            }

            if (curNode.w > dist[curNode.x]) {
                continue;
            }

            for (Node adjNode : graph.get(curNode.x)) {
                if (adjNode.w + dist[curNode.x] < dist[adjNode.x]) {
                    dist[adjNode.x] = adjNode.w + dist[curNode.x];
                    queue.add(new Node(adjNode.x, dist[adjNode.x],
                            curNode.cnt + 1, new ArrayList<>(curNode.nodes)));
                }
            }
        }

        bw.flush();
    }
}
