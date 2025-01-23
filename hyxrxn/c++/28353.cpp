#include <iostream>
#include <algorithm>
using namespace std;

int n, k;
int arr[5000];
int pick[5000] = {0};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    sort(arr, arr + n);

    int answer = 0;
    for (int i = n - 1; i > 0; i--) {
        if (pick[i] == 0) {
            for (int j = i - 1; j >= 0; j--) {
                if (pick[j] == 0 && arr[i] + arr[j] <= k) {
                    answer++;
                    pick[i] = 1;
                    pick[j] = 1;
                    break;
                }
            }
        }
    }

    cout << answer;
    return 0;
}

// https://www.acmicpc.net/problem/28353

// 고양이 무게를 크기순으로 정렬하고, 가장 무거운 고양이부터 다른 고양이랑 함께 올릴 수 있는지 확인한다.
// 이때 다른 고양이도 무거운 순으로 확인한다.
// 무거운 애들끼리 무릎에 먼저 올려야 나머지는 더 편하게 올릴 수 있기 때문.
// 고양이를 올렸는지 여부를 확인해 안 올린 고양이들만 반복한다.
