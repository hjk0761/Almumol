#include <iostream>
#include <algorithm>

using namespace std;
int n;
int arr[1010], dp1[1010], dp2[1010];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 1; i <= n; ++i) cin >> arr[i];
	for (int i = 1; i <= n; ++i) {
		for (int j = i; j >= 0; --j) {
			if (arr[j] < arr[i]) dp1[i] = max(dp1[i], dp1[j] + 1);
		}
	}
	for (int i = n; i >= 1; --i) {
		for (int j = i; j <= n+1; ++j) {
			if (arr[j] < arr[i]) dp2[i] = max(dp2[i], dp2[j] + 1);
		}
	}
	int res = 0;
	for (int i = 1; i <= n; ++i) {
		res = max(res, dp1[i] + dp2[i] - 1);
	}
	cout << res;
}

