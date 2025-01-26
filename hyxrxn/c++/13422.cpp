#include <iostream>
using namespace std;

int t, n, m, k;
int arr[100000];
int now, answer;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> t;
    for (int i = 0; i < t; i++) {
        answer = 0;
        cin >> n >> m >> k;
        for (int j = 0; j < n; j++) {
            cin >> arr[j];
        }

        now = 0;
        for (int j = 0; j < m; j++) {
            now += arr[j];
        }

        if (n == m) {
            if (now < k) answer++;
        } else {
            for (int j = 0; j < n; j++) {
                now += arr[(j + m) % n];
                now -= arr[j];
                if (now < k) answer++;
            }
        }

        cout << answer << "\n";
    }

    return 0;
}

// https://www.acmicpc.net/problem/13422

// 0번째부터 m-1번째까지 털었을 때의 값을 초기값으로 둔다.
// 이후 다음 집을 더하고 이전 집을 빼는 방식으로 옆으로 한 칸씩 움직이며 털어도 되는지 확인한다. 집의 개수만큼!
// 그런데 전체 집과 털 집의 개수가 같으면 똑같은 계산을 집의 개수만큼 반복하게 된다... 질문 게시판 보고 알았음...
// 그래서 그럴 경우엔 초기값만 확인하고 넘어가야 한다.
