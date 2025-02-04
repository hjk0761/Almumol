import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void DFS(int y, int x, int idx) {
        if (y == arr[m - 1].y && x == arr[m - 1].x) {
            if (idx == m - 1) {
                cnt++;
            }
            return;
        }
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if (visited[ny][nx] == 1) continue;
            if (mp[ny][nx] == 1) continue;
            visited[ny][nx] = 1;
            if (idx < m - 1 && ny == arr[idx + 1].y && nx == arr[idx + 1].x) {
                DFS(ny, nx, idx + 1);
            } else {
                DFS(ny, nx, idx);
            }
            visited[ny][nx] = 0;
        }
    }

    static int n;
    static int m;
    static int[][] mp;
    static Node[] arr;
    static int[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        mp = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                mp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr = new Node[m];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Node(a - 1, b - 1);
        }
        visited = new int[n][n];

        visited[arr[0].y][arr[0].x] = 1;
        DFS(arr[0].y, arr[0].x, 0);

        System.out.println(cnt);
    }
}

