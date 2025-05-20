package backjoon.n6549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

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
            sb.append(op(0, N - 1)).append("\n");

//            System.out.println(getMid(2, 3));
//            break;
        }
        System.out.println(sb);
    }

    private static long op(int start, int end) {
//        System.out.print("start = " + start);
//        System.out.println(" end = " + end);
        if (start == end) {
            return graph[start];
        }
        int mid = (start + end) / 2;
        long left = op(start, mid);
        long right = op(mid + 1, end);
        long merge = getMid(start, end);

        long result = Math.max(left, right);
        result = Math.max(result, merge);
        return result;
    }

    private static long getMid(int start, int end) {
        int mid = (start + end) / 2;
        int left = mid;
        int right = mid;
        int height = graph[mid];
        long result = 0;

        while (start < left && right < end) {
            if (graph[left - 1] < graph[right + 1]) {
                height = Math.min(height, graph[right + 1]);
                right++;
            } else {
                height = Math.min(height, graph[left - 1]);
                left--;
            }
            result = Math.max(result, height * (long)(right - left + 1));
        }

        while (start < left) {
            height = Math.min(height, graph[left - 1]);
            left--;
            result = Math.max(result, height * (long)(right - left + 1));
        }

        while (right < end) {
            height = Math.min(height, graph[right + 1]);
            right++;
//            System.out.print("right = " + right);
//            System.out.println(" left = " + left);
            result = Math.max(result, height * (long)(right - left + 1));
        }
        return result;
    }
}
