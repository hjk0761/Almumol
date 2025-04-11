import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
1 5 2 1 4 3 4 5 2 1
1 2 2 1 2
[1 2 4]

3. 맨 뒤 값보다 크면 추가
그외는
2. 값 대치 및 인덱스 반환
값거나 작으면서 오른쪽


1 5 2 1 4 3 4 5 2 1
1 1 2 3 1
[4 3 1]
1. 맨 뒤보다 작으면 추가
그외는
2. 값 대치 및 인덱스 반환
    값은 자기랑 같거나 작으면서 왼쪽



 */

public class Main {
    static int N;
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[N];
        int[] dpR = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (graph[i] > graph[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            dpR[i] = 1;

            for (int j = i; j < N; j++) {
                if (graph[i] > graph[j]) {
                    dpR[i] = Math.max(dpR[i], dpR[j] + 1);
                }
            }
        }

//        System.out.println(Arrays.toString(dp));
//        System.out.println(Arrays.toString(dpR));

        int result = 0;
        for (int i = 0; i < N; i++) {
            int tmp = dp[i] + dpR[i];
            result = Math.max(result, tmp);
        }
        System.out.println(result - 1);
    }

}
