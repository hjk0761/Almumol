package backjoon.n1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
n: 1
1 -> 1

n: 2
00, 11 -> 2

n: 3
001, 100, 111 -> 3

n: 4
0000, 0011, 1001, 1100, 1111 -> 5

n: 5
00001, 00100, 10000, 00111, 10011, 11001, 11100, 11111  -> 8
n / 2 -> 00 타일 개수 t : 0~2
    t + n-t*2C2 =
    t : 2
       3C2 = 3
    t : 1
        4C1 = 4
    t : 0
        5C0 = 1

n:6
t = 3

t : 3
    3C3 = 1
t : 2
    4C2 = 6
5 : 1
    5C1 = 5




 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 2];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 15746;
        }

        System.out.println(dp[N]);
    }
}
