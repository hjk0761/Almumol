package backjoon.n1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        for (int i = 0; i < N; i++) {
            graph[i][i] = 1;
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(graph[i]));
//        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] != 1) {
                    continue;
                }
                for (int k = 0; k < N; k++) {
                    if (graph[j][k] == 1) {
                        graph[i][k] = 1;
                        graph[k][i] = 1;
                    }
                }
            }
        }

        int[] course = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int start = course[0] - 1;
        for (int i = 1; i < course.length; i++) {
            int next = course[i] - 1;
            if (graph[start][next] == 0) {
                System.out.println("NO");
                return;
            }
            start = next;
        }
        System.out.println("YES");
    }
}
