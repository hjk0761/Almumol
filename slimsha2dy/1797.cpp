#include <iostream>
#include <algorithm>
#include <map>

using namespace std;
int n, acm[1010101];
pair<int, int> arr[1010101];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 1; i <= n; ++i) {
		int a, b;
		cin >> a >> b;
		arr[i] = {b, a};
	}
	arr[0] = {0, 0};
	sort(arr, arr+n+1);
	map<int, int> m;
	int res = 0;
	m.insert({0, 0});
	for (int i = 1; i <= n; ++i) {
		if (arr[i].second == 1) acm[i] = acm[i-1] + 1;
		else acm[i] = acm[i-1] - 1;
		if (m.count(acm[i]) == 0) m.insert({acm[i], i});
		else res = max(res, arr[i].first - arr[m.at(acm[i])+1].first);
	}
	cout << res << endl;
}

