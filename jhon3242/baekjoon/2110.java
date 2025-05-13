package backjoon.n2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*

5 3
1
2
8
4
9

1 2 3 4 5 6 7 8 9
^ ^   ^       ^ ^

1 2 4 8 9

 */
public class Main {
    static int N;
    static int M;
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N];
        for (int i = 0; i < N; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(graph);
        System.out.println(getResult());
    }

    private static int getResult() {
        int start = 1;
        int end = graph[N - 1];
        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (getCount(mid) >= M) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private static int getCount(int target) {
        int result = 1;
        int pre = graph[0];
        for (int i = 1; i < N; i++) {
            if (graph[i] - pre >= target) {
                result++;
                pre = graph[i];
            }
        }
        return result;
    }
}
