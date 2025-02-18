import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int count = Integer.parseInt(br.readLine());

            if (count == 0) {
                break;
            }

            String[] words = new String[count];
            for (int i = 0; i < count; i++) {
                words[i] = br.readLine();
            }

            Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
            System.out.println(words[0]);
        }
    }
}
