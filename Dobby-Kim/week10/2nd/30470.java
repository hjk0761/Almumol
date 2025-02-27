import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Staircase staircase = new Staircase();
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            int type = Integer.parseInt(parts[0]);
            long x = Long.parseLong(parts[1]);
            if (type == 1) {
                staircase.addLog(x);
            } else {
                staircase.castMagic(x);
            }
        }
        System.out.println(staircase.getTotalSum());
    }

    static class Segment {

        long value;
        int count;

        Segment(long value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    static class Staircase {

        private Deque<Segment> stack;
        private long totalSum;

        public Staircase() {
            stack = new ArrayDeque<>();
            totalSum = 0;
        }

        public void addLog(long x) {
            totalSum += x;
            stack.addLast(new Segment(x, 1));
        }

        public void castMagic(long m) {
            if (stack.isEmpty()) {
                return;
            }
            long currentMax = stack.peekLast().value;
            long newValue = Math.max(currentMax - m, 0);
            int mergedCount = 0;
            while (!stack.isEmpty() && stack.peekLast().value >= newValue) {
                Segment seg = stack.removeLast();
                mergedCount += seg.count;
                totalSum -= (seg.value - newValue) * seg.count;
            }

            if (!stack.isEmpty() && stack.peekLast().value == newValue) {
                stack.peekLast().count += mergedCount;
                return;
            }
            stack.addLast(new Segment(newValue, mergedCount));
        }

        public long getTotalSum() {
            return totalSum;
        }
    }
}
