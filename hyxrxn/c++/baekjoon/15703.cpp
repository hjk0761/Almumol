#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int n;
int d[1000];
int c = 0;
priority_queue<int, vector<int>, greater<int> > pq;
int now;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> d[i];
    }
    sort(d, d + n);

    pq.push(1);
    for (int i = 1; i < n; i++) {
        if (d[i] < pq.top()) {
            pq.push(1);
        } else {
            now = pq.top();
            pq.pop();
            pq.push(now + 1);
        }
    }

    cout << pq.size();

    return 0;
}

// https://www.acmicpc.net/problem/15703

// 주사위의 숫자를 작은 순으로 정렬한다.
// 탑의 높이를 저장하며 가장 낮은 탑의 아래에 쌓을 수 있는지 확인한다.
// 쌓을 수 있으면 해당 탑의 높이를 1 증가시키고, 쌓을 수 없으면 새로운 탑을 만든다.
