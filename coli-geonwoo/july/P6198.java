import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Node> nums = new ArrayDeque<>();
        Deque<Node> q = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Node node = new Node(Long.parseLong(br.readLine()), i);
            nums.add(node);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            Node cur = nums.pollLast();

            while(!q.isEmpty() && cur.num > q.peekLast().num) {
                q.pollLast();
            }
            if(!q.isEmpty()){
                result +=(q.peekLast().index - cur.index -1);
            }else {
                result += (n-cur.index-1);
            }
            q.add(cur);
        }

        System.out.println(result);
    }

    static class Node {
        long num;
        long index;

        public Node(long num, long index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", index=" + index +
                    '}';
        }
    }
}
