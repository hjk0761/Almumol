package backjoon.n11401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

5C2 = 3C1 * 2C1
5!
(5-2)!*2!

 */
public class Main2 {
    static long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        long pa = fac(a);
        long ch = (fac(b) * fac(a - b)) % MOD;

        long result = (pa % MOD * pow(ch, MOD - 2) % MOD) % MOD;
        System.out.println(result);

    }

    private static long fac(long n) {
        long result = 1L;
        for (int i = 1; i <= n; i++) {
            result = ((result % MOD) * i) % MOD;
        }
        return result % MOD;
    }

    private static long pow(long num, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return num;
        }
        long powed = pow(num, n / 2);
        long result = (powed * powed) % MOD;
        if (n % 2 == 1) {
            result *= num;
        }
        return result % MOD;
    }
}
