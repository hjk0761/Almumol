import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        N = Integer.parseInt(nums[0]);
        M = Integer.parseInt(nums[1]);

        System.out.println(combination(N, M));
    }

    private static int combination(int n, int m) {
        int result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        for(int i = 1; i <= m; i++) {
            result /= i;
        }
        for(int i = 1; i <= (n - m); i++) {
            result /= i;
        }
        return result;
    }
}
