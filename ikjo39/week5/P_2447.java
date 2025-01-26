import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 테이블 정의
 * DP[i] = i를 1로 만들기 위해 필요한 연산 사용 횟수의 최솟값
 * 2. 점화식 찾기
 * D[12] = ?
 * 1) 3으로 나누거나  DP[12] = D[4] + 1
 * 2) 2로 나누거나   DP[12] = D[6] + 1
 * 3) 1을 빼거나    DP[12] = D[11] + 1
 */
public class P_2447 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], '*');
        }

        removeStar(n, 0, 0, arr);

        for (char[] ar : arr) {
            for (char c : ar) {
                bw.write(c);
            }
            bw.write(System.lineSeparator());
        }
        bw.flush();
    }

    private static void removeStar(int n, int x, int y, char[][] arr) {
        if (n == 1) {
            return;
        }

        int counter = n / 3;

        for (int i = x + counter; i < x + counter * 2; i++) {
            for (int j = y + counter; j < y + counter * 2; j++) {
                arr[i][j] = ' ';
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                removeStar(counter, x + i * counter, y + j * counter, arr);
            }
        }
    }
}
