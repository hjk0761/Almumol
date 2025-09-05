package backjoon.n11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
순서에 따라 결과가 바뀐다..
모든 경우의 수를 브루터포스로 하면 500! 로 최대 값인 11!를 가뿐히 초과한다.

그럼 결국 dp를 사용해야할 것인데
어떻게 dp를 구성하면 좋을까?

1. 2개를 곱한 경우의 수를 저장한다면 어떨까?
dp[1][3] : 1번째랑 3번째를 곱한 경우의 수?
1, 3, 4 순으로 곱한 경우의 수는? dp[1][3] + dp[1][4] 인가? 아니다.X
dp[1][3] + 1의 첫값 * 3의 끝값 * 4의 끝값 이다.
뭔가 dp로 만들기는 어려울 것 같다.

2. 파일합치기와 같이 순서에 따라 값이 변하는 문제이다. -> 더 정확히는 연산 우선순위에 따라 바뀐다.
이때는 bindCount를 사용했었다. 몇개씩 묶은 결과의 값을 사용해서 dp로 했지.
그렇다면 2개씩, 3개씩 묶은 값들을 사용한다면 어떨까?
2개씩은 그렇다 치고 3개씩은 어떻게 해야하지?
bindCount = 3 이라면, 3개씩 묶여야하는데 dp[1][3] 을 1,2,3이 묶긴 경우의수로?
충분히 가능하다. 이때 2개 묶인 경우의 수를 활용하면 될 것 같다. 2개 묶였을 때 min(dp[1][2] + 1의 첫 * 2 끝 * 3끝, 1의 첫 * 2의 첫 * 3끝 + dp[2][3])

dp[1][5] = dp[1][1] dp[2][5], dp[1][2] dp[3][5](2의 끝)

4
5 3
3 2
2 6
6 2

 */
public class Main2 {

    static int N;
    static int[][] graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][2];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[i][0] = a;
            graph[i][1] = b;
        }
        getResult();
        System.out.println(dp[0][N-1]);
    }

    private static void getResult() {
        for (int bindCount = 1; bindCount <= N; bindCount++) {
            for (int start = 0; start + bindCount < N; start++) {
                int end = start + bindCount;
                dp[start][end] = Integer.MAX_VALUE;
                for (int mid = start; mid + 1 <= end; mid++) {
                    dp[start][end] = Math.min(dp[start][end],
                            dp[start][mid] + dp[mid + 1][end] + graph[start][0] * graph[mid][1] * graph[end][1]);
                }
            }
            System.out.println();
        }
    }
}
