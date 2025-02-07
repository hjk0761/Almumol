#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;
int n, arr[1010101];
int idx[1010101];
vector<int> v;

void recur(int input, int st) {
	if (input < 0) return;
	while (idx[st] != input) {
		st--;
	}
	recur(input-1, st);
	cout << arr[st] << ' ';
}

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; ++i) cin >> arr[i];
	
	v.push_back(arr[0]);
	idx[0] = 0;
	for (int i = 1; i < n; ++i) {
		if (arr[i] > v.back()) {
			v.push_back(arr[i]);
			idx[i] = v.size()-1;
		}
		else {
			int cur = lower_bound(v.begin(), v.end(), arr[i]) - v.begin();
			v[cur] = arr[i];
			idx[i] = cur;
		}
	}

	cout << v.size() << '\n';
	recur(v.size()-1, n-1);
}

