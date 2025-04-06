import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P11049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));;

        int n = Integer.parseInt(br.readLine());

        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nodes.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int [][] data = new int [n][n];

        for (int dist = 0; dist < n; dist++) {
            for (int i = 0; i < n-dist; i++) {
                if(dist == 1) {
                    Node node1 = nodes.get(i);
                    Node node2 = nodes.get(i+dist);
                    data[i][i+dist] = node1.a * node2.a * node2.b;
                    continue;
                }

                if(dist >= 2) {
                    int result = Integer.MAX_VALUE;
                    for (int j = i; j <i+dist ; j++) {
                        Node node = nodes.get(i);
                        Node node1 = nodes.get(j);
                        Node node2 = nodes.get(i+dist);
                        int d = data[i][j] + data[j+1][i+dist] + node.a * node1.b * node2.b;

                        result = Math.min(d, result);
                    }
                    data[i][i+dist] = result;
                }
            }
        }

        System.out.println(data[0][n-1]);

    }

    static class Node {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}
