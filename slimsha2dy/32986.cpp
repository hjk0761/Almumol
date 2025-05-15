#include <iostream>
#include <algorithm>

using namespace std;
int x, y, z;

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> x >> y >> z;
	int tmp = min({x, y, z});
	if (x == 3 && y == 3 && z == 3) cout << 0;
	else cout << (tmp-1) / 2;
}

