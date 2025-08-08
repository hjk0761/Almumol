/*

n은 최대 10개
즉 주사위를 고르는 최대 경우의 수는 10C5이다. < 787
주사위 개수는 최대 5개
주사위 하나의 경우의 수 6개

1 * 5 <= 주사위 값 합 <= 100 * 5

주사위가 5개 골라진 상황에서 
합으로 나올 수 있는 모든 경우의 수를 구한다. = 6^5 개 7776

7776 * 787 = 6,119,712

이분 탐색으로 개수를 구해서 확률을 구할 수 있을 듯

*/

import java.util.*;

class Solution {
    static int N; 
    static int[][] dice;
    static int max;
    static int[] answer;
    
    public int[] solution(int[][] dice) {
        
        N = dice.length;
        this.dice = dice;
        max = 0;
        
        List<Integer> listA = new ArrayList();
    
        pickDiceNum(0, -1, new int[N / 2]);
        
        // System.out.println(36 * 36);
        
        // dfs(dice, 0, 0, listA);
        // System.out.println(Arrays.toString(answer));
        // for (int i = 0 ; i < this.answer.length; i++) {
        //     this.answer[i]++;
        // }
        return this.answer;
    }
    
    private void pickDiceNum(int dep, int cur, int[] pick) {
        if (dep == N / 2) {
            int idx = 0;
            int[] nonPick = getNonPick(pick);
            
            // System.out.println(Arrays.toString(pick));
            // System.out.println(Arrays.toString(nonPick));
            
            List<Integer> pickList = new ArrayList<>();
            List<Integer> nonPickList = new ArrayList<>();
            
            dfs(pick, 0, 0, pickList);
            dfs(nonPick, 0, 0, nonPickList);
            
            Collections.sort(pickList);
            Collections.sort(nonPickList);
            
            // System.out.println(pickList);
            // System.out.println(nonPickList);
            int result = getWinCount(pickList, nonPickList);
            if (max < result) {
                max = result;
                int[] answer = new int[pick.length];
                for (int i = 0 ; i < pick.length; i++) {
                    answer[i] = pick[i] + 1;
                }
                this.answer = answer;
            }
            // System.out.println(result);
            // System.out.println(pickList.size());
            // System.out.println(nonPickList);
            
            // System.out.println(getBig(3, List.of(0, 1, 2, 3)));
        
            // System.out.println();
            return ;
        }
        
        for (int i = cur + 1; i < N; i ++) {
            pick[dep] = i;
            pickDiceNum(dep + 1, i, pick);
            pick[dep] = -1;
        }
    }
    
    private int[] getNonPick(int[] pick) {
        int[] result = new int[N / 2];
        int idx = 0;
        for (int i = 0 ; i < N; i++) {
            if (hasIt(pick, i)) {
                continue;
            }
            result[idx++] = i;
        } 
        return result;
    }
    
    private boolean hasIt(int[] pick, int num) {
        for (int j = 0; j <pick.length; j++) {
            if (pick[j] == num) {
                return true;
            }
        }
        return false;
    }
    
    
    private void dfs(int[] pick, int dep, int cur, List<Integer> list) {
        if (dep == N / 2) {
            list.add(cur);
            return;
        }
        
        int diceNum = pick[dep];
        for (int i = 0 ; i < 6; i++) {
            dfs(pick, dep + 1, cur + dice[diceNum][i], list);
        }
    }
    
    private int getWinCount(List<Integer> me, List<Integer> op) {
        int result = 0;
        // System.out.println("op is = " + op);
        for (int i = 0 ; i < me.size(); i++) {
            int cur = me.get(i);
            
            int bigIdx = getBigOrEqual(cur, op);
            if (cur > op.get(bigIdx)) {
                result += me.size();
                continue;
            }
            result += bigIdx;
            // System.out.print("add : " + bigIdx);
            // System.out.print(" cur : " + cur);
            // System.out.print(" result : " + result);
            // System.out.println();
            
        }
        return result;
    }
    
    private int getBigOrEqual(int target, List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        
        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
