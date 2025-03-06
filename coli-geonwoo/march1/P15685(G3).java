import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P15685 {

    static int[][] data = new int[101][101];

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int x;
    static int y;
    static int d;
    static List<Integer> dists = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //x y d g
        //x,y 시작 좌표
        //d : 방향
        //g : 세대
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken());
            drawGeneration(gen, d);
        }

        int result = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (isSquare(i, j)) {
                    result++;
                }
            }
        }

        bw.write(result + "");
        bw.flush();
    }

    private static boolean isSquare(int x, int y) {
        return data[x][y] == 1 && data[x + 1][y] == 1 && data[x][y + 1] == 1 && data[x + 1][y + 1] == 1;
    }

    private static void drawGeneration(int generation, int d) {
        //0세대 처리
        data[x][y] = 1;
        x += dx[d];
        y += dy[d];
        data[x][y] = 1;
        dists = new ArrayList<>();
        dists.add(d);

        for (int gen = 0; gen < generation; gen++) {
            drawOneGeneration();
        }
    }

    private static void drawOneGeneration() {
        //뒤에서부터 꺼내면서 역추적 하되 시계방향으로 회전
        for(int i= dists.size() -1; i >=0 ; i--){
            int dist = dists.get(i);
            dist = nextDist(dist);
            x+=dx[dist];
            y+=dy[dist];
            data[x][y] = 1;
            dists.add(dist);
        }
    }

    private static int nextDist(int d) {
        return (d + 1) % 4;
    }
}
