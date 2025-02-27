#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int n;
int map[100][100];
bool visited[100][100] = {0};
queue<pair<int, int>> q;
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};
int nx, ny;
int mapIndex = 0;
int minLength = 100000;
int currentMap;

void setMap() {
    while (!q.empty()) {
        pair<int, int> p = q.front();
        q.pop();
        for (int i = 0; i < 4; i++) {
            nx = p.first + dx[i];
            ny = p.second + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < n && map[nx][ny] == 1 && visited[nx][ny] == 0) {
                visited[nx][ny] = true;
                map[nx][ny] = mapIndex;
                q.push({nx, ny});
            }
        }
    }

}

int bfs(int count) {
    int size = q.size();

    while (size) {
        pair<int, int> p = q.front();
        q.pop();
        size--;
        for (int i = 0; i < 4; i++) {
            nx = p.first + dx[i];
            ny = p.second + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < n && visited[nx][ny] == 0) {
                if (map[nx][ny] != 0 && map[nx][ny] != currentMap) {
                    while (!q.empty()) {
                        q.pop();
                    }
                    return count;
                } else if (map[nx][ny] == 0){
                    visited[nx][ny] = true;
                    q.push({nx, ny});
                }
            }
        }
    }

    if (q.empty()) {
        return 100000;
    } else {
        return bfs(count + 1);
    }
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> map[i][j];
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (map[i][j] == 1 && visited[i][j] == 0) {
                mapIndex++;
                visited[i][j] = true;
                map[i][j] = mapIndex;
                q.push({i, j});
                setMap();
            }
        }
    }

    for (currentMap = 1; currentMap < mapIndex; currentMap++) {
        memset(visited, 0, sizeof(visited));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == currentMap) {
                    visited[i][j] = true;
                    q.push({i, j});
                }
            }
        }
        minLength = min(minLength, bfs(0));
    }

    cout << minLength;
    return 0;
}
