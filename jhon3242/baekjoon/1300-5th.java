package backjoon.n1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
3
1 2 3
2 4 6
3 6 9

1 2 2 3 3 4 6 6 9
B[7]
4: 6
5: 6
6: 8

k 보다 크거나 같은 첫번째

4
1 2 3 4
2 4 6 8
3 6 9 12
4 8 12 16

1 2 2 3 3 4 4 4 6 6 8 8 9 12 12 16


 */
public class Main5 {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

//        for (int i = 1; i <= N * N; i++) {
//            K = i;
//            int result = bSearch();
////        int result = getCount(4);
//            System.out.println(result);
//        }

        int result = bSearch();
//        int result = getCount(4);
        System.out.println(result);
    }

    private static int bSearch() {
        int start = 0;
        int end = K;
        while (start < end) {
            int mid = (start + end) / 2;
            int count = getCount(mid);
//            System.out.print(" mid = " + mid);
//            System.out.print(" count = " + count);
//            System.out.println();
            if (count < K) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static int getCount(int x) {
        int result = 0;
        for (int i = 1; i <= N; i++) {
            result += Math.min(x / i, N);
        }
        return result;
    }
}
