package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2589 {

    static char[][] map;
    static boolean[][] visited;
    static int result;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // init
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        result = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[N][M];
                    bfs(i, j);
                }
            }
        }

        System.out.println(result);
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, current.l + 1));
                    result = Math.max(result, current.l + 1);
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }

        return true;
    }

    static class Node {

        int x, y, l;

        public Node(int x, int y, int l) {
            this.x = x;
            this.y = y;
            this.l = l;
        }
    }
}
