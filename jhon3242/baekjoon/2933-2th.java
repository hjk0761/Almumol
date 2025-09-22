package backjoon.n2933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;
/*
- 경우의 수
100, 100
그래프 크기: 10,000
던진 회수: 100
매번 던질 때마다 그래프를 옮겨도 경우의 수는 10,000 * 100 = 1,000,000 이다.

- 미네랄 추락 규칙
하나의 미네랄 덩어리는 모양이 바뀌지 않고 추락한다.
따라서 미네랄 덩어리 마다 숫자를 부여하고 추락하는 높이를 구한다음에 덩어리 자체를 옮겨야 할듯하다.

 */

public class Main2 {
    static int N;
    static int M;
    static char[][] graph;
    static int divNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        int t = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        boolean isLeft = true;
        for (int i = 0; i < t; i++) {
            shoot(arr[i], isLeft);
            isLeft = !isLeft;

            int[][] divGraph = getDivGraph();
            for (int j = 1; j <= divNum; j++) {
                int moveCount = getMoveCount(divGraph, j);
                divGraph = move(divGraph, j, moveCount);
            }

            char[][] tmp = new char[N][M];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (divGraph[j][k] == 0) {
                        tmp[j][k] = '.';
                    } else {
                        tmp[j][k] = 'x';
                    }
                }
            }
            graph = tmp;
//            System.out.println(moveCount);
//            break;
        }
//        for (int c = 0; c < N; c++) {
//            System.out.println(Arrays.toString(divGraph[c]));
//        }

//        shoot(3, true);
//        int[][] divGraph = getDivGraph();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static int[][] getDivGraph() {
        int[][] divGraph = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        divNum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && graph[i][j] == 'x') {
                    bfs(i, j, visited, divGraph, ++divNum);
                }
            }
        }
        return divGraph;
    }

    private static void bfs(int x, int y, boolean[][] visited, int[][] divGraph, int divNum) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{x, y});
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        while (!deque.isEmpty()) {
            int[] polled = deque.pollFirst();
            int cx = polled[0];
            int cy = polled[1];
            if (visited[cx][cy]) {
                continue;
            }
            visited[cx][cy] = true;
            divGraph[cx][cy] = divNum;
            for (int i = 0; i < 4; i++) {
                int tx = dx[i] + cx;
                int ty = dy[i] + cy;
                if (tx < 0 || ty < 0 || tx >= N || ty >= M || visited[tx][ty] || graph[tx][ty] != 'x') {
                    continue;
                }
                deque.addLast(new int[]{tx, ty});
            }
        }
    }

    private static void shoot(int height, boolean isLeft) {
        if (isLeft) {
            for (int i = 0; i < M; i++) {
                if (graph[N - height][i] == 'x') {
                    graph[N - height][i] = '.';
                    return;
                }
            }
        } else {
            for (int i = M - 1; i >= 0; i--) {
                if (graph[N - height][i] == 'x') {
                    graph[N - height][i] = '.';
                    return;
                }
            }
        }
    }

    private static int getMoveCount(int[][] graph, int divNum) {
        int result = N - 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == divNum) {
                    int moveCount = calculateMoveCount(graph, i, j, divNum);
                    if (moveCount == -1) continue;
                    result = Math.min(result, moveCount);
                }
            }
        }
        return result;
    }

    private static int calculateMoveCount(int[][]graph, int x, int y, int divNum) {
        int result = 0;
        for (int i = x + 1; i < N; i++) {
            if (graph[i][y] == divNum) {
                return -1;
            }
            if (graph[i][y] == 0) {
                result++;
            } else {
//                System.out.print(" x = " + x);
//                System.out.print(" y = " + y);
//                System.out.print(" i = " + i);
//                System.out.print(" graph[i][y] = " + graph[i][y]);
//                System.out.print(" divNum = " + divNum);
//                System.out.println();
                break;
            }
        }
        return result;
    }

    private static int[][] move(int[][] graph, int divNum, int count) {
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == divNum) {
                    result[i+count][j] = graph[i][j];
                } else if (result[i][j] != 0) {
                    continue;
                } else {
                    result[i][j] = graph[i][j];
                }
            }
        }
        return result;
    }
}
