import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(1);
            } else if (stack.empty()){
                answer = false;
            } else {
                stack.pop();
            }
        }
        if (!stack.empty()) {
            answer = false;
        }
        
        return answer;
    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/12909
// 올바른 괄호

// 문자열을 순서대로 보며 '('가 있다면 스택에 하나를 쌓고, ')'가 있다면 스택에서 하나를 뺀다.
// 이때 더이상 뺄 것이 없는 경우 닫을 괄호에 맞는 여는 괄호가 없는 것이므로 답을 false로 설정한다.
// 모두 순회한 후 스택에 아직 남아있는 것이 있는 경우 여는 괄호에 맞는 닫는 괄호가 없는 것이므로 답을 false로 설정한다.
