package backjoon.n11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main3 {
    static int N;
    static int[] graph;
    static int[] dp;
    static int[] dpR;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        dp = new int[N];
        dpR = new int[N];

        LIS();
        LISR();
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i] + dpR[i] - 1);
        }
        System.out.println(max);
    }

    private static void LIS() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int cur = graph[i];
            if (list.isEmpty() || list.get(list.size() - 1) < cur) {
                list.add(cur);
            } else {
                list.set(bSearch(cur, list), cur);
            }
            dp[i] = list.size();
        }
    }

    private static void LISR() {
        List<Integer> listR = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int cur = graph[N - i - 1];
            if (listR.isEmpty() || listR.get(listR.size() - 1) < cur) {
                listR.add(cur);
            } else {
                listR.set(bSearch(cur, listR), cur);
            }
            dpR[N - i - 1] = listR.size();
        }
    }

    private static int bSearch(int target, List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
