import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
AVA
ACDCA
CCCZAZZCCC
ABA
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        boolean isAllSame = true;
        int result = -1;

        for (int i = 0; i <= charArray.length / 2; i++) {

            if (charArray[i] != charArray[charArray.length - 1 - i]) {
                System.out.println(charArray.length);
                return;
            }

            if (i + 1 < charArray.length && charArray[i] != charArray[i + 1]) {
                isAllSame = false;
            }
        }
        if (isAllSame) {
            System.out.println(-1);
        } else {
            System.out.println(charArray.length - 1);
        }
    }
}
