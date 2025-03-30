import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class P2157 {

    static int n; //도시의 개수
    static int m; //최소로 거쳐야 하는 항공기 개수
    static int k; //항공로 개수
    static int [][] data; //n번 노드에 m회에 있을 때 최대값
    static Map<Integer, List<Node>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        data = new int[n+1][m+1];

        for (int i = 0; i < n+1; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a<b) {
                map.get(a).add(new Node(a,b,c));
            }
        }

        bfs(1);

        int result = 0;

        for(int i=0; i<m+1; i++) {
            result = Math.max(result, data[n][i]);
        }

        System.out.println(result);
    }

    static void bfs(int firstStart) {
        Deque<Log> logs = new ArrayDeque<>();
        logs.add(new Log(firstStart, 1, 0));

        while(!logs.isEmpty()) {
            Log log = logs.pop();
            if(log.cnt ==m) {
                return;
            }

            List<Node> next = map.get(log.start);
            int cnt = log.cnt;
            int start = log.start;
            int eat = log.eat;

            for (Node node : next) {
                int to = node.to;
                int value = node.value;
                if(data[to][cnt+1] < data[start][cnt]+value) {
                    data[to][cnt + 1] =  data[start][cnt] + value;
                    logs.add(new Log(to, cnt+1, eat + value));
                }
            }
        }
    }

    static class Log {
        int start;
        int cnt;
        int eat;

        public Log(int start, int cnt, int eat) {
            this.start = start;
            this.cnt = cnt;
            this.eat = eat;
        }
    }

    static class Node {
        int from;
        int to;
        int value;

        public Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }
}
