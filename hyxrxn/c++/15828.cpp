#include <iostream>
#include <queue>
using namespace std;

int n, num;
queue<int> q;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> num;

    while(num != -1) {
        if (num == 0) {
            q.pop();
        } else if (q.size() < n) {
            q.push(num);
        }
        cin >> num;
    }

    if (q.empty()) {
        cout << "empty";
        return 0;
    }

    while(!q.empty()) {
        num = q.front();
        q.pop();
        cout << num << " ";
    }

    return 0;
}

// https://www.acmicpc.net/problem/15828

// 앞에서부터 처리해야 하므로 큐를 사용한다.
// 처리한 것인지 먼저 확인해 처리했다면(입력이 0이라면) 큐에서 하나를 내보낸다.
// 아니라면 버퍼가 가득 찼는지 확인해 차지 않았다면 버퍼에 넣고, 찼다면 무시한다.
// 이것을 -1이 입력될 때까지 반복한다.
// 마지막에 큐가 비었다면 empty를 출력하고, 아니라면 앞에서부터 내보내며 출력한다.
