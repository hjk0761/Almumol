#include <iostream>
using namespace std;

int n;
int arr[63] = {0};
long long num;
int c;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    for (int i = 0; i < n; i++) {
        c = 0;
        cin >> num;
        if (num == 0) {
            continue;
        }
        while (num / 2 >= 1) {
            c++;
            num /= 2;
        }
        arr[c]++;
    }

    for (int i = 0; i < 62; i++) {
        arr[i + 1] += arr[i] / 2;
    }

    for (int i = 62; i >= 0; i--) {
        if (arr[i] > 0) {
            num = 1;
            for (int j = 0; j < i; j++) {
                num *= 2;
            }
            cout << num;
            break;
        }
    }

    return 0;
}

// 2^62 = 2^2 * (2^10)^6 ~ 4 * 10^3^6 ~ 4 * 10^18 -> long long 사용

// https://www.acmicpc.net/problem/27514

// 숫자를 읽으며 그게 2의 몇제곱인지 확인한다.
// 작은 제곱수부터 (1, 2, 4, ...) 올라가며 최대한 두 개씩 많이 짝지어서 다음 제곱수를 만든다.
// 큰 제곱수부터 내려가며 그 숫자가 있는지 확인하고, 있다면 계산해서 출력한다.
