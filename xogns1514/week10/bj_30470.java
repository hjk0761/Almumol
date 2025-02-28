package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj_30470 {

    static int n;
    static Deque<Integer> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Deque<Long> stack = new ArrayDeque<>();
        long answer = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            if (query == 1) {
                stack.push(B);
            } else {
                if (!stack.isEmpty()) {
                    long K = stack.pop();
                    stack.push(Math.max(K - B, 0));
                }
            }
        }

        if (!stack.isEmpty()) {
            long top = stack.peek();
            while (!stack.isEmpty()) {
                long now = stack.pop();
                if (now > top) {
                    answer += top;
                } else if (now < top) {
                    top = now;
                    answer += now;
                } else {
                    answer += now;
                }
            }
        }

        System.out.println(answer);
    }
}
