package week6;

// 11:06 -

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_30508 {
    public static void main(String[] args) throws IOException {
        String[] temp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        temp = br.readLine()
                .split(" ");
        int n = Integer.valueOf(temp[0]);
        int m = Integer.valueOf(temp[1]);
        temp = br.readLine()
                .split(" ");
        int h = Integer.valueOf(temp[0])-1;
        int w = Integer.valueOf(temp[1])-1;

        int[][] ary = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        int k = Integer.valueOf(br.readLine());
        Deque<Hasugu> dq = new ArrayDeque<>();

        // 0은 검사, 1은 빠진곳, 2는 하수구
        int[][] visited = new int[n][m];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken()) - 1;
            int y = Integer.valueOf(st.nextToken()) - 1;
            visited[x][y] = 2;
            dq.add(new Hasugu(x, y));
        }

        while (!dq.isEmpty()) {
            // 무조건 하수구나 물이 빠진 곳임을 보장함
            Hasugu hsg = dq.removeFirst();
            int x = hsg.x;
            int y = hsg.y;
            for (int[] direction : DIRECTIONS) {
                int nextX = x + direction[0];
                int nextY = y + direction[1];
                if (0 <= nextX && nextX < n && 0 <= nextY && nextY < m) {
                    // 검사 시작
                    if (visited[nextX][nextY] == 0) {
                        // 기존이 하수구 또는 자기보다 높이 낮을때
                        if (ary[x][y] <= ary[nextX][nextY]) {
                            visited[nextX][nextY] = 1;
                            dq.add(new Hasugu(nextX, nextY));
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (h + i >= n || w + j >= m) {
                    continue;
                }
//                System.out.println(i+"\t"+j);
                boolean flag = true;
                for (int x = i; x <= i + h; x++) {
                    for (int y = j; y <= j + w; y++) {
//                        System.out.println(x+"\t"+y);
                        if (visited[x][y] == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) break;
                }
//                System.out.println("\n");
                if (flag) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static class Hasugu {
        int x;
        int y;

        public Hasugu(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
}
// N, M

// 칸의 높이

// 하수구

// 높이가 자신보다 낮거나 같은 칸에 하수구나 물이 빠진 칸이 있으면 물이 빠진다

// 하수구가 없는 칸 중 물이 빠지지 않은 칸을 물이 고인 칸
// 물이 고인 칸을 밟지 않고 횡단보도를 건너려 한다.


// 길이와 너비

//2(G) 6(X) 7(X) 8(X) 8(X)
//2(G) 3(O) 3(X) 7(X) 9(X)
//4(G) 5(X) 2(G) 6(X) 5(X)
//3(G) 2(G) 1(G) 3(G) 4(X)
//5(G) 7(G) 9(X) 8(X) 1(O)

// O X X X X
// O X X X X
// O X O X X
// O O O O X
// O O X X X

// 2 -1
// 3 * 3
