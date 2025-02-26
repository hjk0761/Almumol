import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] scores = br.readLine().split(" ");

        int max = 0;
        int total = 0;
        for(String score : scores) {
            int num = Integer.parseInt(score);
            max = Math.max(max, num);
            total += num;
        }
        System.out.println((((double) total)/N)/max*100);
    }
}
