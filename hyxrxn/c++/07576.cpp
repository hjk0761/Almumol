#include <iostream>
#include <queue>
using namespace std;

int n, m;
int arr[1000][1000];
queue<pair<int, int>> q;
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
int answer = 0;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> m >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> arr[i][j];
            if (arr[i][j] == 1) {
                q.push({i, j});
            }
        }
    }

    while (true) {
        int s = q.size();
        for (int i = 0; i < s; i++) {
            pair p = q.front();
            q.pop();
            for (int j = 0; j < 4; j++) {
                int nx = p.first + dx[j];
                int ny = p.second + dy[j];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    q.push({nx, ny});
                }
            }
        }
        if (!q.empty()) {
            answer++;
        } else {
            break;
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (arr[i][j] == 0) {
                cout << -1;
                return 0;
            }
        }
    }

    cout << answer;
    return 0;
}

// https://www.acmicpc.net/problem/7576

// 1인 애들부터 시작해 bfs를 돌리며 하루 단위로 근처의 0인 애들을 1로 바꾼다.
// 새로 1이 된 애들이 있으면 그 날이 의미가 있었으므로 날짜를 하루 올린다.
// 새로 1이 된 애들이 없으면 그만둔다.
// 전체 배열을 순회하며 아직 0인 애가 있다면 -1을 출력하고, 아니라면 걸린 날짜를 출력한다.
