package programmers;

import java.util.*;

class P12927 {

    public long solution(int n, int[] works) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }

        while (n-- > 0) {
            int max = pq.poll();
            pq.offer(max - 1 >= 0 ? max - 1 : 0);
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}
