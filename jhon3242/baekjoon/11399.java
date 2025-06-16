package backjoon.n11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(getResult());
    }

    private static int getResult() {
        Arrays.sort(arr);
        int result = 0;
        int acc = 0;
        for (int i = 0; i < N; i++) {
            acc += arr[i];
            result += acc;
        }
        return result;
    }
}
