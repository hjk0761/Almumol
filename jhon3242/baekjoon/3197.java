import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] moveGraph;
    static char[][] graph;
    static int[] start = null;
    static int[] end = null;
    static boolean[][] visited;
    static int maxDay = 0;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        moveGraph = new int[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
            Arrays.fill(moveGraph[i], Integer.MAX_VALUE);
        }


//        printG(graph);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] != 'X') {
                    moveGraph[i][j] = 0;

                    for (int k = 0; k < 4; k++) {
                        int[] dx = new int[]{1, 0, -1, 0};
                        int[] dy = new int[]{0, -1, 0, 1};

                        int tx = dx[k] + i;
                        int ty = dy[k] + j;

                        if (tx < 0 || ty < 0 || tx >= N || ty >= M || moveGraph[tx][ty] == 0) {
                            continue;
                        }
                        pq.add(new Node(tx, ty, 1));
                    }

                    if (graph[i][j] == 'L') {
                        if (start == null) {
                            start = new int[]{i, j};
                        } else {
                            end = new int[]{i, j};
                        }
                    }
                }
            }
        }

        bfs();
        System.out.println(findRoute());
    }

    private static int findRoute() {
        visited = new boolean[N][M];

        PriorityQueue<Node> deque = new PriorityQueue<>();

        deque.add(new Node(start[0], start[1], 0));

        while (!deque.isEmpty()) {
            Node poll = deque.poll();
            int x = poll.x;
            int y = poll.y;
            int cost = poll.cost;

            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;

            for (int k = 0; k < 4; k++) {
                int[] dx = new int[]{1, 0, -1, 0};
                int[] dy = new int[]{0, -1, 0, 1};

                int tx = dx[k] + x;
                int ty = dy[k] + y;

                if (tx < 0 || ty < 0 || tx >= N || ty >= M || visited[tx][ty]) {
                    continue;
                }
                if (graph[tx][ty] == 'L') {
                    return cost;
                }
                deque.add(new Node(tx, ty, Math.max(cost, moveGraph[tx][ty])));
            }
        }
        return -1;
    }

    private static void bfs() {

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int px = poll.x;
            int py = poll.y;
            int cost = poll.cost;

            if (moveGraph[px][py] <= cost) {
                continue;
            }

            moveGraph[px][py] = cost;
            maxDay = Math.max(maxDay, cost);

            for (int k = 0; k < 4; k++) {
                int[] dx = new int[]{1, 0, -1, 0};
                int[] dy = new int[]{0, -1, 0, 1};

                int tx = dx[k] + px;
                int ty = dy[k] + py;

                if (tx < 0 || ty < 0 || tx >= N || ty >= M || moveGraph[tx][ty] <= cost + 1) {
                    continue;
                }
                pq.add(new Node(tx, ty, cost + 1));
            }
        }
    }

    static class Node implements Comparable<Node> {

        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
