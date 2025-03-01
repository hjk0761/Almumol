#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;
int n, m, k;
vector<pair<long long, long long>> adj[101010];
long long d[101010]; 
const long long INF = 1e18;

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m >> k;
	while (m--) {
		int u, v, w;
		cin >> u >> v >> w;
		adj[v].push_back({w, u});
	}
	fill(d, d+n+1, INF);
	priority_queue<pair<long long, long long>, vector<pair<long long, long long>>, greater<pair<long long, long long>>> pq;
	for (int i = 0; i < k; ++i) {
		int tmp;
		cin >> tmp;
		d[tmp] = 0;
		pq.push({d[tmp], tmp});
	}
	while (!pq.empty()) {
		auto cur = pq.top(); pq.pop();
		if (d[cur.second] < cur.first) continue;
		for (auto nxt : adj[cur.second]) {
			if (d[nxt.second] <= d[cur.second] + nxt.first) continue;
			d[nxt.second] = d[cur.second] + nxt.first;
			pq.push({d[nxt.second], nxt.second});
		}
	}

	long long ret = 0;
	long long reti = 0;
	for (int i = 1; i <= n; ++i) {
		if (ret < d[i]) {
			ret = d[i];
			reti = i;
		}
	}
	cout << reti << '\n' << ret;
}

