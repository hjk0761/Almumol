package backjoon.n1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = 0;
        long sum = 0;
        int result = Integer.MAX_VALUE;
        for (int end = 0; end < N; end++) {
            sum += array[end];
            while (sum >= S) {
                result = Math.min(result, end - start + 1);
                sum -= array[start];
                start++;
            }
        }
        if (result == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
