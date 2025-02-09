#include <iostream>
#include <algorithm>
#include <tuple>

using namespace std;
int n, m;
tuple<int, int, string> arr[101010];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; ++i) {
		int a;
		string b;
		cin >> a >> b;
		arr[i] = {a, i, b};
	}
	sort(arr, arr+n);
	for (int i = 0; i < n; ++i) {
		cout << get<0>(arr[i]) << ' ' << get<2>(arr[i]) << '\n';
	}
}

