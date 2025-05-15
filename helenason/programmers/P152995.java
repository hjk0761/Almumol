package programmers;

import java.util.*;

class P152995 {

    public int solution(int[][] scores) {
        int answer = 1;
        int[] myScore = scores[0];
        int mine = scores[0][0] + scores[0][1];

        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]); // 첫번째 기준 내림차순, 두번째 기준 오름차순

        int maxY = -1;
        for (int[] score : scores) {
            if (maxY <= score[1]) { // 조건이 되는 사원
                maxY = score[1];
                if (mine < score[0] + score[1]) { // 나보다 윗 순위이면 등수 내리기
                    answer++;
                }
                continue;
            }
            // 조건이 안 되는 사원
            if (score == myScore) {
                return -1;
            }
        }
        return answer;
    }
}
