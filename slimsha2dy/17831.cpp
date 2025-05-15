#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int n, arr[202020];
long long dp[202020][2];
vector<int> adj[202020];

// i번이 루트인 서브트리에서 최대 실적
// 자기가 멘토면 flag = 1
long long recur(int i, int flag) {
	if (dp[i][flag]) return dp[i][flag];
	long long total = 0;
	for (int cur : adj[i]) {
		total += max(recur(cur, 0), recur(cur, 1));
	}
	if (flag == 0) {
		long long tmp = 0;
		for (int cur : adj[i])
			tmp += max(recur(cur, 0), recur(cur, 1));
		dp[i][flag] = tmp;
	}
	else {
		for (int j : adj[i]) {
			long long tmp = 0;
			tmp += recur(j, 0);
			tmp += total - max(recur(j, 0), recur(j, 1));
			tmp += (long long) arr[i] * arr[j];
			dp[i][flag] = max(dp[i][flag], tmp);
		}
	}

	return dp[i][flag];
}

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 2; i <= n; ++i) {
		int tmp;
		cin >> tmp;
		adj[tmp].push_back(i);
	}

	for (int i = 1; i <= n; ++i) cin >> arr[i];
	cout << max(recur(1, 0), recur(1, 1));
}

