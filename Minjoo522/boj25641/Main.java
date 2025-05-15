import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int countS = 0, countT = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 's') {
                countS++;
            } else {
                countT++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (countS == countT) {
                System.out.println(s.substring(i));
                break;
            } else if (s.charAt(i) == 's') {
                countS--;
            } else {
                countT--;
            }
        }
    }
}
