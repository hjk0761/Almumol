package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_24508 {

    static int N, K, T;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        // init
        arr = new int[N];

        long totalNadori = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            totalNadori += arr[i];
        }

        if (totalNadori % K != 0) {
            System.out.println("NO");
            return;
        }

        Arrays.sort(arr);

        long count = 0;
        for (int i = 0; i < totalNadori / K; i++) {
            count += K - arr[N - 1 - i];
        }

        if (count > T) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
