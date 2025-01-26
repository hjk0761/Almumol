package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2110 {

    /*
  N개의 집에 C개의 공유기를 설치해야한다.
  최소거리가 최대인 경우를 구해야한다.
  -> 최소거리를 찾아나가면서 C개의 공유기를 설치할 수 있는 상황을 찾는다.
   */

    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // init
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];

        // N개 입력받기
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int min = 1;
        int max = arr[N - 1] - arr[0] + 1;

        while (min < max) {
            int mid = (min + max) / 2;
            // mid 거리에 대해 설치 가능 공유기 갯수 세기
            if (calculate(mid) < C) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }

    static int calculate(int min) {

        int count = 1;
        int before = arr[0];

        for (int i = 1; i < N; i++) {
            int current = arr[i];
            int distance = current - before;

            if (distance >= min) {
                count++;
                before = current;
            }
        }

        return count;
    }
}
