import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int[] available = new int[n];
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            available[i] = 1;
            for (int j = 0; j < i; j++) {
                if (height[i] > height[j] && available[i] < available[j] + 1) {
                    available[i] = available[j] + 1;
                }
            }
            if (available[i] > maxi) {
                maxi = available[i];
            }
        }

        System.out.println(maxi);
    }
}

// https://softeer.ai/practice/6293

// available에는 그 징검다리를 마지막으로 할 때의 최대 길이를 저장한다.
// 내 돌만 밟았을 때 1이므로 초기화는 1로 한다.
// 앞의 돌이 내 돌보다 낮다면 거길 거쳐올 수 있다.
// 그러므로 앞의 나보다 낮은 모든 돌을 보며 거길 거쳐올 때의 길이가 현재 최대 길이보다 길다면 갱신한다.
// 전체 배열의 최댓값을 출력한다.
