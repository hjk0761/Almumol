import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class P1863 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes.add(new Node(x, y));
        }

        nodes.sort(Comparator.comparing(Node::getX).thenComparing(Node::getY));
        int cnt = 0;
        Deque<Integer> skylines = new ArrayDeque<>();

        for(Node node : nodes) {
            int y = node.getY();

            //0은 들어가면 안됨
            if(y==0){
                cnt += skylines.size();
                skylines.clear();
                continue;
            }

            if(!skylines.isEmpty() && skylines.peekLast() < y){
                skylines.add(y);
                continue;
            }

            while(!skylines.isEmpty()) {
                int bound = skylines.pollLast();
                if(bound == y) {
                    break;
                }

                if(bound < y){
                    skylines.add(bound);
                    break;
                }

                if(bound > y){
                    cnt++;
                }
            }

            skylines.add(y);
        }

        cnt += skylines.size();
        System.out.println(cnt);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
