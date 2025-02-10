package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1806 {

    static int N, S;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        // init
        arr = new int[N];
        result = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // search
        int left = 0;
        int right = 0;
        int tmp = 0;

        while (right < N) {
            if (tmp >= S) {
                result = Math.min(result, right - left);
                tmp -= arr[left];
                left++;
            } else {
                tmp += arr[right];
                right++;
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
