package backjoon.n10830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static int N;
    static long B;
    static long[][] graph;
    static int MOD = 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        graph = new long[N][N];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
        }
        long[][] result = pow(graph, B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] %= MOD;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static long[][] pow (long[][] a, long num) {
        if (num == 1) {
            return a;
        }
        long[][] tmp = pow(a, num / 2);
        tmp = multi(tmp, tmp);
        if (num % 2 == 1) {
            tmp = multi(tmp, a);
        }
        return tmp;
    }

    private static long[][] multi(long[][] a, long[][] b) {
        long[][] result = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += ((a[i][k] % MOD) * (b[k][j] % MOD)) % MOD;
                }
            }
        }
        return result;
    }
}
