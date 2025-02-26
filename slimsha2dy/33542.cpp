#include <bits/stdc++.h>

using namespace std;
int n, m;
pair<int,int> l[505050], r[505050];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int a, b;
	cin >> a >> b;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		int x, y;
		cin >> x >> y;
		l[i] = {x, i};
		r[i] = {y, i};
	}
	m = a - b;
	if (a < b) {
		cout << "-1 -1";
		return 0;
	}

	pair<int, int> ret;
	int total = 2147483647;
	for (int i = 0; i < n; ++i) {
		if (m < r[i].first && total > r[i].first) {
			total = r[i].first;
			ret = {-1, r[i].second+1};
		}
		if (m < l[i].first && total > l[i].first) {
			total = l[i].first;
			ret = {l[i].second+1, -1};
		}
	}

	sort(r, r+n);
	for (pair<int, int> p : l) {
		int tmp = m - p.first + 1;
		auto res = lower_bound(r, r+n, make_pair(tmp, 0));
		if (res >= r+n) continue;
		if (res->second == p.second) res++;
		if (res >= r+n) continue;
		if (total > p.first + res->first) {
			total = p.first + res->first;
			ret = {p.second+1, res->second + 1};
		}
	}

	if (total == 2147483647) cout << "No";
	else cout << ret.first << ' ' << ret.second;
}

