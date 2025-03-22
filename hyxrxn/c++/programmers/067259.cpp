#include <vector>
using namespace std;

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
int mini = 10000000;
int n;
bool visit[25][25] = {false};
vector<vector<int>> board2;
int costs[25][25][4];

void go(int x, int y, int cost, int direction) {
    if (cost > mini || cost >= costs[x][y][direction]) {
        return;
    }
    costs[x][y][direction] = cost;

    if (x == n - 1 && y == n - 1) {
        mini = min(mini, cost);
        return;
    }

    for (int i = 0; i < 4; i++) {
        int nd = (direction + i) % 4;
        int nx = x + dx[nd];
        int ny = y + dy[nd];
        if (0 <= nx && nx < n && 0 <= ny && ny < n && board2[nx][ny] == 0 && !visit[nx][ny]) {
            visit[nx][ny] = true;
            if (i == 0) {
                go(nx, ny, cost + 100, direction);
            } else {
                go(nx, ny, cost + 600, nd);
            }
            visit[nx][ny] = false;
        }
    }
}

int solution(vector<vector<int>> board) {
    n = board.size();
    board2 = board;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < 4; k++) {
                costs[i][j][k] = 10000000;
            }
        }
    }

    visit[0][0] = true;

    if (board[1][0] == 0) {
        visit[1][0] = true;
        go(1, 0, 100, 0);
        visit[1][0] = false;
    }

    if (board[0][1] == 0) {
        visit[0][1] = true;
        go(0, 1, 100, 2);
        visit[0][1] = false;
    }

    return mini;
}
