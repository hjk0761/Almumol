#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
int n, m;
vector<int> adj[32323];
int ind[32323];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	while (m--) {
		int a, b;
		cin >> a >> b;
		ind[b]++;
		adj[a].push_back(b);
	}
	queue<int> q;
	for (int i = 1; i <= n; ++i) {
		if (ind[i] == 0) q.push(i);
	}

	vector<int> res;
	while (!q.empty()) {
		int tmp = q.front(); q.pop();
		res.push_back(tmp);
		for (int i : adj[tmp]) {
			ind[i]--;
			if (ind[i] == 0) q.push(i);
		}
	}
	for (int i : res) cout << i << ' ';
}

