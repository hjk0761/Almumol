#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int n, res, d[10101];
vector<pair<int, int>> adj[10101];

int recur(int input) {
	int total = 0;
	int second = 0;
	for (pair<int, int> i : adj[input]) {
		int cur = i.second + recur(i.first);
		if (cur > d[input]) {
			second = d[input];
			d[input] = cur;
		} else {
			second = max(second, cur);
		}
	}
	res = max(d[input] + second, res);
	return d[input];
}

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n-1; ++i) {
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back({b, c});
	}

	recur(1);
	cout << res;
}

