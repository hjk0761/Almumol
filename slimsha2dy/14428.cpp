#include <iostream>
#include <cmath> 
#include <algorithm>

using namespace std;
int n, m, gae;
pair<int, int> arr[404040];

pair<int, int> sum(int l, int r, int num, int nl, int nr) {
	if (r < nl || nr < l) return {1010101010, num};
	if (l <= nl && nr <= r) return arr[num];
	int mid = (nl+nr)/2;
	return min(sum(l, r, num*2, nl, mid), sum(l, r, num*2+1, mid+1, nr));
}

void update(int i, int val) {
	i += gae/2;
	arr[i] = {val, i-gae/2+1};
	while (i > 1) {
		i /= 2;
		arr[i] = min(arr[i*2], arr[i*2+1]);
	}
}

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	gae = 1<<(int)ceil(log2(n)+1);
	for (int i = 0; i < gae; ++i) arr[i] = {1010101010, i};
	for (int i = gae/2; i < gae/2 + n; ++i) {
		int a;
		cin >> a;
		arr[i] = {a, i-gae/2+1};
	}
	for (int i = gae/2-1; i > 0; --i)
		arr[i] = min(arr[i*2], arr[i*2+1]);
	cin >> m;
	while (m--) {
		int a, b, c;
		cin >> a >> b >> c;
		if (a == 1) update(b-1, c);
		else cout << sum(b-1, c-1, 1, 0, gae/2-1).second << '\n';
	}
}

