import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        String[] secondLine = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(secondLine[i]);
        }
        int answer = 0;
        for(int i = 0; i < N-2; i++) {
            for(int j = i + 1; j < N-1; j++) {
                for(int k = j + 1; k < N; k++) {
                    answer = closerToM(answer, arr[i] + arr[j] + arr[k]);
                    if(answer == M) {
                        System.out.print(answer);
                        return;
                    }
                }
            }
        }
        System.out.print(answer);
    }

    private static int closerToM(int prev, int curr) {
        if(prev < curr && curr <= M) {
            return curr;
        }
        return prev;
    }
}
