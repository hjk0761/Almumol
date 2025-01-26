#include <iostream>
#include <algorithm>
#include <set>

using namespace std;
int n;
int arr[22];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	set<int> s;
	while (n--) {
		string input;
		int i;
		cin >> input;
		if (input == "all") {
			for (int i = 1; i <= 20; ++i) arr[i] = 1;
			continue;
		} else if (input == "empty") {
			for (int i = 1; i <= 20; ++i) arr[i] = 0;
			continue;
		}
		cin >> i;
		if (input == "add") {
			arr[i] = 1;
		} else if (input == "remove") {
			arr[i] = 0;
		} else if (input == "check") {
			cout << arr[i] << '\n';
		} else if (input == "toggle") {
			arr[i] = !arr[i];
		}
	}
}

