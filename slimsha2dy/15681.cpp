#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int n, r, q;
int d[101010], vis[101010];
vector<int> v[101010];

int cal_child(int input) {
	vis[input] = 1;
	if (v[input].size() == 0) {
		d[input] = 1;
		return 1;
	}
	int res = 1;
	for (int i : v[input]) {
		if (vis[i]) continue;
		res += cal_child(i);
	}
	d[input] = res;
	return res;
}

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> r >> q;
	for (int i = 0; i < n-1; ++i) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	cal_child(r);

	while (q--) {
		int input;
		cin >> input;
		cout << d[input] << '\n';
	}
}

