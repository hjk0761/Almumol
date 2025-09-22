package backjoon.n3197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
    static int N;
    static int M;
    static char[][] graph;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        int[][] maltGraph = getMaltGraph();
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(maltGraph[i]));
//        }

        int result = getResult(maltGraph);
        System.out.println(result);
    }

    private static int[][] getMaltGraph() {
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(result[i], -1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[2]));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == '.' || graph[i][j] == 'L') {
                    pq.add(new int[]{i, j, 0});
                }
            }
        }

        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            int cx = polled[0];
            int cy = polled[1];
            int cCost = polled[2];
            if (result[cx][cy] != -1) {
                continue;
            }
            result[cx][cy] = cCost;
            for (int i = 0; i < 4; i++) {
                int tx = dx[i] + cx;
                int ty = dy[i] + cy;
                if (tx < 0 || ty < 0 || tx >= N || ty >= M || result[tx][ty] != -1) {
                    continue;
                }
                int nextCost = (graph[tx][ty] == 'X') ? (cCost + 1) : cCost;
                pq.add(new int[]{tx, ty, nextCost});
            }
        }
        return result;
    }

    private static int getResult(int[][] maltGraph) {
        boolean[][] visited = new boolean[N][M];
        int[] start = getStart();
//        System.out.println("Arrays.toString(start) = " + Arrays.toString(start));
//        System.out.println(graph[0][1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(start);
        while (!pq.isEmpty()) {
            int[] polled = pq.poll();
            int cx = polled[0];
            int cy = polled[1];
            int cCost = polled[2];
            if (visited[cx][cy]) {
                continue;
            }
            visited[cx][cy] = true;
            if (graph[cx][cy] == 'L' && !(start[0] == cx && start[1] == cy)) {
                return cCost;
            }
//            System.out.print(" cx = " + cx);
//            System.out.print(" cy = " + cy);
//            System.out.print(" cCost = " + cCost);
//            System.out.println();
            for (int i = 0; i < 4; i++) {
                int tx = dx[i] + cx;
                int ty = dy[i] + cy;
                if (tx < 0 || ty < 0 || tx >= N || ty >= M || visited[tx][ty]) {
                    continue;
                }
                pq.add(new int[]{tx, ty, Math.max(cCost, maltGraph[tx][ty])});
            }
        }
        return -1;
    }

    private static int[] getStart() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 'L') {
                    return new int[]{i, j, 0};
                }
            }
        }
        return null;
    }
}
