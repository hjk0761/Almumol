#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>

using namespace std;
int n;
vector<char> v;
stack<int> s;

void recur() {
	if (s.empty()) return;
	char tmp = s.top(); s.pop();
	if (tmp == 'U') {
		v.push_back('S');
		v.push_back('N');
		while (s.top() != 'S')
			recur();
		s.pop();
		v.push_back('N');
	}
	else if (tmp == 'S') {
		v.push_back('U');
		v.push_back('N');
		while (s.top() != 'U')
			recur();
		s.pop();
		v.push_back('N');
	}
}

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	string str;
	cin >> n;
	cin >> str;

	for (char c : str) s.push(c);
	while (!s.empty()) recur();
	cout << v.size() << '\n';
	for (char c : v) cout << c;
}

