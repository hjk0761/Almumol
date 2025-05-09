package backjoon.n11444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static long N;
    static int mod = 1_000_000_007;
    static long[][] a = new long[][]{{1, 1}, {1, 0}};
    static Map<Long, long[][]> store = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        long result = fibo(N);
        System.out.println(result);
    }

    private static long fibo(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        long[][] result = mul(pow(a, n - 2), new long[][]{{1}, {0}});
        return (result[0][0] % mod + result[1][0] % mod) % mod;
    }

    private static long[][] pow(long[][] a, long n) {
        if (n == 1) {
            return a;
        }
        if (store.containsKey(n)) {
            return store.get(n);
        }

        long[][] div = pow(a, n / 2);
        div = mul(div, div);
        if (n % 2 == 1) {
            div = mul(div, a);
        }
        store.put(n, div);
        return div;
    }

    private static long[][] mul(long[][] a, long[][] b) {
        long[][] result = new long[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                long tmp = 0;
                for (int k = 0; k < b.length; k++) {
                    tmp += ((a[i][k] % mod) * (b[k][j] % mod)) % mod;
                }
                result[i][j] = tmp;
            }
        }
        return result;
    }

    private static void printG(long[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
        System.out.println();
    }
}
