#include <iostream>
#include <queue>
using namespace std;

int n, m;
priority_queue<long long, vector<long long>, greater<long long> > pq;
long long answer = 0;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;
    long long dummy;
    for (int i = 0; i < n; i++) {
        cin >> dummy;
        pq.push(dummy);
    }

    long long a, b;
    for (int i = 0; i < m; i++) {
        a = pq.top();
        pq.pop();
        b = pq.top();
        pq.pop();
        pq.push(a + b);
        pq.push(a + b);
    }

    while(!pq.empty()) {
        answer += pq.top();
        pq.pop();
    }

    cout << answer;
    return 0;
}

// 10만이 천개 -> 500번 하면 20만이 천개 -> 1000번 하면 40만이 천개 -> 1500번 하면 80만이 천개
// n*500번 하면 2^n * 10만이 천개 -> 15000번 하면 n이 30, 2^30 * 10만 ~ 1000^3 * 100000 = 10^14가 10*3개, 총합 10^17, long long 사용...

// https://www.acmicpc.net/problem/15903

// 작은 수부터 두 개씩 더하는 것이 합을 최소로 만드는 방법! 그래서 우선순위 큐를 오름차순으로 이용.
// 상기 이유로 인해 자료형은 롱롱 사용.
