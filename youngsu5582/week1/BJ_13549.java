package week1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_13549 {

    // 걷을시 : 1초 후, -1 or 1 이동
    // 순간이동 : 0초, 2 * X

    // N : 100000
    // 2초, 512MB

    // 있는 위치 : N, 동생 위치 : K
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(final String[] args) throws IOException {

        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int k = Integer.parseInt(st.nextToken());

        final int[] ary = new int[Math.max(n, k) * 2 + 1];
        Arrays.fill(ary, Integer.MAX_VALUE - 1);

        dp(n, k, ary);
//        bfs(n, k, ary);
    }

    // 5 -> 18
    // 5 10 20 .. 19 .. 18
    private static void dp(final int n, final int k, final int[] ary) throws IOException {
        // 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
        // 0 1 2 3 4 0   1  2  3  4  5  6  7  8  9 0

        // n /2 or n-1 or n + 1
        // n * 2 를 자신 값으로 초기화
        // n-1, n+1 도 자신 +1 값으로 초기화

        int number = n;
        for (int i = 0; i <= number; i++) {
            ary[i] = number - i;
        }
        while (number < k && number != 0) {
            final int length = Math.min(number * 2, ary.length);
            for (int i = number; i < length; i++) {
                ary[i] = i - number;
            }
            number *= 2;
        }

        if (n >= k) {
            System.out.println(ary[k]);
            return;
        }

        for (int i = 0; i <= k; i++) {
            ary[i] = min(findHalf(n, ary), ary[i], find(i - 1, ary), find(i + 1, ary));
            ary[i * 2] = ary[i];
            ary[i + 1] = Math.min(find(i, ary), ary[i + 1]);

        }
        System.out.println(ary[k]);
    }

    private static int findHalf(int n, int[] ary) {
        if (n % 2 != 0 || n / 2 == 0) {
            return Integer.MAX_VALUE;
        }
        return ary[n / 2];
    }

    private static int find(int n, int[] ary) {
        if (n < 0 || n >= ary.length) {
            return Integer.MAX_VALUE;
        }
        return ary[n] + 1;
    }

    private static int min(int n1, int n2, int n3, int n4) {
        return Math.min(Math.min(n1, n2), Math.min(n3, n4));
    }

    private static void bfs(final int n, final int k, final int[] ary) throws IOException {
        final Deque<Element> dq = new ArrayDeque<>();
        dq.add(new Element(n, 0));

        while (!dq.isEmpty()) {
            final Element p = dq.poll();
            if (p.x == k) {
                bw.write(p.count);
                bw.flush();
                break;
            }
            if (p.x < 0 || p.x >= ary.length) {
                continue;
            }

            dq.add(new Element(p.x * 2, p.count));
            final int element = ary[p.x];
            if (element > p.count) {
                dq.add(new Element(p.x - 1, p.count + 1));
                dq.add(new Element(p.x + 1, p.count + 1));
                ary[p.x] = p.count;
            }
        }
    }

    private static class Element {
        int x;
        int count;

        public Element(final int x, final int count) {
            this.x = x;
            this.count = count;
        }
    }

}

