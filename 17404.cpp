#include <iostream>
#include <algorithm>

using namespace std;
int n;
int arr[1010][4], dp[1010][4];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> arr[i][0] >> arr[i][1] >> arr[i][2];
	}

	int res = 1010101;
	for (int num = 0; num < 3; ++num) {
		for (int i = 0; i < 3; ++i) {
			if (num != i) dp[0][i] = 1010101;
			else dp[0][i] = arr[0][i];
		}
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < 3; ++j) {
				dp[i][j] = min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + arr[i][j];
			}
		}
		res = min(res, dp[n-1][(num+1)%3]);
		res = min(res, dp[n-1][(num+2)%3]);
	}
	cout << res;
}

