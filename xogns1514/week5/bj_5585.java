package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_5585 {
    /*
     * 거스름돈 개수가 가장 적게 잔돈을 준다
     * -> 가장 큰 잔돈부터 가능한지 확인
     * -> 그리디
     */

    static int[] change = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int out = 1000 - input;
        int result = 0;

        // calculate
        for (int ch : change) {

            int div = out / ch;
            if (div > 0) {
                result += div;
                out = out % ch;
            }
        }

        System.out.println(result);
    }
}
