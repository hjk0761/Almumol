#include <iostream>
#include <algorithm>
using namespace std;

string a, b;
int arr[1001][1001] = {0};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> a >> b;

    for (int i = 1; i <= a.length(); i++) {
        for (int j = 1; j <= b.length(); j++) {
            if (a[i - 1] == b[j - 1]) {
                arr[i][j] = arr[i - 1][j - 1] + 1;
            } else {
                arr[i][j] = max(arr[i - 1][j], arr[i][j - 1]);
            }
        }
    }

    cout << arr[a.length()][b.length()];
    return 0;
}

// https://www.acmicpc.net/problem/9251

// arr[i][j]는 a의 앞에서부터 i글자, b의 앞에서부터 j글자까지의 정답을 저장한다.
// i번째 글자와 j번째 글자가 같으면 그 전까지의 정답에 1을 추가하고, 다르면 양 쪽에서 오는 값 중 큰 값을 저장한다.
