import java.util.*;
import java.io.*;


public class Main {

    private static int N, R, Q;
    private static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NRQ = br.readLine().split(" ");
        N = Integer.parseInt(NRQ[0]);
        R = Integer.parseInt(NRQ[1]);
        Q = Integer.parseInt(NRQ[2]);
        nodes = new Node[N+1];
        for(int i = 1; i < N + 1; i++) {
            nodes[i] = new Node(i);
        }

        for(int i = 0; i < N - 1; i++) {
            String[] UV = br.readLine().split(" ");
            int U = Integer.parseInt(UV[0]);
            int V = Integer.parseInt(UV[1]);

            nodes[U].addChild(nodes[V]);
            nodes[V].addChild(nodes[U]);
        }
        Node rootNode = nodes[R];
        Set<Node> subnodesOfRoot = rootNode.childrens;
        for(Node node : subnodesOfRoot) {
            node.removeParant(rootNode);
        }

        for(int i = 0; i < Q; i++) {
            int node = Integer.parseInt(br.readLine());
            System.out.println(nodes[node].numberOfSubNodes());
        }
    }

    private static class Node {
        int num;
        Set<Node> childrens = new HashSet<>();
        int subnodeCount = 0;

        public Node(int num) {
            this.num = num;
        }

        public void removeParant(Node parant) {
            childrens.remove(parant);
            for(Node child : childrens) {
                child.removeParant(this);
            }
        }

        public void addChild(Node child) {
            childrens.add(child);
        }

        public int numberOfSubNodes() {
            if(subnodeCount != 0) return subnodeCount;
            int total = 1;
            for(Node child : childrens) {
                total += child.numberOfSubNodes();
            }
            subnodeCount = total;
            return total;
        }
    }
}
