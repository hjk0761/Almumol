package backjoon.n1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] graphA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int M = Integer.parseInt(br.readLine());
        int[] graphB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        Set<Integer> store = new HashSet<>();
        for (int i = 0; i < N; i++) {
            store.add(graphA[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (store.contains(graphB[i])) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
