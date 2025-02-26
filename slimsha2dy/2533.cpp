#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
int n, dp[1010101][2];
vector<int> adj[1010101];

int recur(int n, int flag, int p) {
	if (dp[n][flag]) return dp[n][flag];
	if (flag == 0) {
		for (int i : adj[n]) {
			if (i == p) continue;
			dp[n][0] += recur(i, 1, n);
		}
	}
	else {
		dp[n][1] = 1;
		for (int i : adj[n]) {
			if (i == p) continue;
			dp[n][1] += min(recur(i, 0, n), recur(i, 1, n));
		}
	}
	return dp[n][flag];
}

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n-1; ++i) {
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}

	cout << min(recur(1, 0, 0), recur(1, 1, 0));
}

