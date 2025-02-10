class Solution {
    public int solution(int[][] board) {
        int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                for (int k = 0; k < 8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (board[i][j] == 1
                        && 0 <= nx && nx < board.length
                        && 0 <= ny && ny < board[i].length
                        && board[nx][ny] == 0) {
                        board[nx][ny] = 2;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120866
// 안전지대

// 폭탄이 있는 곳이 1, 없는 곳이 0이므로 0이었다가 폭탄에 영향을 받는 곳이 된 곳은 2로 설정한다.
// 보드를 돌며 1이라면(폭탄이 있다면) 그 지점의 상하좌우, 대각선을 모두 2로 설정한다.
// 이때 상하좌우, 대각선이 보드를 넘거나, 폭탄이 이미 있는 1인 상태이거나, 영향을 받는 2인 상태인 경우 무시해야 한다.
// 다시 보드를 돌며 여전히 0인 곳의 개수를 센다.
