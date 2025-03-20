import java.util.*;

public class 비밀_코드_해독 {

    static int n;
    static int cnt = 0;
    static int [] answers;
    static int m;
    static Map<Integer, Set<Integer>> numbers = new HashMap<>();

    public int solution(int num, int[][] q, int[] ans) {
        n= num;
        m= q.length;
        answers = ans;

        for(int i=0; i<m; i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<5; j++){
                set.add(q[i][j]);
            }
            numbers.put(i, set);
        }

        dfs(new HashSet<>(), 0);

        return cnt;
    }

    private static void dfs(Set<Integer> set, int idx) {
        if(set.size() ==5) {
            for(int i=0; i<m; i++){
                Set s = new HashSet<>();
                s.addAll(set);
                Set<Integer> qs = numbers.get(i);
                s.retainAll(qs);
                if(s.size()!= answers[i]){
                    return;
                }
            }
            cnt++;
            return;
        }

        for(int i=idx+1; i<=n; i++){
            set.add(i);
            dfs(set, i);
            set.remove(i);
        }

        return;
    }
}
