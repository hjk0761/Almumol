#include <iostream>
#include <algorithm>
#include <deque>

using namespace std;
int n, l;
int arr[5050505];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> l;
	for (int i = 0; i < n; ++i) cin >> arr[i];

	deque<pair<int, int>> dq;
	for (int i = 0; i < n; ++i) {
		while (!dq.empty() && dq.back().first >= arr[i]) dq.pop_back();
		while (!dq.empty() && dq.front().second < i-l+1) dq.pop_front();
		dq.push_back({arr[i], i});
		cout << dq.front().first << ' ';
	}
}

