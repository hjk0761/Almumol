#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

int n, m, st, en;
vector<pair<int, int>> adj[1010];
int d[1010], pre[1010];
const int INF = 1e9 + 10;

int main() {
	cin.tie(0);
	cout.tie(0);
	ios::sync_with_stdio(0);

	cin >> n >> m;
	while (m--) {
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back({c, b});
	}
	cin >> st >> en;
	fill(d, d+n+1, INF);
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
			pre[nxt.second] = cur.second;
		}
	}
	vector<int> path;
	int cur = en;
	while (cur != st) {
		path.push_back(cur);
		cur = pre[cur];
	}
	path.push_back(cur);

	cout << d[en] << '\n';
	cout << path.size() << '\n';
	for (int i = path.size()-1; i >= 0; --i)
		cout << path[i] << ' ';
}
