package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2581 {

    /*
     * 소수 구하기
     * N = 10,000
     * (N-M+1) * N^(1/2)
     */

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = N;

        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                sum += i;

                if (i < min) {
                    min = i;
                }
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }

    }

    static boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
