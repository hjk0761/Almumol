import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*

........
........
.....x..
...xxx..
...xx...
..x.xx..
..x...x.
.xxx..x.
5
6 6 4 3 1


......
..x..
...xx.
..x...
.xxxx.


* */

public class Main {
    static int N;
    static int M;
    static char[][] graph;
    static int checkCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        graph = new char[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        int count = Integer.parseInt(br.readLine());
        boolean isLeft = true;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            int height = N - Integer.parseInt(st.nextToken()) ;
            if (isLeft) {
                for (int j = 0; j < M; j++) {
                    if (graph[height][j] == 'x') {
                        graph[height][j] = '.';
                        isLeft = false;
                        break;
                    }
                }
                isLeft = false;
            } else {
                for (int j = M - 1; j >= 0; j--) {
                    if (graph[height][j] == 'x') {
                        graph[height][j] = '.';
                        isLeft = true;
                        break;
                    }
                }
                isLeft = true;
            }
            checkBreak();
        }
        printG(graph);
    }

//    private static void printG(int[][] graph) {
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(graph[i]));
//        }
//        System.out.println();
//    }
    private static void printG(char[][] graph) {
        for (int i = 0; i < N; i++) {
            System.out.println(new String(graph[i]));
        }
        System.out.println();
    }

    private static void checkBreak() {
        int[][] countGraph = new int[N][M];
        checkCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 'x' && countGraph[i][j] == 0) {
                    bfs(countGraph, i, j, ++checkCount);
                }
            }
        }

//        printG(countGraph);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (countGraph[i][j] != 0 && !map.containsKey(countGraph[i][j])) {
                    int downCount = getDownCount(countGraph, countGraph[i][j]);
                    map.put(countGraph[i][j], downCount);
                }
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == 0) {
                continue;
            }
            moveDown(countGraph, key, map.get(key));
        }
        updateGraph(countGraph);
    }

    private static void updateGraph(int[][] countGraph) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (countGraph[i][j] != 0) {
                    graph[i][j] = 'x';
                } else {
                    graph[i][j] = '.';
                }
            }
        }
    }

    private static void moveDown(int[][] countGraph, int target, int count) {
        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (countGraph[j][i] == target) {
                    countGraph[j + count][i] = target;
                    countGraph[j][i] = 0;
                }
            }
        }
    }

    private static void bfs(int[][] countGraph, int x, int y, int count) {
        Deque<int[]> deque = new ArrayDeque<>();

        deque.add(new int[]{x, y});
        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            int px = poll[0];
            int py = poll[1];

            if (countGraph[px][py] != 0) {
                continue;
            }

            countGraph[px][py] = count;

            for (int k = 0; k < 4; k++) {
                int[] dx = new int[]{1, 0, -1, 0};
                int[] dy = new int[]{0, -1, 0, 1};

                int tx = dx[k] + px;
                int ty = dy[k] + py;

                if (tx < 0 || ty < 0 || tx >= N || ty >= M || countGraph[tx][ty] != 0 || graph[tx][ty] == '.') {
                    continue;
                }
                deque.add(new int[]{tx, ty});
            }
        }
    }

    private static int getDownCount(int[][] graph, int checkCount) {
        int count = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (graph[j][i] == checkCount) {
                    count = Math.min(count, downCount(graph, j, i));
                    break;
                }
            }
        }
        return count;
    }

    private static int downCount(int[][] graph, int x, int y) {
        int count = 0;
        for (int i = x + 1; i < N; i++) {
            if (graph[i][y] == 0) {
                count++;
                continue;
            }
            break;
        }
//        System.out.println("count " + count);
        return count;
    }
}
