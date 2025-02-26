import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        arr = new int[N];
        int anwer = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        for(int i = 0; i < N; i++) {
            boolean isPrime = true;
            if(arr[i] == 1) continue;
            for(int j = 2; j <= arr[i] / 2; j++) {
                if(arr[i] % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) anwer++;
        }
        System.out.println(anwer);
    }
}
