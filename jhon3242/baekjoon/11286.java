import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll().value).append("\n");
                }
                continue;
            }
            Node node = new Node(num);
            pq.add(node);
        }

        System.out.println(sb);

    }

    static class Node implements Comparable<Node> {
        int value;

        public Node(int value) {
            this.value = value;
        }

        public int compareTo(Node o) {
            int diff = Math.abs(value) - Math.abs(o.value);
            if (diff == 0) {
                return value - o.value;
            }
            return diff;
        }
    }
}
