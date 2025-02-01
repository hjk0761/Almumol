#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int n;
int a[4040], b[4040], c[4040], d[4040];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; ++i) {
		int q, w, e, r;
		cin >> q >> w >> e >> r;
		a[i] = q; b[i] = w; c[i] = e; d[i] = r;
	}
	
	vector<int> v1, v2;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			v1.push_back(a[i] + b[j]);
			v2.push_back(c[i] + d[j]);
		}
	}
	sort(v1.begin(), v1.end());
	sort(v2.begin(), v2.end());

	long long res = 0;
	for (int i : v1) {
		res += upper_bound(v2.begin(), v2.end(), i * -1) - lower_bound(v2.begin(), v2.end(), i * -1);
	}
	cout << res;
}

