package backjoon.n9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
BFS로 지도에 위치에 도달할 수 있는 최소시간을 업데이트하고,
탈옥수 위치를 구하면 되지 않을까? -> 이러면 한 명 죄수의 탈출 시간을 구할 수 있지만, 두 죄수 탈출은 계산하기 까다롭다. 왜냐하면 한명 구하고 다른 한명
구하러 갈 때의 추가되는 시간을 알 수 없기 떄문이다.
100,100 = 10,000

DFS로 한다면 한명 죄수 찾고 다른 한명 찾는데 걸리는 최대 비용을 알 수 있다.
하지만 이러면 시간초과가 날 것 같다. 4방향이니까 4^10000

답)
결국 답을 보았는데 0-1 BFS라는 개념을 활용해야한다.
 */

public class Main {
    static int N;
    static int M;
    static char[][] graph;
    static int[][] dA;
    static int[][] dB;
    static int[][] dStart;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int INF = 100*100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()) + 2;
            M = Integer.parseInt(st.nextToken()) + 2;
            graph = new char[N][M];
            dA = new int[N][M];
            dB = new int[N][M];
            dStart = new int[N][M];
            for (int i = 0; i < N; i++) {
                Arrays.fill(graph[i], '.');
                Arrays.fill(dStart[i], INF);
                Arrays.fill(dA[i], INF);
                Arrays.fill(dB[i], INF);
            }
            int[][] candi = new int[2][2];
            int idx = 0;
            for (int i = 1; i <= N-2; i++) {
                char[] tmp = br.readLine().toCharArray();
                for (int j = 1; j <= M-2; j++) {
                    graph[i][j] = tmp[j-1];
                    if (graph[i][j] == '$') {
                        candi[idx][0] = i;
                        candi[idx][1] = j;
                        idx++;
                    }
                }
            }

            bfs(0, 0, dStart);
            bfs(candi[0][0], candi[0][1], dA);
            bfs(candi[1][0], candi[1][1], dB);

            int[][] sumDist = new int[N][M];

            int result = INF;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sumDist[i][j] = dA[i][j] + dB[i][j] + dStart[i][j];
                    if (graph[i][j] == '#') sumDist[i][j] -=2;
                    result = Math.min(result, sumDist[i][j]);
                }
            }
            System.out.println(result);
        }
    }

    private static void bfs(int x, int y, int[][] dist) {
        boolean[][] visited = new boolean[N][M];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x, y, 0});

        while (!deque.isEmpty()) {
            int[] polled = deque.poll();
            int cx = polled[0];
            int cy = polled[1];
            int cCost = polled[2];
            if (visited[cx][cy] || graph[cx][cy] == '*') {
                continue;
            }
            visited[cx][cy] = true;
            dist[cx][cy] = cCost;
            for (int i = 0; i < 4; i++) {
                int tx = dx[i] + cx;
                int ty = dy[i] + cy;
                if (tx < 0 || ty < 0 || tx >= N || ty >= M || visited[tx][ty] || graph[tx][ty] == '*') {
                    continue;
                }
                if (graph[tx][ty] == '#') {
                    deque.addLast(new int[]{tx, ty, cCost + 1});
                } else {
                    deque.addFirst(new int[]{tx, ty, cCost});
                }
            }
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dist[i]));
//        }
//        System.out.println();
    }
}
