import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int R, C;
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static char[][] map;
    private static int answer = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] RC = bf.readLine().split(" ");
        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);
        map = new char[R][C];
        for(int i = 0; i < R; i++) {
            map[i] = bf.readLine().toCharArray();
        }
        boolean[] visited = new boolean[26];
        visited[map[0][0] - 'A'] = true;
        answer = dfs(0, 0, visited);
        System.out.println(answer);

    }

    private static int dfs(int x, int y, boolean[] visited) {
        int count = 0;
        for(int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(canMove(nx, ny) && !visited[map[nx][ny] - 'A']) {
                visited[map[nx][ny] - 'A'] = true;
                count = Math.max(count, dfs(nx, ny, visited));
                visited[map[nx][ny] - 'A'] = false;
            }
        }
        return count + 1;
    }

    private static boolean canMove(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }
}
