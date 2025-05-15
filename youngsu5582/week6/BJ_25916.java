package week6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.*;

import static java.lang.Math.max;

// 16:45 -

public class BJ_25916 {
    public static void main(final String[] args) throws IOException, ExecutionException, InterruptedException {
        final ExecutorService executor = Executors.newSingleThreadExecutor();

        // Callable을 사용하여 비동기 작업 정의
        final Callable<String> task = () -> {
            System.out.println("비동기 작업 시작");
            Thread.sleep(2000); // 2초 대기
            return "Hello, Future!";
        };

        // 작업 제출 후 Future 객체 반환
        final Future<String> future = executor.submit(task);

        System.out.println(future.resultNow());
        CompletableFuture.completedFuture(null).thenAccept(System.out::println);
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());

        final int[] ary = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = 0;

        while (left < n) {
            if (sum + ary[left] <= m) {
                sum += ary[left++];
                answer = max(answer, sum);
            } else {
                sum -= ary[right++];
            }
        }
        System.out.println(answer);
    }
}


// 투포인터?

// 각 요소들의 합을 더한다.
// 요소들의 합이 작을시? -> 오른쪽 이동
// 요소들의 합이 클시? -> 왼쪽 이동

// 아예 M 을 넘는 값이라면? -> 오른쪽 다음칸부터 다시 시작
