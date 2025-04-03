package backjoon.n9184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, Integer> store = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line.equals("-1 -1 -1")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");

            store.put(getKey(0, 0, 0), 1);
            sb.append(w(a, b, c)).append("\n");
//            break;
        }
        System.out.println(sb);
    }

    private static int w(int a, int b, int c) {
        String key = getKey(a, b, c);
        if (store.containsKey(key)) {
            return store.get(key);
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            store.put(key, 1);
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }
        int result = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        store.put(key, result);
        return result;
    }

    private static String getKey(int a, int b, int c) {
        return a + "," + b + "," + c;
    }
}
