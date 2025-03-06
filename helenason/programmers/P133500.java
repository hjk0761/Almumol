package programmers;

import java.util.*;

/*
0. 트리 + DFS
1. 문제가 주는 그래프가 무조건 트리 형태임을 인지해야한다.
2. 리프 노드부터 탐색하여 자식 중 하나라도 껴져있으면 본인을 켠다.
 */

class P133500 {

    boolean[] visited;
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    int answer = 0;

    public int solution(int n, int[][] lighthouse) {

        // init
        this.visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] lights : lighthouse) {
            int a = lights[0];
            int b = lights[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 리프 노드부터 탐색
        dfs(1); // 루트를 무조건 1번 노드로 고정
        return answer;
    }

    boolean dfs(int now) {
        visited[now] = true;
        boolean haveToOn = false;
        for (int child : graph.get(now)) {
            if (visited[child]) {
                continue;
            }
            boolean isOn = dfs(child); // child 의 켜짐 여부를 기반으로 본인의 켜짐 여부를 결정함
            if (!isOn) { // """자식 중 하나라도 꺼져있으면 본인을 켜야함"""
                haveToOn = true;
            }
        }
        if (haveToOn) {
            answer++;
            return true;
        }
        // 자식 모두 켜져있으면 or 본인이 리프노드라면 안 켜도 됨
        return false;
    }
}
