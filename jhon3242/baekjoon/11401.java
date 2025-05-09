package backjoon.n11401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*

        1C0 1C1
      2C0 2C1 2C2
     3C0 3C1 3C2 3C3
    4C0 4C1 4C2 4C3 4C4
   5C0 5C1 5C2 5C3 5C4 5C5

N! * (N - K)!

a
 */

public class Main {

    static long mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long ch = fac(n);
        long pa = fac(k) * fac(n - k);
        long result = ((ch % mod) * (pow(pa, mod - 2) % mod)) % mod;
        System.out.println(result);
    }

    private static long fac(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = ((result % mod) * (i % mod)) % mod;
        }
        return result;
    }

    private static long pow(long n, long pow) {
        if (pow == 0) {
            return 1;
        }
        if (pow == 1) {
            return n % mod;
        }
        long tmp = pow(n, pow / 2);
        if (pow % 2 == 1) {
            long l = (tmp % mod) * (tmp % mod) % mod;
            return (l * (n % mod)) % mod;
        }
        return ((tmp % mod) * (tmp % mod)) % mod;
    }
}
