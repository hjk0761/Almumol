import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[n * k][n * k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < k; l++) {
                    for (int m = 0; m < k; m++) {
                        result[i * k + l][j * k + m] = board[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < n * k; i++) {
            for (int j = 0; j < n * k; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
