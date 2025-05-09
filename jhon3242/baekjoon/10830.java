package backjoon.n10830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*

1 2 1 2
3 4

 */

public class Main {

    static int mod = 1_000;
    static Map<Long, long[][]> store;
    static int N;
    static long P;
    static long[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        store = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        P = Long.parseLong(st.nextToken());
        graph = new long[N][N];

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Integer::parseInt)
                    .toArray();
        }

        printG(pow(graph, P));
    }

    private static long[][] pow(long[][] graph, long n) {
        if (store.containsKey(n)) {
            return store.get(n);
        }

        if (n == 1) {
            handleMod(graph);
            store.put(1L, graph);
            return graph;
        }

        long[][] a = pow(graph, n / 2);
        handleMod(a);
        a = mul(a, a);
        handleMod(a);

        if (n % 2 == 1) {
            a = mul(a, graph);
            handleMod(a);
        }

        store.put(n, a);
        return a;
    }

    private static long[][] mul(long[][] a, long[][] b) {
        long[][] result = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                long tmp = 0;
                for (int k = 0; k < N; k++) {
                    tmp += (a[i][k] % mod) * (b[k][j] % mod);
                    tmp %= mod;
                }
                result[i][j] = tmp;
            }
        }
        return result;
    }

    private static void handleMod(long[][] graph) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] %= mod;
            }
        }
    }

    private static void printG(long[][] graph) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

