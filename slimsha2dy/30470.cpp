#include <iostream>
#include <algorithm>
#include <stack>

using namespace std;
int n, m;

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	stack<pair<long long, long long>> s;
	while (n--) {
		int a, b;
		cin >> a >> b;
		s.push({a, b});
	}

	long long res = 0;
	long long alt = -1;
	while (!s.empty()) {
		auto cur = s.top(); s.pop();
		if (cur.first == 1) {
			if (alt == -1) res += cur.second;
			else if (alt < cur.second) res += alt;
			else {
				res += cur.second;
				alt = -1;
			}
		}
		else {
			if (s.empty()) break;
			long long val = cur.second;
			auto nxt = s.top(); s.pop();
			while (!s.empty() && nxt.first == 2) {
				val += nxt.second;
				nxt = s.top(); s.pop();
			}
			if (alt == -1 || alt > nxt.second - val) alt = max(0LL, nxt.second - val);
			res += alt;
		}
	}
	cout << res;
}

