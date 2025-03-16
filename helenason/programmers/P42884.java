package programmers;

import java.util.*;

/*
정렬했기 때문에 다음 점의 끝점은 무조건 현재 점의 끝점보다 오른쪽에 있다.
즉, 다음 점의 시작점이 현재 점의 끝점보다 작으면 교집합을 가진다.
그렇게 카메라를 설치할 하나의 구간으로 취급한다.
 */

class P42884 {

    public int solution(int[][] routes) {
        int answer = 0;

        // 0. 작 -> 큰 으로 순서 통일 (방향 통일)
        for (int i = 0; i < routes.length; i++) {
            int a = routes[i][0];
            int b = routes[i][1];

            routes[i][0] = Math.min(a, b);
            routes[i][1] = Math.max(a, b);
        }

        // 1. 끝점 원소 기준 오름차순
        Arrays.sort(routes, Comparator.comparing(route -> route[1]));

        // 2. 첫 원소의 y보다 작거나 같은 애들 묶기
        int tmp = -99999;
        for (int i = 0; i < routes.length; i++) {
            int a = routes[i][0];
            int b = routes[i][1];

            if (a <= tmp) {
                continue;
            }
            tmp = b;
            answer++;
        }

        return answer;
    }
}
