package backjoon.n2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] graph;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[2][N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        System.out.println(getResult());
    }

    private static int getResult() {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.add(new Pos(0, 0, 1, 0));

        while (!pq.isEmpty()) {
            Pos polled = pq.poll();
            if (visited[polled.breaked][polled.x][polled.y]) {
                continue;
            }
            visited[polled.breaked][polled.x][polled.y] = true;

            if (polled.x == N - 1 && polled.y == M - 1) {
                return polled.cost;
            }

            int[] dx = new int[]{1, 0, -1, 0};
            int[] dy = new int[]{0, -1, 0, 1};
            for (int i = 0; i < 4; i++) {
                int tx = polled.x + dx[i];
                int ty = polled.y + dy[i];
                if (tx < 0 || tx >= N || ty < 0 || ty >= M || visited[polled.breaked][tx][ty]) {
                    continue;
                }
                if (graph[tx][ty] == 1 && polled.breaked == 0) {
                    pq.add(new Pos(tx, ty, polled.cost + 1, 1));
                    continue;
                }
                if (graph[tx][ty] == 0) {
                    pq.add(new Pos(tx, ty, polled.cost + 1, polled.breaked));
                    continue;
                }
            }
        }
        return -1;
    }

    static class Pos implements Comparable<Pos>{
        int x;
        int y;
        int cost;
        int breaked;

        public Pos(int x, int y, int cost, int breaked ) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.breaked = breaked;
        }

        @Override
        public int compareTo(Pos o) {
            return cost - o.cost;
        }

        public String toString() {
            return "x = " + x + ", y = " + y + ", cost = " + cost + ", breaked = " + breaked;
        }
    }
}
