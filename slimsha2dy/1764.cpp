#include <iostream>
#include <algorithm>
#include <set>
#include <vector>

using namespace std;
int n, m;

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	set<string> s;

	while (n--) {
		string input;
		cin >> input;
		s.insert(input);
	}

	vector<string> res;
	while (m--) {
		string input;
		cin >> input;
		if (s.count(input) != 0) res.push_back(input);
	}
	cout << res.size() << '\n';
	sort(res.begin(), res.end());
	for (string str : res) cout << str << '\n';
}


