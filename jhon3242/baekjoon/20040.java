package backjoon.n20040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        rank = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            rank[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (find(a) == find(b)) {
                System.out.println(i + 1);
                return;
            }
            union(a, b);
        }
        System.out.println(0);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            rank[b] = a;
        } else {
            rank[a] = b;
        }
    }

    private static int find(int x) {
        if (x != rank[x]) {
            rank[x] = find(rank[x]);
        }
        return rank[x];
    }
}
