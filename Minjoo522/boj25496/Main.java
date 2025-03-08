import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        List<Integer> jewelries = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            jewelries.add(Integer.parseInt(st.nextToken()));
        }

        jewelries.sort(Integer::compareTo);

        int result = 0;
        for (int jewelry : jewelries) {
            if (p < 200) {
                p += jewelry;
                result++;
            } else {
                break;
            }
        }

        System.out.println(result);
    }
}
