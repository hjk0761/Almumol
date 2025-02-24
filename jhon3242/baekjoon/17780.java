import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int[][] color;
    static int n;
    static int k;
    static Map<Integer, Integer> pieceMap;
    static Map<String, List<Integer>> boardMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        color = new int[n][n];

        for (int i = 0; i < n; i++) {
            color[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        pieceMap = new HashMap<>();
        boardMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boardMap.put(i + " " + j, new ArrayList<>());
            }
        }

        for (int i = 0; i < k; i++) {
            int[] array = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            array[0]--;
            array[1]--;
            array[2]--;
            boardMap.get(array[0] + " " + array[1]).add(i + 1);
            pieceMap.put(i + 1, array[2]);
        }
        for (int i = 1; i <= 1000; i++) {
            for (int cur = 1; cur <= k; cur++) {
                handlePiece(cur);
                if (isDone()) {
                    System.out.println(i);
                    return;
                }
            }

        }
        System.out.println(-1);
    }

    private static boolean isDone() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (boardMap.get(i + " " + j).size() >= 4) return true;
            }
        }
        return false;
    }

    private static void handlePiece(int num) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int bottomPiece = getBottomPiece(i, j);
                if (bottomPiece == -1) {
                    continue;
                }
                if (bottomPiece == num) {
                    movePiece(i, j, num);
                    return;
                }
            }
        }
    }

    private static void movePiece(int x, int y, int pieceNum) {
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};
        int dir = pieceMap.get(pieceNum);

        int tx = dx[dir] + x;
        int ty = dy[dir] + y;

        if (tx < 0 || ty < 0 || tx >= n || ty >= n) {
            int newDir = getNewDir(dir);
            pieceMap.put(pieceNum, newDir);
            int nx = dx[newDir] + x;
            int ny = dy[newDir] + y;
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && color[nx][ny] != 2) {
                movePiece(x, y, pieceNum);
            }
            return;
        }

        List<Integer> list = boardMap.get(x + " " + y);

        if (color[tx][ty] == 1) {
            Collections.reverse(list);
        }
        if (color[tx][ty] == 2) {
            int newDir = getNewDir(dir);
            pieceMap.put(pieceNum, newDir);
            int nx = dx[newDir] + x;
            int ny = dy[newDir] + y;
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && color[nx][ny] != 2) {
                movePiece(x, y, pieceNum);
            }
            return;
        }
        boardMap.get(tx + " " + ty).addAll(list);
        list.clear();
    }

    private static int getNewDir(int dir) {
        if (dir == 0) return 1;
        if (dir == 1) return 0;
        if (dir == 2) return 3;
        if (dir == 3) return 2;
        return -1;
    }

    private static int getBottomPiece(int x, int y) {
        List<Integer> list = boardMap.get(x + " " + y);
        if (list.isEmpty()) {
            return -1;
        }
        return list.get(0);
    }
}
