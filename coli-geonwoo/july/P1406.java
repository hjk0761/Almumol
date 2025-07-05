import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class P1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = reader.readLine().toCharArray();
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < inputs.length; i++) {
            left.add(inputs[i]);
        }

        for (int i = 0; i < n; i++) {
            String st = reader.readLine();
            char operation = st.charAt(0);

            if (operation == 'L') {
                if(left.isEmpty()) {
                    continue;
                }
                right.addFirst(left.pollLast());
                continue;
            }

            if (operation == 'D') {
                if(right.isEmpty()){
                    continue;
                }
                left.addLast(right.pollFirst());
                continue;
            }

            if (operation == 'B') {
                if (left.isEmpty()) {
                    continue;
                }
                left.pollLast();
                continue;
            }

            if (operation == 'P') {
                char s = st.charAt(2);
                left.addLast(s);
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int leftLength = left.size();
        int rightLength = right.size();

        for (int i = 0; i < leftLength; i++) {
            bw.write(left.pollFirst());
        }

        for (int i = 0; i < rightLength; i++) {
            bw.write(right.pollFirst());
        }
        bw.flush();
        bw.close();
    }
}
