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

	cout << n/5 + n/25 + n/125;
}

