import java.util.*;
import java.io.*;

public class Main {

    private static int M, N;
    private static int[][] map;
    private static int[][] memo;
    private static final int[] dx = {0, 1, -1, 0};
    private static final int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < M; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(dfs(0, 0));
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        M = Integer.parseInt(firstLine[0]);
        N = Integer.parseInt(firstLine[1]);
        map = new int[M + 1][N + 1];
        memo = new int[M][N];
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    private static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (memo[x][y] != -1) {
            return memo[x][y];
        }
        memo[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (canMove(nx, ny) && isDownHill(x, y, nx, ny)) {
                memo[x][y] += dfs(nx, ny);
            }
        }
        return memo[x][y];
    }

    private static boolean canMove(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }

    private static boolean isDownHill(int x, int y, int nx, int ny) {
        return map[nx][ny] < map[x][y];
    }
}
