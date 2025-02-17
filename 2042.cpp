#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;
int n, m, k, gae;
long long arr[4040404];

long long sum(int l, int r, int num, int nl, int nr) {
	if (r < nl || nr < l) return 0;
	if (l <= nl && nr <= r) return arr[num]; 
	int mid = (nl + nr) / 2;
	return sum(l, r, num*2, nl, mid) + sum(l, r, num*2+1, mid+1, nr);
}

void update(int i, long long val) {
	i += gae/2;
	arr[i] = val;
	while (i > 1) {
		i /= 2;
		arr[i] = arr[i*2] + arr[i*2 + 1];
	}
}

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m >> k;
	gae = 1<<(int)ceil(log2(n) + 1);
	for (int i = gae/2; i < gae/2+n; ++i) cin >> arr[i];
	for (int i = gae/2-1; i > 0; --i) arr[i] = arr[i*2] + arr[i*2 + 1];
	int t = m + k;
	while (t--) {
		long long a, b, c;
		cin >> a >> b >> c;
		if (a == 1) update(b-1, c);
		else cout << sum(b-1, c-1, 1, 0, gae/2-1) << '\n';
	}
}

