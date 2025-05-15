#include <iostream>
#include <algorithm>

using namespace std;
int n;
int dp[4040][111][11];
bool vis[4040][111][11];
int maxi = 1000000000;


int recur(int bit, int cnt, int last) {
	if (vis[bit][cnt][last]) return dp[bit][cnt][last];
	vis[bit][cnt][last] = 1;
	if ((bit & (1 << last)) == 0) return 0;
	if (cnt == 1) return dp[bit][cnt][last];
	long long res = 0;
	int newbit = bit ^ (1 << last);
	if (last+1 < 10) {
		res = (res + recur(bit, cnt-1, last+1)) % maxi;
		res = (res + recur(newbit, cnt-1, last+1)) % maxi;
	}
	if (last-1 >= 0) {
		res = (res + recur(bit, cnt-1, last-1)) % maxi;
		res = (res + recur(newbit, cnt-1, last-1)) % maxi;
	}
	dp[bit][cnt][last] = res;
	return res;
}

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	long long res = 0;
	for (int i = 1; i < 10; ++i) dp[1<<i][1][i] = 1;
	for (int i = 0; i < 10; ++i) {
		res = (res + recur(1023, n, i)) % maxi;
	}
	cout << res;
}

