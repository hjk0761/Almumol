import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*


 */
public class Main {
    static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        dfs(a, b);
        if (result) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(String a, String b) {
        if (a.length() == b.length()) {
            if (a.equals(b)) {
                result = true;
            }
            return;
        }

        if (b.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(b.substring(1));
            dfs(a, sb.reverse().toString());
        }
        if (b.charAt(b.length() - 1) == 'A') {
            dfs(a, b.substring(0, b.length() - 1));
        }
    }

}
