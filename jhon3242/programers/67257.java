import java.util.*;

class Solution {

    static List<String> line;
    static Long maxResult;

    public long solution(String expression) {
        long answer = 0;
        maxResult = 0L;
        line = makeList(expression);

        dfs(0, new String[3], new boolean[3]);
        // System.out.println(line);
        return maxResult;

    }

    private void dfs(int start, String[] result, boolean[] visited) {
        if (start == 3) {
            List<String> tmp = new LinkedList<>();
            tmp.addAll(line);

            doOp(result[0]);
            doOp(result[1]);
            doOp(result[2]);

            // System.out.println(line);
            Long t = Long.parseLong(line.get(0));
            Long ab = Math.abs(t);
            maxResult = Math.max(ab, maxResult);

            line = tmp;
            // maxResult

            return;
        }
        String[] ops = {"+", "-", "*"};
        for (int i = 0; i < 3; i ++) {
            if (!visited[i]) {
                result[start] = ops[i];
                visited[i] = true;
                dfs(start + 1, result, visited);
                visited[i] = false;
            }
        }

    }

    private List<String> makeList(String expression) {
        int startIdx = 0;
        List<String> result = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            if ("+-*".contains(expression.substring(i, i+1))) {
                result.add(expression.substring(startIdx, i));
                result.add(expression.substring(i, i+1));
                startIdx = i + 1;
            }
        }
        result.add(expression.substring(startIdx));
        return result;
    }

    private void doOp(String op) {
        int i = 0 ;
        while (i < line.size()) {
            if (line.get(i).equals(op)) {
                Long a = Long.parseLong(line.get(i-1));
                Long b = Long.parseLong(line.get(i+1));
                Long result = opResult(a, b, op);
                line.set(i-1, String.valueOf(result));
                line.remove(i);
                line.remove(i);
                i--;
                continue;
            }
            i++;
        }
    }

    private Long opResult(Long a, Long b, String op) {
        if (op.equals("+")) {
            return a + b;
        }
        if (op.equals("-")) {
            return a - b;
        }
        return a * b;
    }
}
