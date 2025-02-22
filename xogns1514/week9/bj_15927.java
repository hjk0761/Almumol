package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_15927 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        int length = input.length();
        int front = 0;
        int rear = length - 1;

        boolean isAllSame = true;

        while (front < rear) {
            if (input.charAt(front) != input.charAt(rear)) {
                System.out.println(length);
                return;
            }
            if (input.charAt(front) != input.charAt(front + 1)) {
                isAllSame = false;
            }
            front++;
            rear--;
        }

        if (isAllSame) {
            System.out.println(-1);
        } else {
            System.out.println(length - 1);
        }
    }
}
