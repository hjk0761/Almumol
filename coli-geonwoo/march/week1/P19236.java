import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P19236 {

    static int[][] data = new int[4][4];
    static int[][] dist = new int[4][4];
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int result = 0;
    static Map<Integer, Node> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        //상어 이동
        //물고기 이동

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                int fishNum = Integer.parseInt(st.nextToken());
                int fishDist = Integer.parseInt(st.nextToken()) - 1;
                data[i][j] = fishNum;
                dist[i][j] = fishDist;
                map.put(fishNum, new Node(i, j));
            }
        }

        //0,0 먹기
        int firstFish = data[0][0];
        int sharkDist = dist[0][0];
        map.remove(firstFish);
        data[0][0] = -1;

        dfs(0, 0, sharkDist, firstFish);

        System.out.println(result);

    }

    private static void dfs(int sx, int sy, int sharDist, int cnt) {
        int[][] copyData = copy(data);
        int[][] copyDist = copy(dist);
        Map<Integer, Node> copyMap = copy(map);

        moveFishes(sx, sy);
        boolean canMove = false;

        for (int i = 1; i < 4; i++) {
            int nx = sx + dx[sharDist] * i;
            int ny = sy + dy[sharDist] * i;

            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || data[nx][ny] == -1) {
                continue;
            }

            //물고기 먹기
            canMove = true;
            int fishNum = data[nx][ny];
            Node fishNode = map.get(fishNum);
            data[nx][ny] = -1;
            map.remove(fishNum);

            dfs(nx, ny, dist[nx][ny], cnt + fishNum);

            data[nx][ny] = fishNum;
            map.put(fishNum, fishNode);
        }

        if (!canMove) {
            result = Math.max(result, cnt);
        }

        map = copyMap;
        dist = copyDist;
        data = copyData;

    }

    private static void moveFishes(int sx, int sy) {
        for (int i = 1; i <= 16; i++) {
            //잡아먹혔다면 패스
            if (map.get(i) == null) {
                continue;
            }

            //있다면
            Node node = map.get(i);
            int fishX = node.x;
            int fishY = node.y;
            int fishDist = dist[fishX][fishY];

            for (int j = 0; j < 8; j++) {
                int nx = fishX + dx[(fishDist + j) % 8];
                int ny = fishY + dy[(fishDist + j) % 8];

                if ((nx == sx && ny == sy) || (nx < 0 || ny < 0 || nx >= 4 || ny >= 4)) {
                    continue;
                }

                switchPosition(data[fishX][fishY], fishX, fishY, (fishDist + j) % 8, data[nx][ny], nx, ny);
                break;
            }
        }
    }

    private static void switchPosition(int originNum, int originX, int originY, int originDist, int targetNum,
                                       int targetX, int targetY) {
        boolean isBlank = (data[targetX][targetY] == -1);
        data[targetX][targetY] = originNum;
        data[originX][originY] = targetNum;
        dist[originX][originY] = dist[targetX][targetY];
        dist[targetX][targetY] = originDist;
        map.put(originNum, new Node(targetX, targetY));

        if (!isBlank) {
            map.put(targetNum, new Node(originX, originY));
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] copy(int[][] matrix) {
        int[][] copy = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        return copy;
    }

    static Map<Integer, Node> copy(Map<Integer, Node> map) {
        Map<Integer, Node> copy = new HashMap<>();
        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            Node node = entry.getValue();
            copy.put(entry.getKey(), new Node(node.x, node.y));
        }
        return copy;
    }
}
