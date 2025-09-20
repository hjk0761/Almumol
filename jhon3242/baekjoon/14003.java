package backjoon.n14003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
/*

현재 값보다 작은 값중에서 LIS 길이가 큰 애를 찾고 싶다.
lis: 길이 위치에 마지막 원소가 저장되어 있음
dp:
 */

public class Main {
    static int[] tails;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        tails = new int[N];
        int[] parents = new int[N];
        int[] pos = new int[N]; // pos[i] = tails[i]를 바꾼 원소의 인덱스

        Arrays.fill(parents, -1);
        int len = 0;

        for (int cur = 0; cur < N; cur++) {
            int target = arr[cur];
            int idx = getLisIdx(len, target);
            tails[idx] = target;
            pos[idx] = cur;
            if (idx > 0) parents[cur] = pos[idx - 1];
            if (idx == len) len++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(len).append("\n");

        Deque<Integer> deque = new ArrayDeque<>();
        int next = pos[len - 1];
        while (next != -1) {
            deque.addFirst(arr[next]);
            next = parents[next];
        }
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }

    private static int getLisIdx(int len, int target) {
        int start = 0;
        int end = len;
        while (start < end) {
            int mid = (start + end)/2;
            if (tails[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
