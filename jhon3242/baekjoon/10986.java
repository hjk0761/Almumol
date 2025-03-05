
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
5 3
1 2 3 1 2

1 3 6 7 9

 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] sumArr = new long[array.length];
        int[] modArr = new int[M];

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                sumArr[i] = array[i];
            } else {
                sumArr[i] = sumArr[i - 1] + array[i];
            }
            modArr[(int) (sumArr[i] % M)]++;
        }

        long result = modArr[0];
        for (int i = 0; i < M; i++) {
            result += ComB(modArr[i]);
        }
        System.out.println(result);
    }

    private static long ComB(long n) {
        if (n < 2) {
            return 0;
        }
        return n * (n - 1) / 2;
    }
}
