import java.util.*;
/*
2, 3, 9, 12, 13  : 2
1, 4, 6, 7, 9 : 1
1, 2, 8, 10, 12 : 3
6, 7, 11, 13, 15 : 0
1, 4, 10, 11, 14 : 1

1, 2, 3, 4, 8

n: 30개
q: 10 개

1, 2, 3, 4, 5 : 2
6, 7, 8, 9, 10, : 3
[3, 7, 8, 9, 10],  :4
[2, 5, 7, 9, 10],  :3
[3, 4, 5, 6, 7]]   :3

1 3 6

최대 30 * 10 * 5 = 1,500
*/
class Solution {
    static int[][] q;
    static int[] ans;
    static int n;
    static int result;
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        this.n = n;
        this.q = q;
        this.ans = ans;
        this.result = 0;
        // this.n = 5;
        // System.out.println(getMatchCount(new int[]{1, 4, 6, 7, 9}, new int[]{1, 2, 3, 4, 8}));
        dfs(new int[5], 0);
        // System.out.println(isValid(new int[] {3, 5, 7, 9, 10}));
        return result;
    }
    
    private void dfs(int[] cur, int dep) {
        if (dep == 5) {
            if (isValid(cur)) {
                result++;
                // System.out.println(Arrays.toString(cur));    
            }
            return;
        }
        int start = 1;
        if (dep > 0) {
            start = cur[dep - 1] + 1;
        }
        for (int i = start; i <= n; i++) {
            cur[dep] = i;
            dfs(cur, dep + 1);
            
            // System.out.println(Arrays.toString(cur));
        }
    }
    
    private boolean isValid(int[] cur) {
        for (int i = 0;  i < q.length; i++) {
            int expected = ans[i];
            // int zeroCount = 5 - (dep + 1);
            if (getMatchCount(q[i], cur) != expected) {
                return false;
            }
        }
        return true;
    }
    
    private int getMatchCount(int[] me, int[] an) {
        int meIdx = 0;
        int anIdx = 0;
        int count = 0;
        while (meIdx < 5 && anIdx < 5) {
            if (me[meIdx] == an[anIdx]) {
                meIdx++;
                anIdx++;
                count++;
                continue;
            }
            if (me[meIdx] < an[anIdx]) {
                meIdx++;
            } else {
                anIdx++;
            }
        }
        return count;
    }
}
