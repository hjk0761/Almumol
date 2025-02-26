package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 10:35 - 11:04

public class BJ_30618 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] ary = new int[n+1];
        int number = n;
        // 홀수
        if (n % 2 != 0) {
            ary[n / 2] = number--;
        }

        int left = n / 2 - 1;
        int right = n % 2 != 0 ? n / 2 + 1 : n / 2;
        // left : 4 -> 1
        // right : 4 -> 2

        // left : 5 -> 1
        // right : 5 -> 3


        while (0 <= left && right < n) {
            ary[left--] = number--;
            ary[right++] = number--;
        }
        for(int i = 0 ;i<n;i++){
            sb.append(ary[i]).append(' ');
        }
        System.out.println(sb);
    }
}

// 가장 작은값 맨 뒤
// 그 앞은 차례로?

// N은 200000

// 5
// 3번째가 최대, 2-4, 1-5
// 홀수라면? /2 +1 = 3
// 그 후, -1 +1 하나씩


//


// 4
// 2,3째가 최대, 1-4
// 2 : 4
// 3 : 6
// 4 : 6
// 1 : 4


// 1
// 2
// 3
// 4

// 1 2
// 2 3
// 3 4
// 1 2 3
// 2 3 4
// 1 2 3 4


// 23,34,41 <-> 12 23 34
// 17 <-> 15

// 5?


// 1 2 3

// 1 2, 2 3 -> ?

// 3 5
// 8?

// 1
// 12
// 123
// 2
// 23
