#include <iostream>
#include <algorithm>
#include <map>

using namespace std;
int t, n;

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> t;
	while (t--) {
		cin >> n;
		map<string, int> m;
		while (n--) {
			string a, b;
			cin >> a >> b;
			m[b]++;
		}
		int res = 1;
		for (auto iter : m) {
			res *= iter.second + 1;
		}
		cout << res - 1 << '\n';
	}
}

