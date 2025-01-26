#include <iostream>
using namespace std;

int n;
long long t;
int arr[101];
int p[102];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> t;
    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
    }

    int now = 1;
    int index = 1;
    int start, count;
    long long tt = t;
    bool flag = true;
    while (flag && tt > 0) {
        now = arr[now];
        for (int i = 1; i < index; i++) {
            if (p[i] == now) {
                start = i;
                count = index - i;
                flag = false;
                break;
            }
        }
        p[index] = now;
        index++;
        tt--;
    }

    if (tt == 0) {
        cout << now;
        return 0;
    }

    t -= start;
    t %= count;
    t += start;
    cout << p[t];
    return 0;
}

// https://www.acmicpc.net/problem/32248

// 다음 사람 지목을 하며 순서를 배열에 저장한다. 이때 앞에 이미 지목을 당했었는지(배열에 이미 존재하는지) 확인한다.
// 이미 지목을 당했다면 사이클이 생긴 것이므로 사이클의 시작 지점과 사이클 구성 요소의 개수를 세 나머지 연산으로 사이클의 몇 번째 사람이 패배했는지 계산한다. (flag로 확인)
// 사이클이 생기기 전에 지목이 끝났다면 마지막 사람을 패배자로 출력한다. (tt로 확인)
