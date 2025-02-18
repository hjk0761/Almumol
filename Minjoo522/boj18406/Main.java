import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nums = br.readLine();
        int mid = nums.length() / 2;

        int left = 0;
        int right = 0;
        for (int i = 0; i < mid; i++) {
            left += nums.charAt(i) - '0';
        }
        for (int i = mid; i < nums.length(); i++) {
            right += nums.charAt(i) - '0';
        }

        if (left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
