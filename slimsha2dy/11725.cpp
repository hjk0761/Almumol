#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
int n;
int p[101010], vis[101010];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	vector<int> v[101010];
	for (int i = 0; i < n-1; ++i) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	queue<int> q;
	q.push(1);
	vis[1] = 1;
	while (!q.empty()) {
		int cur = q.front(); q.pop();
		for (int i : v[cur]) {
			if (vis[i]) continue;
			p[i] = cur;
			q.push(i);
			vis[i] = 1;
		}
	}
	for (int i = 2; i <= n; ++i) cout << p[i] << '\n';
}

