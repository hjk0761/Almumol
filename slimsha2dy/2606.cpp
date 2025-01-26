#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
int n, m;
vector<int> v[102];
int vis[102];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	while (m--) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	queue<int> q;
	q.push(1);
	vis[1] = 1;
	int res = 0;
	while (!q.empty()) {
		int cur = q.front(); q.pop();
		for (int i : v[cur]) {
			if (vis[i]) continue;
			q.push(i);
			vis[i] = 1;
			res++;
		}
	}

	cout << res;
}


