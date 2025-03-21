import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] dp;
    static String s1, s2;

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s1 = bf.readLine();
        s2 = bf.readLine();

        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            Arrays.fill(dp[i], 0);
        }
        char[] c1 = (" " + s1).toCharArray();
        char[] c2 = (" " + s2).toCharArray();

        StringBuilder lcs = new StringBuilder();
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (c1[i] == c2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int length = dp[s1.length()][s2.length()];
        System.out.println(length);
        if (length == 0) {
            return;
        }

        int i = s1.length();
        int j = s2.length();
        StringBuilder lcsBuilder = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcsBuilder.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] >= dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        System.out.println(lcsBuilder.reverse().toString());

    }
}
