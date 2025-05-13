package backjoon.n6549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                break;
            }
            graph = new int[N];

            for (int i = 0; i < N; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getArea(0, N - 1)).append("\n");
        }
        System.out.println(sb);
    }

    private static long getArea(int start, int end) {
        if (start == end) {
            return graph[start];
        }

        int mid = (start + end) / 2;

        long maxAre = Math.max(getArea(start, mid), getArea(mid + 1, end));
        maxAre = Math.max(maxAre, getMidArea(start, end, mid));
        return maxAre;
    }

    private static long getMidArea(int start, int end, int mid) {
        int left = mid;
        int right = mid;
        long maxArea = graph[mid];
        long height = graph[mid];

        while (start < left && right < end) {
            if (graph[left - 1] < graph[right + 1]) {
                right++;
                height = Math.min(height, graph[right]);
            } else {
                left--;
                height = Math.min(height, graph[left]);
            }
            maxArea = Math.max(maxArea, (right - left + 1) * height);
        }
        while (start < left) {
            left--;
            height = Math.min(height, graph[left]);
            maxArea = Math.max(maxArea, (right - left + 1) * height);
        }

        while (right < end) {
            right++;
            height = Math.min(height, graph[right]);
            maxArea = Math.max(maxArea, (right - left + 1) * height);
        }
        return maxArea;
    }
}
