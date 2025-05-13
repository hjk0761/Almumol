package backjoon.n2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(getResult());
    }

    private static int getResult() {
        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            end = Math.max(end, array[i]);
        }

        while (start < end) {
            int mid = (start + end + 1) / 2;
            long count = getCount(mid);
            if (count >= M) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private static long getCount(int height) {
        long result = 0;
        for (int i = 0; i < N; i++) {
            result += Math.max(array[i] - height, 0);
        }
        return result;
    }
}
