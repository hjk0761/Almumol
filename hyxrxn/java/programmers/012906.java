import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (s.peek() != arr[i]) {
                s.push(arr[i]);
            }
        }
        
        
        int[] answer = new int[s.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[answer.length - 1 - i] = s.peek();
            s.pop();
        }
        
        return answer;
    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/12906
// 같은 숫자는 싫어

// 스택을 사용하며 가장 최근에 넣은 숫자와 이제 넣으려고 하는 숫자를 비교한다.
// 이때 첫 숫자는 비교할 것이 없으므로 먼저 넣어 놓는다.
// 모두 넣었다면 스택에서 하나씩 빼내며 정답 배열의 뒤부터 채운다.
