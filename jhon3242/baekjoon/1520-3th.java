package backjoon.n1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
500 * 500 = 250,000
순수 DFS는 4^25만 으로 초과할 것 같음
따라서 DP가 필요함.

한번 도달하면 해당 경로 위치에 true라고 표시한다.
그리고 다른 경로에 의해 도달하게 되면 도달한다고 간주하고 true표시를 마찬가지로 해준다.
이때 방문했는지에 대한 정보도 포함되어야한다.

만약 방문한 곳이 true라면, 단순히 +1이 아니다. 해당 경로를 통해 도달할 수 있는 경로가 2개라면 새롭게 +2를 해줘야한다.
따라서 단순히 불린이 아니라 int로 방문 가능여부를 판단해야한다.

방문했던 곳인지를 먼저 판단해야할까? 아니면 유효한곳인지를 먼저 판단해야할까?

1. 현위치를 방문 표시
2. 유효한 곳인지 확인-> 맞다면 +1한다.
2. 다음 경로로 방문


다시 보니까 방문했던 곳을 굳이 표시할 필요가 없을 것 같기도?
그냥 4방향 값을 다 더했는데 0이면 -1로 표시해서 못가는 곳이라 판단하면?
현 위치에 도달하면 어차피 안으로 더 들어가봐야 못가는 곳이라 판단할 수 있을 것 같다.
2 2 1
0 1 1
0 1 1

 */
public class Main3 {
    //    static boolean[][] visited;
    static int[][] valid;
    static int[][] graph;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int N;
    static int M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        valid = new int[N][M];
//        visited = new boolean[N][M];
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        dfs(0, 0);

        if (valid[0][0] < 0) {
            System.out.println(0);
        } else {
            System.out.println(valid[0][0]);
        }
    }

    private static int dfs(int x, int y) {
        if (valid[x][y] != 0) {
            return valid[x][y];
        }
        if (x == N - 1 && y == M - 1) {
            valid[x][y] = 1;
            return 1;
        }

        int cur = 0;
        for (int i = 0; i < 4; i++) {
            int tx = dx[i] + x;
            int ty = dy[i] + y;
            if (tx < 0 || ty < 0 || tx >= N || ty >= M || graph[tx][ty] >= graph[x][y]) {
                continue;
            }
            int tValue = dfs(tx, ty);
            if (tValue > 0) {
                cur += tValue;
            }
        }
        if (cur == 0) {
            cur = -1;
        }
        valid[x][y] = cur;
        return cur;
    }
}
