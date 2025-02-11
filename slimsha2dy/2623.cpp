#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;
int n, m;
vector<int> adj[1010];
int ind[1010];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	while (m--) {
		int size;
		cin >> size;
		vector<int> nums;
		int num;
		while (size--) {
			cin >> num;
			nums.push_back(num);
		}
		for (int i = 0; i < nums.size()-1; ++i) {
			adj[nums[i]].push_back(nums[i+1]);
			ind[nums[i+1]]++;
		}
	}

	queue<int> q;
	for (int i = 1; i <= n; ++i) {
		if (ind[i] == 0) q.push(i);
	}
	vector<int> res;
	while (!q.empty()) {
		int tmp = q.front(); q.pop();
		res.push_back(tmp);
		for (int i : adj[tmp]) {
			ind[i]--;
			if (ind[i] == 0) q.push(i);
		}
	}
	if (res.size() != n) cout << 0;
	else for (int i : res) cout << i << '\n';
}

