#include <iostream>
#include <queue>
using namespace std;

int t, kk, m, n, x, y;
queue<pair<int, int>> q;
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> t;
    for (int i = 0; i < t; i++) {
        cin >> m >> n >> kk;
        int arr[50][50] = {0};
        int visit[50][50] = {0};
        for (int j = 0; j < kk; j++) {
            cin >> x >> y;
            arr[x][y] = 1;
        }
        int answer = 0;
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                if (arr[j][k] == 1 && visit[j][k] == 0) {
                    visit[j][k] = 1;
                    q.push({j, k});
                    while(!q.empty()) {
                        pair p = q.front();
                        q.pop();
                        for (int l = 0; l < 4; l++) {
                            int nx = p.first + dx[l];
                            int ny = p.second + dy[l];
                            if (0 <= nx && nx < m && 0 <= ny && ny < n && arr[nx][ny] == 1 && visit[nx][ny] == 0) {
                                visit[nx][ny] = 1;
                                q.push({nx, ny});
                            }
                        }
                    }
                    answer++;
                }
            }
        }
        cout << answer << " ";
    }

    return 0;
}

// https://www.acmicpc.net/problem/1012

// 케이스별로 배추의 위치를 저장할 배열을 새로 만든다. 매번 초기화를 직접 하긴 귀찮고 오래걸리니까...
// 배열을 돌며 배추가 있고 아직 방문하지 않았는지 확인하고, 그렇다면 그 배추와 연결된 배추를 모두 방문한다.
// 방문은 큐를 사용해 bfs로 진행한다.
// 방문을 마쳤다면 배추흰지렁이의 개수를 하나 늘린다.
