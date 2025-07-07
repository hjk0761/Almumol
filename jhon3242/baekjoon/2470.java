package backjoon.n2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(array);

        int start = 0;
        int end = N - 1;
        int result = Integer.MAX_VALUE;
        int[] resultArr = new int[2];
        while (start < end) {
            int sum = array[start] + array[end];
            if (result > Math.abs(sum)) {
                result = Math.abs(sum);
                resultArr[0] = array[start];
                resultArr[1] = array[end];
            }
            if (sum < 0) {
                start++;
            } else if (sum > 0) {
                end--;
            } else {
                break;
            }
        }
        System.out.println(resultArr[0] + " " + resultArr[1]);
    }
}
