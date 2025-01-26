#include <iostream>
#include <stack>
#include <utility>
using namespace std;

int n;
stack<pair<int, int>> s; // 숫자, 위치
int answer[1000001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    for (int i = 0; i < n; i++) {
        answer[i] = -1;
    }
    int num;
    for (int i = 0; i < n; i++) {
        cin >> num;
        while(!s.empty() && s.top().first < num) {
            answer[s.top().second] = num;
            s.pop();
        }
        s.push({num, i});
    }

    for (int i = 0; i < n; i++) {
        cout << answer[i] << " ";
    }
    return 0;
}

// https://www.acmicpc.net/problem/17298

// 쌓여있던 애들중에 나보다 작은 애들은 결정이 된다.
// 스택에 넣으면서 탑만 확인하고, 나보다 작다면 걔의 답은 나로 결정!
// 탑이 나보다 큰데 그 밑에 나보다 작은 애가 있을 수는 없음. 걔는 이미 탑이 들어올 때 결정되는 애니까.
// 그러기 위해서 각 애들의 숫자와 걔의 위치를 같이 저장하고, 제일 처음에 각 위치별 답은 -1로 초기화해둔다.
