package backjoon.n1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4 {
    /*
    1 2 3
    2 4 6
    3 6 9

    1 2 2 3 3 4 6 6 9

    b[7] = 6

    5보다 작거나 같은 수는? 6
    6보다 작거나 같은 수가 최소 7개이다.
    7보다 작거나 같은 수는? 9개

    k[5] = 6
    k[7] = 7

    target 보다 크거나 같은 수중 최소
    target <=


     */

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
            int mid = (start + end) / 2;
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
        for (int i = 1; i <= N; i++) {
            count += Math.min(target / i, N);
        }
        return count;
    }
}
