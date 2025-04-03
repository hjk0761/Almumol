import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[] dpA = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dpA[1] = 1;
        dpA[2] = 1;
        for (int i = 3; i <= 40; i++) {
            dpA[i] = dpA[i - 1] + dpA[i - 2];
        }

        System.out.print(dpA[N] + " ");
        System.out.println(N - 2);
    }

}

