#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int dp[101010][6][6];
vector<int> arr;

int cal(int oldo, int newo) {
	if (oldo == newo) return 1;
	if (oldo == 0) return 2;
	if (abs(newo - oldo) == 2) return 4;
	return 3;
}

int recur(int dep, int l, int r) {
	if (dep < 0) return 0;
	if (l != arr[dep] && r != arr[dep]) return 0;
	if (dp[dep][l][r] != 0) return dp[dep][l][r];
	dp[dep][l][r] = 1010101010;
	for (int i = 0; i <= 4; ++i) {
		if (i != r && recur(dep-1, i, r) != 0) {
			dp[dep][l][r] = min(recur(dep-1, i, r) + cal(i, l), dp[dep][l][r]);
		}
		if (i != l && recur(dep-1, l, i) != 0) {
			dp[dep][l][r] = min(recur(dep-1, l, i) + cal(i, r), dp[dep][l][r]);
		}
	}
	if (dp[dep][l][r] == 1010101010) dp[dep][l][r] = 0;
	return dp[dep][l][r];
}

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	while (1) {
		int n;
		cin >> n;
		if (n == 0) break;
		arr.push_back(n);
	}

	if (arr.size() == 0) {
		cout << 0;
		return 0;
	}
	dp[0][arr[0]][0] = 2;
	dp[0][0][arr[0]] = 2;
	int res = 2147483647;
	int temp = arr[arr.size()-1];
	for (int i = 0; i <= 4; ++i) {
		if (temp == i) continue;
		if (recur(arr.size()-1, temp, i) != 0)
			res = min(res, recur(arr.size()-1, temp, i));
		if (recur(arr.size()-1, i, temp) != 0)
			res = min(res, recur(arr.size()-1, i, temp));
	}
	cout << res;
}

