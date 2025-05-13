package backjoon.n1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] graph;
    static int N;
    static int maxLen;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        graph = new int[N];
        maxLen = 0;
        for (int i = 0; i < N; i++) {
            graph[i] = Integer.parseInt(br.readLine());
            maxLen = Integer.max(maxLen, graph[i]);
        }
//        System.out.println(getCount(199));
        System.out.println(getResult(K));
    }

    // 210, 200, 200, 199, 60, 20
    private static int getResult(int targetCount) {
        long start = 1;
        long end = maxLen;
        while (start < end) {
            long mid = (start + end + 1) / 2;
            int count = getCount((int) mid);
            if (count >= targetCount) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return (int)start;
    }

    private static int getCount(int len) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            count += graph[i] / len;
        }
        return count;
    }
}
