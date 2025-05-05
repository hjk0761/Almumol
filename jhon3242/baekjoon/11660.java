import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] graph;
    static int[][] sumGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        sumGraph = new int[N][N];

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
        }

        // init sum graph
        initSumGraph();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken()) - 1;
            int fy = Integer.parseInt(st.nextToken()) - 1;
            int tx = Integer.parseInt(st.nextToken()) - 1;
            int ty = Integer.parseInt(st.nextToken()) - 1;

            int result = sumGraph[tx][ty];

            if (fx != 0) {
                result -= sumGraph[fx - 1][ty];
            }
            if (fy != 0) {
                result -= sumGraph[tx][fy - 1];
            }
            if (fx != 0 && fy != 0) {
                result += sumGraph[fx - 1][fy - 1];
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void initSumGraph() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += graph[0][i];
            sumGraph[0][i] = sum;
        }

        sum = 0;
        for (int i = 0; i < N; i++) {
            sum += graph[i][0];
            sumGraph[i][0] = sum;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                sumGraph[i][j] = sumGraph[i - 1][j] + sumGraph[i][j - 1] - sumGraph[i - 1][j - 1] + graph[i][j];
            }
        }
    }

    private static void printG(int[][] t) {
        System.out.println(t.length);
        for (int i = 0; i < t.length; i++) {
            System.out.println(Arrays.toString(t[i]));
        }
        System.out.println();
    }
}
