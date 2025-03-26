import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14890 {

    static int n;
    static int len;
    static int[][] data;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        data = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            if (isAnswer(i, data[i])) {
                cnt++;
            }
            if (isAnswer(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean isAnswer(int x, int[] line) {
        boolean[][] visited = new boolean[n][n];
        int before = line[0];
        int idx = 0;

        while (idx < n) {
            if (Math.abs(before - line[idx]) > 1) {
                return false;
            }

            if (before - line[idx] == 1) {
                for (int i = idx; i < idx + len; i++) {
                    if (i < n && line[i] == line[idx] && !visited[x][i]) {
                        visited[x][i] = true;
                    } else {
                        return false;
                    }
                }

                before = line[idx];
                idx += len;
                continue;
            }
            before = line[idx];
            idx++;
        }

        idx = n - 1;
        before = line[n - 1];
        while (idx >= 0) {
            if (before - line[idx] == 1) {
                //높이가 1차이가 나는 곳이 len 만큼 이어져 있으면 설치
                for (int i = idx; i > idx - len; i--) {
                    if (i >= 0 && line[i] == line[idx] && !visited[x][i]) {
                        visited[x][i] = true;
                    } else {
                        return false;
                    }
                }
                before = line[idx];
                idx -= len;
                continue;
            }
            before = line[idx];
            idx--;
        }

        return true;
    }

    static boolean isAnswer(int y) {
        boolean[][] visited = new boolean[n][n];
        int before = data[0][y];
        int idx = 0;

        while (idx < n) {
            if (Math.abs(before - data[idx][y]) > 1) {
                return false;
            }

            if (before - data[idx][y] == 1) {
                //높이가 1차이가 나는 곳이 len 만큼 이어져 있으면 설치
                for (int i = idx; i < idx + len; i++) {
                    if (i < n && data[i][y] == data[idx][y] && !visited[i][y]) {
                        visited[i][y] = true;
                    } else {
                        return false;
                    }
                }

                before = data[idx][y];
                idx += len;
                continue;
            }
            before = data[idx][y];
            idx++;
        }

        idx = n - 1;
        before = data[n - 1][y];
        while (idx >= 0) {
            if (before - data[idx][y] == 1) {
                for (int i = idx; i > idx - len; i--) {
                    if (i >= 0 && data[i][y] == data[idx][y] && !visited[i][y]) {
                        visited[i][y] = true;;
                    } else {
                        return false;
                    }
                }
                before = data[idx][y];
                idx -= len;
                continue;
            }
            before = data[idx][y];
            idx--;
        }

        return true;
    }
}
