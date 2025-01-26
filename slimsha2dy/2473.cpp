#include <iostream>
#include <algorithm>

using namespace std;
int n;
long long arr[5050];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; ++i) cin >> arr[i];
	sort(arr, arr+n);

	long long res = 3000000000;
	int ans1, ans2, ans3;
	for (int i = 0; i < n-2; ++i) {
		int l = i+1;
		int r = n-1;
		while (l < r) {
			long long cur = arr[i] + arr[l] + arr[r];
			if (abs(cur) < res) {
				res = abs(cur);
				ans1 = arr[i];
				ans2 = arr[l];
				ans3 = arr[r];
			}
			long long a = arr[i] + arr[l+1] + arr[r];
			long long b = arr[i] + arr[l] + arr[r-1];
			if (abs(a) < abs(b)) l++;
			else r--;
		}
	}
	cout << ans1 << ' ' << ans2 << ' ' << ans3;
}

