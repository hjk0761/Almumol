#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int n, m;

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	vector<int> v;
	for (int i = 1; i <= n; ++i) v.push_back(i);
	cout << '<';
	int idx = 0;
	while (!v.empty()) {
		idx += m-1;
		idx %= v.size();
		cout << v[idx];
		if (v.size() != 1) cout << ", ";
		else cout << ">";
		v.erase(v.begin()+idx);
	}
}

