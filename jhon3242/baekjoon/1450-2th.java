package backjoon.n1450;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*

10

1 2 3 4
개수를 어떻게 구할건데?

5 6 7 7

 */

public class Main2 {
    static int N;
    static int C;
    static int[] arr;
    static List<Integer> listA;
    static List<Integer> listB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        listA = new ArrayList<>();
        listB = new ArrayList<>();

        int div = N / 2;
        generate(0, div, 0, true);
        generate(div, N, 0, false);

        Collections.sort(listA);
        Collections.sort(listB);

        int start = 0;
        int end = listB.size() - 1;
        int result = 0;
        while (start < listA.size() && end >= 0) {
            int sum = listA.get(start) + listB.get(end);
            if (sum <= C) {
                result += end + 1;
                start++;
            } else {
                end--;
            }
        }
        System.out.println(result);
    }

    private static void generate(int cur, int end, int sum, boolean isA) {
        if (sum > C) {
            return;
        }
        if (cur == end) {
            if (isA) {
                listA.add(sum);
            } else {
                listB.add(sum);
            }
            return;
        }

        generate(cur + 1, end, sum + arr[cur], isA);
        generate(cur + 1, end, sum, isA);
    }
}
