#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;
int n, m;
int arr[101010];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> arr[i];

	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	for (int i = 0; i < n; ++i) pq.push({arr[i], i});

	cin >> m;
	while (m--) {
		int a;
		cin >> a;
		if (a == 1) {
			int b, c;
			cin >> b >> c;
			int jeon = arr[b-1];
			arr[b-1] = c;
			if (jeon != c) pq.push({c, b-1});
		}
		else {
			pair<int, int> cur = pq.top();
			while (arr[cur.second] != cur.first) {
				pq.pop();
				cur = pq.top();
			}
			cout << cur.second+1 << '\n';
		}
	}
}
