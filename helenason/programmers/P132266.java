package programmers;

import java.util.*;

/*
0. BFS 거꾸로
1. 꼭 출발점에서 시작하지 않아도 된다는 것! 도착점에서 시작하니 시간초과가 줄었다.
2. BFS + DP도 좋은 접근이었으나 시간초과
 */

public class P132266 {

    Map<Integer, Set<Integer>> graph = new HashMap<>();
    int[] visit;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        this.visit = new int[n + 1];
        Arrays.fill(visit, -1);

        // 1. graph
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        // 2. 각 멤버별 BFS 거꾸로 하여 최단거리 구하기
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(destination);
        visit[destination] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                if (visit[next] != -1) { // 이미 방문 == 최단거리
                    continue;
                }
                queue.offer(next);
                visit[next] = visit[now] + 1;
            }
        }

        // 3. visit 배열에서 최단거리 조회
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = visit[sources[i]];
        }
        return answer;
    }
}
