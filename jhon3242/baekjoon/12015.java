package backjoon.n12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
    static int N;
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(getResult());
    }

    private static int getResult() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (list.isEmpty() || list.get(list.size() - 1) < graph[i]) {
                list.add(graph[i]);
                continue;
            }
            int idx = getIndex(list, graph[i]);
            list.set(idx, graph[i]);
        }
        return list.size();
    }

    private static int getIndex(List<Integer> list, int target) {
        int start = 0 ;
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
