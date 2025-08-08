package backjoon.n11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(LIS());
    }

    private static int LIS() {
        List<Integer> tmp = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int cur = arr[i];
            if (tmp.isEmpty() || tmp.get(tmp.size() - 1) < cur) {
                tmp.add(cur);
                continue;
            }

            int idx = binarySearch(tmp, cur);
            tmp.set(idx, cur);
        }

        System.out.println(tmp);

        return tmp.size();
    }

    private static int binarySearch(List<Integer> list, int target) {
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
