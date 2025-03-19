import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int[] numbers;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        String[] rawNumbers = br.readLine().split(" ");
        numbers = new int[N];

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(rawNumbers[i]);
        }
        countCases(0, 0);

        System.out.println(answer);
    }

    private static void countCases(int currentIndex, int currentSum) {
        if(currentIndex == N) return;
        if(currentSum + numbers[currentIndex] == M) answer++;

        countCases(currentIndex + 1, currentSum + numbers[currentIndex]);
        countCases(currentIndex + 1, currentSum);
    }
}
