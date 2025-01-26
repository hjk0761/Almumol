#include <iostream>
#include <algorithm>
#include <map>

using namespace std;
long long t, n, m;
long long a[1010], b[1010], aa[1010], bb[1010];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> t;
	cin >> n;
	for (int i = 1; i <= n; ++i) cin >> a[i];
	cin >> m;
	for (int i = 1; i <= m; ++i) cin >> b[i];
	for (int i = 1; i <= n; ++i) aa[i] = aa[i-1] + a[i];
	for (int i = 1; i <= m; ++i) bb[i] = bb[i-1] + b[i];

	long long res = 0;
	map<long long, long long> ma;
	for (int i = 1; i <= n; ++i) {
		for (int j = 0; j < i; ++j) {
			long long cur = aa[i] - aa[j];
			ma[cur]++;
		}
	}
	for (int i = 1; i <= m; ++i) {
		for (int j = 0; j < i; ++j) {
			long long cur = bb[i] - bb[j];
			res += ma[t - cur];
		}
	}
	cout << res;
}

