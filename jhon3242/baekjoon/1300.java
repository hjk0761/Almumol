package backjoon.n1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*

0 0 0 0
0 1 2 3  4  5  6  7
0 2 4 6  8  10 12 14
0 3 6 9  12 15 18 21
0 4 8 12 16
0 5 10
0 6 12

 */

public class Main {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        System.out.println(getResult());
    }

    private static int getResult() {
        int start = 1;
        int end = K;
        while (start < end) {
            int mid = (start + end ) / 2;
            if (getCount(mid) < K) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static int getCount(int target) {
        int count = 0;
        for (int j = 1; j <= N; j++) {
            count += Math.min(target / j, N);
        }
        return count;
    }
}
