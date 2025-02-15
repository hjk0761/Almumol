#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;
int n;
int arr[303030];

int	main(int argc, char **argv)
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;
	if (n == 0) {
		cout << 0;
		return 0;
	}
	for (int i = 0; i < n; ++i) cin >> arr[i];

	double m = (double) n;
	int jeol = round(m * 0.15);
	double total = 0;
	sort(arr, arr+n);
	for (int i = jeol; i < n - jeol; ++i) {
		total += arr[i];
	}
	total /= (double) (n - 2*jeol);
	cout << round(total);
}

