package backjoon.n11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main3 {
    static int N;
    static int[] graph;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        dp = new int[N];
        dp[0] = 1;

        System.out.println(LIS());
    }

    private static int LIS() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int cur = graph[i];
            if (list.isEmpty() || list.get(list.size() - 1) < cur) {
                list.add(cur);
                continue;
            }
            int idx = bSearch(cur, list);
            list.set(idx, cur);
        }
        return list.size();
    }

    private static int bSearch(int target, List<Integer> list) {
        int start = 0;
        int end = list.size() -1;
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
