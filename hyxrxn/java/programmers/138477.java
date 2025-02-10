import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[score.length];
        
        for (int i = 0; i < k && i < score.length; i++) {
            list.add(score[i]);
            Collections.sort(list);
            answer[i] = list.get(0);
        }
        
        for (int i = k; i < score.length; i++) {
            list.add(score[i]);
            Collections.sort(list);
            answer[i] = list.get(i + 1 - k);
        }
        
        return answer;
    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/138477
// 명예의 전당 (1)

// 점수를 넣으며 매번 정렬을 수행한다. 1000 * 1000 * log1000 이하이므로 가능.
// k번 혹은 score의 길이번 까지는 가장 작은 값을 정답 배열에 넣는다.
// 이후는 k번째로 큰 값을 정답 배열에 넣는다.
