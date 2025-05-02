import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        int pisano = 15 * 1000000;
        N %= pisano;

        int prev2 = 0;
        int prev = 1;
        int cur = 0;
        int mod = 1_000_000;

        if (N == 0) {
            System.out.println(prev2);
        } else if (N == 1) {
            System.out.println(prev);
        } else {
            for (int i = 2; i <= N; i++) {
                cur = prev + prev2;
                cur %= mod;
                prev2 = prev % mod;
                prev = cur % mod;
            }
            System.out.println(cur);
        }
    }
}
