#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
int n, m, v;
vector<int> adj[1010];
bool vis1[1010], vis2[1010];

void dfs(int i) {
	cout << i << ' ';
	for (int j : adj[i]) {
		if (vis1[j]) continue;
		vis1[j] = 1;
		dfs(j);
	}
}

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m >> v;
	for (int i = 0; i < m; ++i) {
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}
	for (int i = 1; i <= n; ++i) {
		sort(adj[i].begin(), adj[i].end());
	}

	vis1[v] = 1;
	dfs(v);
	cout << '\n';

	queue<int> q;
	q.push(v);
	vis2[v] = 1;
	while (!q.empty()) {
		int tmp = q.front(); q.pop();
		cout << tmp << ' ';
		for (int j : adj[tmp]) {
			if (vis2[j]) continue;
			vis2[j] = 1;
			q.push(j);
		}
	}
}

