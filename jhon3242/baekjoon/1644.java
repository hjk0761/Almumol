package backjoon.n1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> primes = getPrimes(N);
        int result = 0;

        int start = 0;
        int acc = 0;
        for (int i = 0; i < primes.size(); i++) {
            acc += primes.get(i);
            while (acc > N) {
                acc -= primes.get(start);
                start++;
            }
            if (acc == N) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static List<Integer> getPrimes(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
