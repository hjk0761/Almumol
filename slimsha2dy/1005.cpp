#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
int t, n, k;
int arr[1010], d[1010];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> t;
	while (t--) {
		cin >> n >> k;
		for (int i = 1; i <= n; ++i) cin >> arr[i];
		vector<int> adjo[n+1], adji[n+1];
		int ind[n+1];
		fill(ind, ind+n+1, 0);
		fill(d, d+n+1, 0);
		while (k--) {
			int a, b;
			cin >> a >> b;
			adjo[a].push_back(b);
			adji[b].push_back(a);
			ind[b]++;
		}
		int w;
		cin >> w;
		queue<int> q;
		for (int i = 1; i <= n; ++i)
			if (ind[i] == 0) q.push(i);
		while (!q.empty()) {
			int cur = q.front(); q.pop();
			for (int i : adjo[cur]) {
				ind[i]--;
				if (ind[i] == 0) q.push(i);
			}
			for (int i : adji[cur]) {
				d[cur] = max(d[cur], d[i]);
			}
			d[cur] += arr[cur];
		}
		cout << d[w] << '\n';
	}
}

