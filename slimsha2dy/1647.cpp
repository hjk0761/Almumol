#include <iostream>
#include <algorithm>
#include <tuple>

using namespace std;
int n, m;
int p[101010];
tuple<int, int, int> r[1010101];

int find(int x) {
	if (p[x] == x) return x;
	return p[x] = find(p[x]);
}

void uni(int x, int y) {
	x = find(x);
	y = find(y);
	if (x == y) return;
	p[y] = x;
}

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	for (int i = 1; i <= n; ++i) p[i] = i;
	for (int i = 0; i < m; ++i) {
		int a, b, c;
		cin >> a >> b >> c;
		r[i] = {c, a, b};
	}
	sort(r, r+m);
	int res = 0;
	int last = 0;
	for (int i = 0; i < m; ++i) {
		int a, b, c;
		tie(c, a, b) = r[i];
		if (find(a) != find(b)) {
			res += c;
			uni(a, b);
			last = c;
		}
	}
	cout << res - last;
}

