import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_14940 {

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 0) {
                    map[i][j] = -1;
                } else if (input == 2) {
                    startX = i;
                    startY = j;
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < dx.length; d++) {
                int newX = now[0] + dx[d];
                int newY = now[1] + dy[d];

                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }
                ;
                if (map[newX][newY] == -1) {
                    continue;
                }
                if (!visited[newX][newY]) {
                    visited[newX][newY] = true;
                    map[newX][newY] = map[now[0]][now[1]] + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = -1;
                } else if (map[i][j] == -1) {
                    map[i][j] = 0;
                }
            }
        }
        map[startX][startY] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.write(System.lineSeparator());
        }

        bw.flush();
    }
}
