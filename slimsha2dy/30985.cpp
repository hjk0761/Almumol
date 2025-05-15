#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;
using ll = long long;
int n, m, k;
vector<pair<ll, ll>> adj[101010];
long long d1[101010], d2[101010], arr[101010];
const ll INF = 1e18;

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m >> k;
	while (m--) {
		ll u, v, c;
		cin >> u >> v >> c;
		adj[u].push_back({c, v});
		adj[v].push_back({c, u});
	}
	for (int i = 1; i <= n; ++i) cin >> arr[i];

	fill(d1, d1+n+1, INF);
	priority_queue<pair<ll, ll>, vector<pair<ll, ll>>, greater<pair<ll, ll>>> pq;
	d1[1] = 0;
	pq.push({d1[1], 1});
	while (!pq.empty()) {
		auto cur = pq.top(); pq.pop();
		if (d1[cur.second] != cur.first) continue;
		for (auto nxt : adj[cur.second]) {
			if (d1[nxt.second] <= d1[cur.second] + nxt.first) continue;
			d1[nxt.second] = d1[cur.second] + nxt.first;
			pq.push({d1[nxt.second], nxt.second});
		}
	}
	fill(d2, d2+n+1, INF);
	priority_queue<pair<ll, ll>, vector<pair<ll, ll>>, greater<pair<ll, ll>>> pq2;
	d2[n] = 0;
	pq2.push({d2[n], n});
	while (!pq2.empty()) {
		auto cur = pq2.top(); pq2.pop();
		if (d2[cur.second] != cur.first) continue;
		for (auto nxt : adj[cur.second]) {
			if (d2[nxt.second] <= d2[cur.second] + nxt.first) continue;
			d2[nxt.second] = d2[cur.second] + nxt.first;
			pq2.push({d2[nxt.second], nxt.second});
		}
	}
	ll res = INF;
	for (int i = 1; i <= n; ++i) {
		if (arr[i] == -1) continue;
		res = min(res, d1[i] + d2[i] + (arr[i] * (k-1)));
	}
	if (res == INF) cout << -1;
	else cout << res;
}

