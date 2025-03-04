#include <iostream>
#include <algorithm>
#include <queue>

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

	priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
	for (int i = 0; i < n; ++i) {
		pq.push({arr[i], i});
		while (pq.top().second < i-l+1) pq.pop();
		cout << pq.top().first << ' ';
	}
}

