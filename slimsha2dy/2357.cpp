#include <iostream>
#include <cmath> 
#include <algorithm>

using namespace std;
int n, m, gae;
int so[404040], dae[404040];

int mini(int l, int r, int num, int nl, int nr) {
	if (r < nl || nr < l) return 1010101010;
	if (l <= nl && nr <= r) return so[num];
	int mid = (nl+nr)/2;
	return min(mini(l, r, num*2, nl, mid), mini(l, r, num*2+1, mid+1, nr));
}

int maxi(int l, int r, int num, int nl, int nr) {
	if (r < nl || nr < l) return 0;
	if (l <= nl && nr <= r) return dae[num];
	int mid = (nl+nr)/2;
	return max(maxi(l, r, num*2, nl, mid), maxi(l, r, num*2+1, mid+1, nr));
}

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;

	gae = 1<<(int)ceil(log2(n)+1);
	fill(so, so+gae, 1010101010);
	for (int i = gae/2; i < gae/2 + n; ++i) {
		cin >> so[i];
		dae[i] = so[i];
	}
	for (int i = gae/2-1; i > 0; --i) {
		so[i] = min(so[i*2], so[i*2+1]);
		dae[i] = max(dae[i*2], dae[i*2+1]);
	}
	while (m--) {
		int a, b;
		cin >> a >> b;
		cout << mini(a-1, b-1, 1, 0, gae/2-1) << ' ' << maxi(a-1, b-1,1, 0, gae/2-1) << '\n';
	}
}

