#include <iostream>
using namespace std;

long long a, c;
int b;

long long times(long long number, int count) {
    if (count == 1) return number % c;

    if (count % 2 == 1) {
        return times(number, count / 2) * times(number, count / 2 + 1) % c;
    } else {
        return times(number, count / 2) * times(number, count / 2) % c;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> a >> b >> c;

    cout << times(a, b);
    return 0;
}

// 10 * 10 * 10 = 12 * 83 + 4
// 10 * 10 = 12 * 8 + 4
// (12 * 8 + 4) * 10 = 12 * 8 * 10 + 4 * 10 = 12 * 8 * 10 + 12 * 3 + 4
// 앞부분(12 * 8 * 10)은 어차피 12(나누는 수)의 배수, 뒷부분만 새로 나머지 구해도 됨

// https://www.acmicpc.net/problem/1629

// 위의 이유로 나머지를 먼저 구해도 됨. 숫자가 너무 커질 수 있으니 중간중간 나머지로 바꾸면서 진행한다!
// 하지만 중간에 모종의 이유로 숫자가 int 범위를 넘어갈까봐 보수적으로 long long 을 이용했다.
// 원하는 횟수의 곱을 구할 때 절반씩 나눠가며 구해서 한 번에 곱한다.
