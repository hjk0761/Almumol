import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*

1 8
3 9
2 2
4 1
6 4
10 10
9 7
7 6

8 2 9 1 4 7 8 10


 */

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph[i][0] = f;
            graph[i][1] = t;
        }

        Arrays.sort(graph, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = graph[i][1];
        }
        System.out.println(N - LIS(arr));
    }

    private static int LIS(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            if (list.isEmpty() || list.get(list.size() - 1) < cur) {
                list.add(cur);
                continue;
            }
            int index = bs(list, cur);
            list.set(index, cur);
        }
        return list.size();
    }

    private static int bs(List<Integer> arr, int target) {
        int start = 0;
        int end = arr.size() - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (arr.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
