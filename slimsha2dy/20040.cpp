#include <iostream>
#include <algorithm>

using namespace std;
int n, m;
int p[505050];

int find(int a) {
	if (p[a] == a) return a;
	return p[a] = find(p[a]);
}

void uni(int a, int b) {
	a = find(a);
	b = find(b);

	int m = min(a, b);
	p[a] = m;
	p[b] = m;
}

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	int res = 0;
	for (int i = 0; i < n; ++i) p[i] = i;
	for (int i = 1; i <= m; ++i) {
		int a, b;
		cin >> a >> b;
		if (res == 0 && find(a) == find(b)) {
			res = i;
		}
		uni(a, b);
	}
	cout << res;
}

