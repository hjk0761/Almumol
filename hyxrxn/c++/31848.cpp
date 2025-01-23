#include <iostream>
using namespace std;

int n, q;
int h;
int maxi;
int s[100001];
int now;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    cin >> maxi;
    for (int i = 1; i <= maxi; i++) {
        s[i] = 1;
    }
    for (int i = 2; i <= n; i++) {
        cin >> h;
        h += i - 1;
        if (h > maxi) {
            for (int j = maxi + 1; j <= h && j <= n; j++) {
                s[j] = i;
            }
            maxi = h;
        }
    }

    cin >> q;
    for (int i = 0; i < q; i++) {
        cin >> now;
        cout << s[now] << " ";
    }

    return 0;
}

//https://www.acmicpc.net/problem/31848

// 각 사이즈별로 몇 번째 구멍에서 걸러지는지 미리 계산하여 저장. (s[i]는 도토리의 크기가 i일 때 그게 몇 번째 구멍에서 나가는지)
// 다음 구멍이 되며 최대 사이즈가 갱신되면 이전의 최대 사이즈 이후부터 현재 최대 사이즈까지 그 구멍이 몇 번째인지를 저장.
// 이때 구멍이 i번째이면 그 구멍의 크기에 i - 1을 더해야 함. 굴러오면서 그만큼 작아지니까.
