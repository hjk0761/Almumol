#include <vector>
#include <iostream>
#include <algorithm>
#include <stack>

using namespace std;
int n, arr[1010101];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	for (int i = 0; i < n; ++i) cin >> arr[i];

	stack<int> s;
	vector<int> v;
	for (int i = n-1; i >= 0; --i) {
		while (!s.empty() && s.top() <= arr[i]) s.pop();
		if (s.empty()) v.push_back(-1);
		else v.push_back(s.top());
		s.push(arr[i]);
	}

	for (int i = v.size()-1; i >= 0; --i) cout << v[i] << ' ';
}

