package programmers;

public class P43162 {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (computers[i][i] == 1) { // 방문하지 않았다면
                dfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int i, int n, int[][] computers) {
        computers[i][i] = 0; // 방문 처리
        for (int j = 0; j < n; j++) {
            if (computers[i][j] == 1) {
                computers[i][j] = 0;
                computers[j][i] = 0;
                dfs(j, n, computers);
            }
        }
    }
}
