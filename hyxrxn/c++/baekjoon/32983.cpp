#include <iostream>
#include <queue>
using namespace std;

int n, m, c, sr, sc;
int arr[1001][1001];
bool visited[1001][1001];
queue<pair<int, int>> q;
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m >> c;
    cin >> sr >> sc;
    sr--;
    sc--;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> arr[i][j];
        }
    }

    int answer = 0;
    int current = 0;
    int size, nx, ny;
    q.push({sr, sc});
    visited[sr][sc] = true;
    while (!q.empty()) {
        size = q.size();
        while (size--) {
            pair<int, int> p = q.front();
            q.pop();
            current += arr[p.first][p.second];
            for (int i = 0; i < 4; i++) {
                nx = p.first + dx[i];
                ny = p.second + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] && arr[nx][ny] != -1) {
                    q.push({nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        answer = max(answer, current);
        current -= c;
    }

    cout << answer;
    return 0;
}
