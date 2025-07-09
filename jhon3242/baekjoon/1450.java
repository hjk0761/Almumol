package backjoon.n1450;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int W;
    static int[] arr;
    static List<Integer> aList;
    static List<Integer> bList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        aList = new ArrayList<>();
        bList = new ArrayList<>();

        generate(0, N / 2, 0, true);
        generate(N / 2, N, 0, false);

        Collections.sort(aList);
        Collections.sort(bList);

//        System.out.println(aList);
//        System.out.println(bList);

        long result = 0L;
        int aIdx = 0;
        int bIdx = bList.size() - 1;

        while (aIdx < aList.size() && bIdx >= 0) {
            int sum = aList.get(aIdx) + bList.get(bIdx);
            if (sum > W) {
                bIdx--;
            } else {
                result += bIdx + 1;
                aIdx++;
            }
        }
        System.out.println(result);
        
    }

    private static void generate(int cur, int end, int sum, boolean isA) {
        if (sum > W) {
            return;
        }
        if (cur == end) {
            if (isA) {
                aList.add(sum);
            } else {
                bList.add(sum);
            }
            return;
        }
        generate(cur + 1, end, sum + arr[cur], isA);
        generate(cur + 1, end, sum, isA);
    }
}
