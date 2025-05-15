package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.*;

class Pos {
    int x, w;

    public Pos(int x, int w) {
        this.x = x;
        this.w = w;
    }
}

public class Boj13549 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pos> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.w));
        queue.add(new Pos(n, 0));
        dist[n] = 0;

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            if (cur.x == k) {
                System.out.println(cur.w);
                return;
            }

            int[] nextMoves = {cur.x - 1, cur.x + 1, cur.x * 2};
            int[] costs = {cur.w + 1, cur.w + 1, cur.w}; // 순간이동은 가중치 0

            for (int i = 0; i < 3; i++) {
                int nextX = nextMoves[i], nextW = costs[i];

                if (nextX >= 0 && nextX <= 100000 && dist[nextX] > nextW) {
                    dist[nextX] = nextW;
                    queue.add(new Pos(nextX, nextW));
                }
            }
        }
    }
}
