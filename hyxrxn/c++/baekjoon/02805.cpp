#include <iostream>
#include <algorithm>
using namespace std;

int n, m;
long long arr[1010101];
int answer;

long long cut(int h) {
    long long sum = 0;
    for (int i = 0; i < n; i++) {
        sum += max((long long) 0, arr[i] - h);
    }
    return sum;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int low = 0;
    int high = 1000000000;
    while(low <= high) {
        int middle = (low + high) / 2;
        if (cut(middle) >= m) {
            low = middle + 1;
            answer = middle;
        } else {
            high = middle - 1;
        }
    }

    cout << answer;
    return 0;
}

// https://www.acmicpc.net/problem/2805

// 자를 높이에 대해 이분탐색한다.
// 높이를 중간값으로 정하고, 그 높이로 잘랐을 때 잘린 나무의 길이의 합이 원하는 값 m 이상인지 확인한다.
// m 이상이라면 정답에 저장한 후 높이를 더 높여보고, 아니라면 높이를 낮춰본다.
// 이때 각 값(n, m, arr[i])은 모두 int 범위 내지만 잘린 나무의 길이의 합이 long long이 될 수 있으므로 타입에 주의한다.
