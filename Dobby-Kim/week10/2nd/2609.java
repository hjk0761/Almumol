import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        N = Integer.parseInt(nums[0]);
        M = Integer.parseInt(nums[1]);
        int biggerNum = Math.max(N, M);
        int smallerNum = Math.min(N, M);

        int maxiumCommonDivisor = 1;
        for(int i = 2; i <= biggerNum; i++) {
            if(N % i == 0 && M % i == 0) maxiumCommonDivisor = i;
        }
        System.out.println(maxiumCommonDivisor);

        for(int i = 1; i <= smallerNum; i++) {
            for(int j = 1; j <= biggerNum; j++) {
                if(biggerNum * i == smallerNum * j) {
                    System.out.println(smallerNum * j);
                    return;
                }
            }
        }
    }
}
