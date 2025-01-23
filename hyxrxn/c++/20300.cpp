#include <iostream>
#include <algorithm>
using namespace std;

int n;
long long arr[10001];
long long maxi = 0;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    sort(arr, arr + n);

    if (n % 2 == 1) {
        maxi = arr[n - 1];
        n--;
    }
    for (int i = 0; i < n / 2; i++) {
        maxi = max(maxi, arr[i] + arr[n - 1 - i]);
    }

    cout << maxi;
    return 0;
}

// https://www.acmicpc.net/problem/20300

// 기본적으로 제일 근손실이 많이 나는 기구와 제일 근손실이 적게 나는 기구를 짝지어야 합의 최댓값이 가장 작을 수 있다.
// 그런데 운동기구가 홀수개 있는 경우에는 하나를 따로 고를 수 있다.
// 이때는 제일 근손실이 많이 나는 기구를 따로 골라야한다.
