#include <functional>
#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;
int v, e, st;
vector<pair<int, int>> adj[20202];
int d[20202];
const int INF = 1e9+10;

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> v >> e;
	cin >> st;
	fill(d, d+v+1, INF);
	while (e--) {
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back({c, b});
	}
	d[st] = 0;
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

	pq.push({d[st], st});
	while (!pq.empty()) {
		auto cur = pq.top(); pq.pop();
		if (d[cur.second] != cur.first) continue;
		for (auto nxt : adj[cur.second]) {
			if (d[nxt.second] <= cur.first + nxt.first) continue;
			d[nxt.second] = cur.first + nxt.first;
			pq.push({d[nxt.second], nxt.second});
		}
	}

	for (int i = 1; i <= v; ++i) {
		if (d[i] == INF) cout << "INF\n";
		else cout << d[i] << '\n';
	}
}

