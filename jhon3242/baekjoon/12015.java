import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
10, 20, 30, 15, 20, 30, 50, 40, 45 ,60
 */

public class Main {
    static int[] graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int cur = graph[i];
            if (list.isEmpty() || list.get(list.size() - 1) < cur) {
                list.add(cur);
                continue;
            }
            int replaceIndex = binarySearch(list, cur);
            list.set(replaceIndex, cur);
        }

        System.out.println(list.size());
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
