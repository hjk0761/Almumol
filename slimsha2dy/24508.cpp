#include <iostream>
#include <algorithm>

using namespace std;
int n, k, t;
int arr[101010];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> k >> t;
	for (int i = 0; i < n; ++i) cin >> arr[i];
	sort(arr, arr+n);
	int l = 0;
	int r = n-1;
	while (true) {
		while (arr[l] == 0) l++;
		while (arr[r] == k) r--;
		if (r < l || t == 0) break;
		int tmp = min({arr[l], k-arr[r], t});
		arr[l] -= tmp;
		arr[r] += tmp;
		t -= tmp;
	}
	if (r < l) cout << "YES";
	else cout << "NO";
}

