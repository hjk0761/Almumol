import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*

1 2 3 1 2

[1 2 3 1 2]

[1 3 6 7 9]
[1 0 0 1 0]

--------
[1 4 2]
[1 5 7]
[1 2 1]
1



 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long[] sumArr = new long[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sumArr[i] = array[i];
                continue;
            }
            sumArr[i] = sumArr[i - 1] + array[i];
        }

        Map<Integer, Long> modMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = (int) (sumArr[i] % m);
            modMap.put(key, modMap.getOrDefault(key, 0L) + 1);
        }
        long result = modMap.getOrDefault(0, 0L);

        for (int i = 0; i < m; i++) {
            result += comb(modMap.getOrDefault(i, 0L));
        }
        System.out.println(result);
    }

    private static long comb(long n) {
        if (n < 2) {
            return 0;
        }
        return n * (n - 1) / 2;
    }
}
