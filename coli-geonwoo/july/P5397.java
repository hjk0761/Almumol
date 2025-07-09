import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class P5397 {

    private static Deque<Character> left;
    private static Deque<Character> right;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            char[] charArray = reader.readLine().toCharArray();
            String answer = keyLogger(charArray);
            writer.write(answer + System.lineSeparator());
        }

        writer.flush();
        writer.close();
    }

    private static String keyLogger(char[] charArray) {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
        for (char c : charArray) {
            if (c == '<') {
                if (!left.isEmpty()) {
                    right.addFirst(left.pollLast());
                }
                continue;
            }

            if (c == '>') {
                if (!right.isEmpty()) {
                    left.addLast(right.pollFirst());
                }
                continue;
            }

            if (c == '-') {
                if (!left.isEmpty()) {
                    left.pollLast();
                }
                continue;
            }

            left.addLast(c);
        }
        StringBuilder builder = new StringBuilder();

        for (char l : left) {
            builder.append(l);
        }

        for (char r : right) {
            builder.append(r);
        }
        return builder.toString();
    }
}
