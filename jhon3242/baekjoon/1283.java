import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<String> store;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        store = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();
            sb.append(line);

            if (!frontWord(line, sb)){
                allWord(line, sb);
            }
            System.out.println(sb);
        }
    }

    private static boolean frontWord(String line, StringBuilder sb) {
        boolean isFront = true;

        for (int i = 0; i < line.length(); i++) {
            String substring = line.substring(i, i + 1);
            if (substring.equals(" ")) {
                isFront = true;
                continue;
            }
            String lowerCase = substring.toLowerCase();
            if (isFront) {
                isFront = false;
                if (store.contains(lowerCase)) {
                    continue;
                }
                sb.replace(i, i + 1, "["+substring+"]");
                store.add(lowerCase);
                return true;
            }
        }
        return false;
    }

    private static void allWord(String line, StringBuilder sb) {
        for (int i = 0; i < line.length(); i++) {
            String substring = line.substring(i, i + 1);
            if (substring.equals(" ")) {
                continue;
            }
            String lowerCase = substring.toLowerCase();
            if (store.contains(lowerCase)) {
                continue;
            }
            sb.replace(i, i + 1, "["+substring+"]");
            store.add(lowerCase);
            return;
        }
    }
}
