package backjoon.n13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
5 17


 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[100_001];
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[start] = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(start);
        while (!deque.isEmpty()) {
            int cur = deque.pollFirst();
            if (cur == end) {
                System.out.println(arr[cur]);
                return;
            }
            int curCost = arr[cur];
            if (cur - 1 >= 0 && arr[cur - 1] > curCost + 1) {
                arr[cur - 1] = curCost + 1;
                deque.addLast(cur - 1);
            }
            if (cur + 1 <= 100_000 && arr[cur + 1] > curCost + 1) {
                arr[cur + 1] = curCost + 1;
                deque.addLast(cur + 1);
            }

            if (cur * 2 <= 100_000 && arr[cur * 2] > curCost) {
                arr[cur * 2] = curCost;
                deque.addLast(cur * 2);
            }
        }
    }
}
