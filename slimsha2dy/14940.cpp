#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;
int n, m;
int board[1010][1010];
int vis[1010][1010];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	pair<int, int> st;
	for (int i = 0; i < n; ++i) fill(vis[i], vis[i]+m, -1);
	for (int i = 0; i < n; ++i)
		for (int j = 0; j < m; ++j) {
			cin >> board[i][j];
			if (board[i][j] == 2) st = {i, j};
			if (board[i][j] == 0) vis[i][j] = 0;
		}

	queue<pair<int, int>> q;
	q.push(st);
	vis[st.first][st.second] = 0;
	while (!q.empty()) {
		pair<int, int> cur = q.front(); q.pop();
		for (int dir = 0; dir < 4; ++dir) {
			int nx = cur.first + dx[dir];
			int ny = cur.second + dy[dir];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			if (vis[nx][ny] != -1) continue;
			vis[nx][ny] = vis[cur.first][cur.second] + 1;
			q.push({nx, ny});
		}
	}

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			cout << vis[i][j] << ' ';
		}
		cout << '\n';
	}
}

