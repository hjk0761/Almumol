package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1911 {

    static int N, L;
    static int[][] water;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        // init
        water = new int[N][2];
        result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            water[i][0] = Integer.parseInt(st.nextToken());
            water[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(water, (o1, o2) -> {return o1[0] - o2[0];});

        int range = 0;

        for (int[] arr : water) {
            if (arr[0] > range) {
                range = arr[0];
            }

            if (arr[1] > range) {
                while (arr[1] > range) {
                    range += L;
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
