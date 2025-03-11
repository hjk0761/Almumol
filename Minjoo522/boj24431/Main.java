import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());

            String[] words = new String[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                words[i] = st.nextToken();
            }

            int count = 0;

            for (int i = 0; i < n; i++) {
                if (words[i].isEmpty()) {
                    continue;
                }
                for (int j = i + 1; j < n; j++) {
                    if (words[j].isEmpty()) {
                        continue;
                    }
                    if (words[j].endsWith(words[i].substring(L - F))) {
                        count++;
                        words[i] = "";
                        words[j] = "";
                        break;
                    }
                }
            }

            System.out.println(count);
            T--;
        }
    }
}
