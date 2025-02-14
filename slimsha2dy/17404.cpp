#include <iostream>
#include <algorithm>

using namespace std;
int n, arr[1010][5];
int dp[1010][5];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n-1; ++i)
		cin >> arr[i][0] >> arr[i][1] >> arr[i][2];

	for (int i = 0; i < n-1; ++i) {
		for (int j = 0; j < 3; ++j) {
			dp[i][j] = min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + arr[i][j];
		}
	}
	fill(dp[n-1], dp[n-1] + 3, 2020202);
	for (int i = 0; i < 3; ++i) {
		int tmp[3];
		cin >> tmp[0] >> tmp[1] >> tmp[2];
		for (int j = 0; j < 3; ++j) {
			if (j == i) continue;
			dp[n-1][i] = min(dp[n-1][i], dp[n-2][j] + tmp[i]);
		}
	}
	cout << *min_element(dp[n-1], dp[n-1] + 3);
}

