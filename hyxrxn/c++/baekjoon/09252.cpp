#include <iostream>
#include <algorithm>
using namespace std;

string a, b;
int arr[1001][1001] = {0};
char answer[1001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> a >> b;

    for (int i = 1; i <= a.length(); i++) {
        for (int j = 1; j <= b.length(); j++) {
            arr[i][j] = a[i - 1] == b[j - 1] ? arr[i - 1][j - 1] + 1 : max(arr[i - 1][j], arr[i][j - 1]);
        }
    }

    int length = arr[a.length()][b.length()];
    cout << length << "\n";

    if (length == 0) {
        return 0;
    }

    int i = a.length();
    int j = b.length();
    int index = length - 1;
    while(index >= 0) {
        if (a[i - 1] == b[j - 1]) {
            answer[index] = a[i - 1];
            index--;
            i--;
            j--;
        } else {
            if (arr[i - 1][j] >= arr[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
    }

    for (int k = 0; k < length; k++) {
        cout << answer[k];
    }

    return 0;
}

// https://www.acmicpc.net/problem/9252

// arr[i][j]는 a의 앞에서부터 i글자, b의 앞에서부터 j글자까지의 정답을 저장한다.
// i번째 글자와 j번째 글자가 같으면 그 전까지의 정답에 1을 추가하고, 다르면 왼쪽과 위쪽에서 오는 값 중 큰 값을 저장한다.
// 이 과정을 역산하며 뒤에서부터 실제 LCS를 하나씩 찾는다.
// 글자가 같은지 먼저 확인하고, 같다면 그 글자를 LCS에 포함시키고 대각선 위로 이동한다.
// 다르다면 왼쪽과 위의 값을 비교하며 둘 중 큰 쪽으로 이동한다.
