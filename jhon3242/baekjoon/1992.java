import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] graph;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt)
                    .toArray();
        }
//        if (N == 1) {
//            System.out.println(graph[0][0]);
//        } else {
            op(0, 0, N);
            System.out.println(sb);
//        }
    }

    private static void op(int x, int y, int n) {
        int div = n / 2;
        int lu = getCompress(x, y, div);
        int ru = getCompress(x, y + div, div);
        int ld = getCompress(x + div, y, div);
        int rd = getCompress(x + div, y + div, div);
        if (lu != -1 && lu == ru && ru == ld && ld == rd) {
            sb.append(lu);
            return;
        }
        sb.append("(");
        if (lu == -1 && div != 1) {
            op(x, y, div);
        } else {
            sb.append(lu);
        }

        if (ru == -1 && div != 1) {
            op(x, y + div, div);
        } else {
            sb.append(ru);
        }

        if (ld == -1 && div != 1) {
            op(x + div, y, div);
        } else {
            sb.append(ld);
        }

        if (rd == -1 && div != 1) {
            op(x + div, y + div, div);
        } else {
            sb.append(rd);
        }

        sb.append(")");
    }

    private static int getCompress(int x, int y, int div) {
        int target = graph[x][y];
        for (int i = x; i < x + div; i++) {
            for (int j = y; j < y + div; j++) {
                if (target != graph[i][j]) {
                    return -1;
                }
            }
        }
        return target;
    }
}
