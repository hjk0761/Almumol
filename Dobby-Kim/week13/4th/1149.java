import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int[][] RGBs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        RGBs = new int[3][N];
        dp = new int[3][N];
        for(int i = 0; i < N; i++) {
            String[] rgb = br.readLine().split(" ");
            for(int j = 0; j < 3; j++) {
                RGBs[j][i] = Integer.parseInt(rgb[j]);
            }
        }

        int[] prev = new int[3];
        int[] curr = new int[3];

        for (int c = 0; c < 3; c++) {
            prev[c] = RGBs[c][0];
        }

        for (int i = 1; i < N; i++) {
            curr[0] = Math.min(prev[1], prev[2]) + RGBs[0][i];
            curr[1] = Math.min(prev[0], prev[2]) + RGBs[1][i];
            curr[2] = Math.min(prev[0], prev[1]) + RGBs[2][i];

            for (int c = 0; c < 3; c++) {
                prev[c] = curr[c];
            }
        }

        int answer = Math.min(prev[0], Math.min(prev[1], prev[2]));
        System.out.println(answer);
    }
}
