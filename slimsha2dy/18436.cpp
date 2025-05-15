#include <iostream>
#include <cmath> 
#include <algorithm>

using namespace std;
int n, m, gae;
int arr[404040], jak[404040], hol[404040];

int sum(int l, int r, int num, int nl, int nr, bool is_jak) {
	if (r < nl || nr < l) return 0;
	if (l <= nl && nr <= r) {
		if (is_jak) return jak[num];
		else return hol[num];
	}
	int mid = (nl+nr)/2;
	return sum(l, r, num*2, nl, mid, is_jak) + sum(l, r, num*2+1, mid+1, nr, is_jak);
}

void update(int i, int val) {
	i += gae/2;
	arr[i] = val;
	if (val % 2 == 0) {
		jak[i] = 1;
		hol[i] = 0;
	}
	else {
		jak[i] = 0;
		hol[i] = 1;
	}
	while (i > 1) {
		i /= 2;
		jak[i] = jak[i*2] + jak[i*2+1];
		hol[i] = hol[i*2] + hol[i*2+1];
	}
}

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	gae = 1<<(int)ceil(log2(n)+1);
	for (int i = gae/2; i < gae/2+n; ++i) {
		cin >> arr[i];
		if (arr[i] % 2 == 0) jak[i] = 1;
		else hol[i] = 1;
	}
	for (int i = gae/2-1; i > 0; --i) {
		jak[i] = jak[i*2] + jak[i*2+1];
		hol[i] = hol[i*2] + hol[i*2+1];
	}

	cin >> m;
	while (m--) {
		int a, b, c;
		cin >> a >> b >> c;
		if (a == 1) update(b-1, c);
		else if (a == 2) cout << sum(b-1, c-1, 1, 0, gae/2-1, 1) << '\n';
		else cout << sum(b-1, c-1, 1, 0, gae/2-1, 0) << '\n';
	}
}

