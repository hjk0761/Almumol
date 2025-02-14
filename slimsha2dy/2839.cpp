#include <iostream>
#include <algorithm>

using namespace std;
int n;

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;

	int tmp = 0;
	while (true) {
		if (n % 5 == 0) {
			cout << (n / 5) + tmp;
			return 0;
		}
		n -= 3;
		tmp++;
		if (n < 0) {
			cout << -1;
			return 0;
		}
	}
}

