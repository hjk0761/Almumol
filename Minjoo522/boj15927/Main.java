import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String letters = br.readLine();

        boolean allSame = true;
        for (int i = 1; i < letters.length(); i++) {
            if (letters.charAt(i - 1) != letters.charAt(i)) {
                allSame = false;
            }
        }

        if (allSame) {
            System.out.println(-1);
            return;
        }

        if (isPalindrome(letters)) {
            System.out.println(letters.length() - 1);
            return;
        }
        System.out.println(letters.length());
    }

    static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
