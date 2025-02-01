package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_22251 {


    static int N, K, P, X;
    static int result;
    static int[] parse;

    static int[][] change = {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // init
        result = 0;

        dfs(0, 1, 0, 0);

        System.out.println(result - 1);

    }

    static void dfs(int num, int tmp, int pCount, int depth) {
        if (num > N) {
            return;
        }

        if (pCount > P) {
            return;
        }

        if (depth == K) {
            if (num != 0) {
                result++;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            dfs(i * tmp + num, tmp * 10, pCount + change[X / tmp % 10][i], depth + 1);
        }
    }

}
