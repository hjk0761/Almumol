import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*

10
5      5
2 2 1
11

1. 지수가 홀수 일때
2. 지수기 짝수 일 때
    1.

 */

public class Main {

    static Map<Long, Long> map;
    static int a;
    static int b;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new HashMap<>();
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(getMod(b));
    }

    private static long getMod(long cur) {
        if (map.containsKey(cur)) {
            return map.get(cur);
        }
        if (cur == 1) {
            return a % c;
        }

        long result;
        if (cur % 2 == 1) {
            result = getMod(cur / 2) % c * getMod(cur / 2) % c * getMod(1);
        } else {
            result = getMod(cur / 2) % c * getMod(cur / 2) % c;
        }
        result %= c;
        map.put(cur, result);
        return result;
    }
}
