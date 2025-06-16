package backjoon.n13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] road;
    static int[] gas;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        road = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        gas = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int pre = Integer.MAX_VALUE;
        long result = 0;
        for (int i = 0; i < N - 1; i++) {
            if (gas[i] < pre) {
                result += (long) road[i]  * gas[i];
                pre = gas[i];
                continue;
            }
            result += (long) road[i] * pre;
        }
        System.out.println(result);
    }
}
