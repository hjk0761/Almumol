package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 12:35 

public class BJ_30504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Money> A = new PriorityQueue<>(Comparator.comparing(money -> money.value));
        PriorityQueue<Integer> B = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            A.add(new Money(Integer.valueOf(st.nextToken()), i));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            B.add(Integer.valueOf(st.nextToken()));
        }

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            Money a = A.poll();
            int b = B.poll();
            if (a.value > b) {
                System.out.println(-1);
                return;
            }
            temp[a.position] = b;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(temp[i])
                    .append(" ");
        }
        System.out.println(sb);
    }

    private static class Money {
        int value;
        int position;

        public Money(int value, int position) {
            this.value = value;
            this.position = position;
        }
    }
}


//세종이는 영재에게 마지막 유예 기간 N일을 주었다. 
//영재는 세종이가 준 N일 동안 빌린 돈을 모두 갚아야 한다.

// 세종이는 i일째 되는 날에 Ai 만큼 분노한다.
// i일에, Ai 원 이상 돈을 받지 못한다면 분노 표출한다.

// 영재는 가진 돈을 N개의 자루에 담아 세종이에게 하루에 한 자루씩 주려고 한다.


// 5
// 1 2 3 4 5
// 7 3 2 5 4

// 2 3 5 4 7

// A,B 는 10^8 이하
// N은 200000

// 즉, 자기가 가진 값과 가장 비슷하되 높은 값을 찾아야 한다.
// 어차피, 하나라도 막히면 분노를 표출한다.

// 자기보다 큰 값이 있어야만 함
// 자신의 위치와 값을 가지고 값 순서대로 오름차순
// 그 후, B도 정리해서 차례대로 처리한다.
