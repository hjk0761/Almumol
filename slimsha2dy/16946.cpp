#include <iostream>
#include <algorithm>
#include <queue>
#include <set>

using namespace std;
int n, m;
int board[1010][1010], vis[1010][1010], sis[1010][1010], res[1010][1010];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		string s;
		cin >> s;
		for (int j = 0; j < m; ++j)
			board[i][j] = s[j] - '0';
	}

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (board[i][j] == 1 || vis[i][j]) continue;
			queue<pair<int, int>> q;
			set<pair<int, int>> s;
			vis[i][j] = 1;
			int cnt = 1;
			q.push({i, j});
			while (!q.empty()) {
				auto cur = q.front(); q.pop();
				for (int dir = 0; dir < 4; ++dir) {
					int nx = cur.first + dx[dir];
					int ny = cur.second + dy[dir];
					if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
					if (board[nx][ny]) {
						s.insert({nx, ny});
						continue;
					}
					if (vis[nx][ny]) continue;
					q.push({nx, ny});
					vis[nx][ny] = 1;
					cnt++;
				}
			}
			for (auto cur : s) {
				res[cur.first][cur.second] = (res[cur.first][cur.second] + cnt) % 10;
			}
		}
	}
	for (int i = 0; i < n; ++i)
		for (int j = 0; j < m; ++j)
			if (board[i][j]) res[i][j] = (res[i][j] + 1) % 10;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			cout << res[i][j];
		}
		cout << '\n';
	}
}

